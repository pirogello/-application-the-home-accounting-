package individualFinance.model;

import individualFinance.exeption.ModelExeption;
import individualFinance.saveLoad.SaveData;

import java.util.Date;

public class Transfer extends Common{
	private Account fromAccount;
	private Account toAccount;
	private double fromAmount;
	private double toAmount;
	private String notice;
	private Date date;

	public Transfer(){}

	public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String notice, Date date) throws ModelExeption {
		if(fromAccount == null) throw new ModelExeption(ModelExeption.ACCOUNT_EMPTY);
		if(toAccount == null) throw new ModelExeption(ModelExeption.ACCOUNT_EMPTY);
		if(fromAmount < 0 || toAmount < 0) throw new ModelExeption(ModelExeption.AMOUNT_FORMAT);

		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.fromAmount = fromAmount;
		this.toAmount = toAmount;
		this.notice = notice;
		this.date = date;
	}

	public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String notice) throws ModelExeption {
	this(fromAccount, toAccount, fromAmount, toAmount, notice, new Date());
	}

	public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, Date date) throws ModelExeption {
		this(fromAccount, toAccount, fromAmount, toAmount, "", date);
	}
	public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount) throws ModelExeption {
		this(fromAccount, toAccount, fromAmount, toAmount, "", new Date());
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	public double getFromAmount() {
		return fromAmount;
	}

	public void setFromAmount(double fromAmount) {
		this.fromAmount = fromAmount;
	}

	public double getToAmount() {
		return toAmount;
	}

	public void setToAmount(double toAmount) {
		this.toAmount = toAmount;
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
		return "Transfer{" +
				"fromAccount=" + fromAccount +
				", toAccount=" + toAccount +
				", fromAmount=" + fromAmount +
				", toAmount=" + toAmount +
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
