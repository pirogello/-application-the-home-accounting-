package individualFinance.model;

import individualFinance.saveLoad.SaveData;

import java.util.HashMap;
import java.util.List;

public class Statistics {


    public static double getBalanceCurrency(Currency currency){
        double amount = 0;
        for (Account account: SaveData.getInstance().getAccounts()) {
            if(account.getCurrency().equals(currency))
                amount += account.getAmount();
        }
        return amount;
    }

    public static double getBalance(Currency currency){
        double amount = 0;
        for (Account account: SaveData.getInstance().getAccounts()) {
                amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }

    private static HashMap<String, Double> getDataForChartOnArticles(boolean income){
        List<Transaction> transaction = SaveData.getInstance().getFilterTransaction();
        HashMap<String, Double> dat = new HashMap();
        for (Transaction t: transaction) {
            if((income && t.getAmount() > 0) || (!income && t.getAmount() < 0)){
                double sum = 0;
                double amount = t.getAmount();
                if(!income) amount *= -1;
                if(dat.containsKey(t.getArticle().getTitle())) sum = dat.get(t.getArticle().getTitle());
                sum += amount * t.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                dat.put(t.getArticle().getTitle(), round(sum));
            }
        }
        return dat;
    }

    private static double round (double val){
        return (double) Math.round(val*100) / 100;
    }


    public static HashMap<String, Double> getDataForChartOnIncomeArticles(){
        return getDataForChartOnArticles(true);
    }

    public static HashMap<String, Double> getDataForChartOnExpArticles(){
        return getDataForChartOnArticles(false);
    }
}
