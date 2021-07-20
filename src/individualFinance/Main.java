package individualFinance;

import individualFinance.exeption.ModelExeption;
import individualFinance.gui.MainFrame;
import individualFinance.model.*;
import individualFinance.saveLoad.*;
import individualFinance.settings.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        init();

        //testModel();
        Users.getInstance().load();
        MainFrame frame = new MainFrame();
        //frame.setVisible(true);
    }

    public static void init(){
        //Settings.init();
        Text.init();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_BOLT));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void testModel() throws ModelExeption {

        Currency c1 = new Currency("Рубль", "RUB", 1, true,true);
        Currency c2 = new Currency("Доллар", "USD", 65, true,false);
        Currency c3 = new Currency("Евро", "EUR", 75, false,false);
        Currency c4 = new Currency("Гривна", "UAH", 2.5, false,false);

        Account ac1 = new Account("Кошелек", c1, 1000);
        Account ac2 = new Account("Карта Visa", c1, 0);
        Account ac3 = new Account("Депозит в банке(RUB)", c1, 100000);
        Account ac4 = new Account("Депозит в банке(USD)", c2, 0);

        Article ar1 = new Article("Продукты");
        Article ar2 = new Article("ЖКХ");
        Article ar3 = new Article("Зарплата");
        Article ar4 = new Article("Столовая");
        Article ar5 = new Article("Проценты по депозиту");

        ArrayList<Currency> currencies = new ArrayList();
        currencies.add(c1);
        currencies.add(c2);
        currencies.add(c3);
        currencies.add(c4);

        ArrayList<Account> accounts = new ArrayList();
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);

        ArrayList<Article> articles = new ArrayList();
        articles.add(ar1);
        articles.add(ar2);
        articles.add(ar3);
        articles.add(ar4);
        articles.add(ar5);

        ArrayList<Transaction> transactions = new ArrayList();
        transactions.add(new Transaction(ac2,ar3,3000));
        transactions.add(new Transaction(ac2,ar1,-1500, "На выходные"));
        transactions.add(new Transaction(ac1,ar2,-5500,"Основная квартира"));
        transactions.add(new Transaction(ac1,ar2,-4000,"Вторая квартира"));
        transactions.add(new Transaction(ac3,ar4,1040, "Почему 1000"));
        transactions.add(new Transaction(ac2,ar3,25000, new Date(new Date().getTime() - (86400000L *30))));
        transactions.add(new Transaction(ac3,ar5,1000, new Date(new Date().getTime() - (86400000L *30))));

      /*  for (int i = 0; i < 50 ; i++){
            Article tempArticle;
            Account tempAccount;
            if(Math.random() < 0.5)
                tempArticle = ar1;
            else tempArticle = ar4;
            if(Math.random() < 0.5)
                tempAccount = ac1;
            else tempAccount = ac2;
            double tempAmount = Math.random()*-1000;
            Date tempDate = new Date((long) new Date().getTime() - (long)((86400000*30)*Math.random()));
            transactions.add(new Transaction(tempAccount, tempArticle, tempAmount, tempDate));
        }*/

        ArrayList<Transfer> transfers = new ArrayList();
        transfers.add(new Transfer(ac2,ac1,25000,25000));
        transfers.add(new Transfer(ac2,ac3,3000,3000));
        transfers.add(new Transfer(ac2,ac4,6000,90));

        for (Account ac:accounts) {
            ac.setAmountFromTransactionAndTransfers(transactions,transfers);
        }
        User sd = new User("Nikita", "12356");
        sd.setCurrencies(currencies);
        sd.setAccounts(accounts);
        sd.setArticles(articles);
        sd.setTransfers(transfers);
        sd.setTransactions(transactions);
        User sd2 = new User("Sasha", "5678");
        sd2.setCurrencies(currencies);
        sd2.setAccounts(accounts);
        sd2.setArticles(articles);
        //sd2.setTransfers(transfers);
        //sd2.setTransactions(transactions);
        Users users = Users.getInstance();
        users.addUser(sd);
        users.addUser(sd2);
        users.save();
    }
}

