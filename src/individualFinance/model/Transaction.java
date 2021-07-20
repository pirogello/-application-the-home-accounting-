package individualFinance.model;

import individualFinance.exeption.ModelExeption;
import individualFinance.saveLoad.SaveData;

import java.util.Date;

public class Transaction extends Common{

	private Account account;
	private Article article;
	private double amount;
	private String notice;
	private Date date;

	public Transaction(){}

	public Transaction(Account account, Article article, double amount, String notice, Date date) throws ModelExeption {
		if(account == null) throw new ModelExeption(ModelExeption.ACCOUNT_EMPTY);
		if(article == null) throw new ModelExeption(ModelExeption.ARTICLE_EMPTY);

		this.account = account;
		this.article = article;
		this.amount = amount;
		this.notice = notice;
		this.date = date;
	}

	public Transaction(Account account, Article article, double amount,  Date date) throws ModelExeption {
		this(account, article, amount, "", date);
	}

	public Transaction(Account account, Article article, double amount, String notice) throws ModelExeption {
		this(account, article, amount, notice, new Date());
	}

	public Transaction(Account account, Article article, double amount) throws ModelExeption {
		this(account, article, amount, "", new Date());
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"account=" + account +
				", article=" + article +
				", amount=" + amount +
				", notice='" + notice + '\'' +
				", date=" + date +
				'}';
	}

	@Override
	public void postAdd(SaveData data){
		SaveData sd = data;

	}
	public void postEdit(SaveData data){
		SaveData sd = data;

	}

	public void postRemove(SaveData data){
		SaveData sd = data;

	}

	private void setAmount(SaveData sd){
		for (Account a: sd.getAccounts()) {
			a.setAmountFromTransactionAndTransfers(sd.getTransactions(), sd.getTransfers());
		}
	}
}
