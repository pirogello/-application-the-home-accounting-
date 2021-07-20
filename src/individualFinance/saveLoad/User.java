package individualFinance.saveLoad;

import individualFinance.model.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String login;
    private String password;
    private boolean isSave;
    private List<Article> articles = new ArrayList();
    private List<Account> accounts = new ArrayList();
    private List<Currency> currencies = new ArrayList();
    private List<Transaction> transactions = new ArrayList();
    private List<Transfer> transfers = new ArrayList();

    private User(){}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        encodePassword();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if( this.password != null) {
            this.password = password;
            encodePassword();
        }
        else this.password = password;

    }

    private void encodePassword(){
        char[] passEncode = password.toCharArray();
        for(int i = 0; i < passEncode.length; i++)
           // passEncode[i] = (char)(passEncode[i] & (i+3));
            passEncode[i] = (char)(passEncode[i] + 7);
        password = new String(passEncode);
    }


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public boolean isSave() {
        return isSave;
    }

    public void setSave(boolean save) {
        isSave = save;
    }


}
