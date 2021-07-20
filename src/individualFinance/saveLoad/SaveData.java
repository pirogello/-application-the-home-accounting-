package individualFinance.saveLoad;

import individualFinance.exeption.ModelExeption;
import individualFinance.model.*;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

public final class SaveData {


    private List<Article> articles= new ArrayList();
    private List<Account> accounts= new ArrayList();
    private List<Currency> currencies= new ArrayList();
    private List<Transaction> transactions= new ArrayList();
    private List<Transfer> transfers= new ArrayList();

    private Common oldCommon;
    private final Filter filter = new Filter();
    private static SaveData instance;

    private SaveData(){}

    public static SaveData getInstance(){
        if(instance == null) instance = new SaveData();
        return instance;
    }

    public void clear(){
        articles = null;
        accounts = null;
        currencies = null;
        transactions = null;
        transfers = null;
    }

    private void sort(){
        this.articles.sort((Article a,Article a1) -> a.getTitle().compareToIgnoreCase(a1.getTitle()));
        this.accounts.sort((Account a,Account a1) -> a.getTitle().compareToIgnoreCase(a1.getTitle()));
        this.transactions.sort((Transaction t,Transaction t1) -> t1.getDate().compareTo(t.getDate()));
        this.transfers.sort((Transfer t,Transfer t1) -> t1.getDate().compareTo(t.getDate()));
        this.currencies.sort((Currency c, Currency c1) -> {
                if(c.isBase())
                    return -1;
                if(c1.isBase())
                    return 1;
                if(c.isOn() ^ c1.isOn()){
                    if(c.isOn()) return -1;
                    if(c1.isOn()) return 1;
                }
                return c.getTitle().compareToIgnoreCase(c1.getTitle());
        });
    }

    public Filter getFilter(){
        return filter;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public Currency getBaseCurrency(){
        for (Currency c : currencies)
            if(c.isBase()) return c;
        return new Currency();
    }

    public List<Currency> getEnableCurrency(){
        ArrayList<Currency> ec = new ArrayList();
        for (Currency c : currencies)
            if(c.isOn()) ec.add(c);
        return ec;
    }

    public List<Transaction> getFilterTransaction(){
        ArrayList<Transaction> ft = new ArrayList();
        for (Transaction t : transactions)
            if(filter.check(t.getDate())) ft.add(t);
        return ft;
    }

    public List<Transfer> getFilterTransfers(){
        ArrayList<Transfer> ft = new ArrayList();
        for (Transfer t : transfers)
            if(filter.check(t.getDate())) ft.add(t);
        return ft;
    }

    public List<Transaction> getTransactions(int count){
       return new ArrayList(transactions.subList(0, Math.min(count, transactions.size())));
    }

    public Common getOldCommon(){
        return oldCommon;
    }

    public void add(Common c) throws ModelExeption {
        List ref = getRef(c);
        if(ref.contains(c)) throw new ModelExeption(ModelExeption.IS_EXIST);
        ref.add(c);
        c.postAdd(this);
        sort();
    }

    public void edit(Common oldC, Common newC) throws ModelExeption {
        List ref = getRef(oldC);
        if(ref.contains(newC) && oldC != ref.get(ref.indexOf(newC))) throw new ModelExeption(ModelExeption.IS_EXIST);
        ref.set(ref.indexOf(oldC), newC);
        oldCommon = oldC;
        newC.postEdit(this);
        sort();
    }

    public void remove(Common c){
        getRef(c).remove(c);
        c.postRemove(this);
    }

    private List getRef(Common c){
        if(c instanceof Account) return accounts;
        if(c instanceof Article) return articles;
        if(c instanceof Currency) return currencies;
        if(c instanceof Transaction) return transactions;
        if(c instanceof Transfer) return transfers;
        return null;
    }

    public void updateCurrency() throws Exception{
        HashMap<String, Double> rates = RateCurrency.getRates(getBaseCurrency());
        for (Currency c:currencies)
            c.setRate(rates.get(c.getCode()));
        for (Account a:accounts) {
            a.getCurrency().setRate(rates.get(a.getCurrency().getCode()));
        }
        Users.getInstance().setSaved(false);
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }


    public void SetSaveData(User user) throws Exception {
        setTransfers(user.getTransfers());
        setTransactions(user.getTransactions());
        setCurrencies(user.getCurrencies());
        setArticles(user.getArticles());
        setAccounts(user.getAccounts());
        sort();
        for (Account account:accounts) {
            account.setAmountFromTransactionAndTransfers(transactions,transfers);
        }
    }


    @Override
    public String toString() {
        return "SaveData{" +
                ", articles=" + articles +
                ", accounts=" + accounts +
                ", currencies=" + currencies +
                ", transactions=" + transactions +
                ", transfers=" + transfers +
                '}';
    }
}
