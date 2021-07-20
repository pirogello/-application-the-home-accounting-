package individualFinance.saveLoad;

import individualFinance.model.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "usersList")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWrapper {

    @XmlElement(name = "user")
    private List<User> usersCou = null;

    public List<User> getUsers() {
        return usersCou;
    }
    public void setUsers(List<User> users) {
        this.usersCou = users;
    }


    /*private List<Article> articles= new ArrayList();
    private List<Account> accounts= new ArrayList();
    private List<Currency> currencies= new ArrayList();
    private List<Transaction> transactions= new ArrayList();
    private List<Transfer> transfers= new ArrayList();

    @XmlElement(name = "articles")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @XmlElement(name = "accounts")
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @XmlElement(name = "currencies")
    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @XmlElement(name = "transactions")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @XmlElement(name = "transfers")
    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }*/

}
