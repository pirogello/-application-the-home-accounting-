package individualFinance.model;

import individualFinance.exeption.ModelExeption;
import individualFinance.saveLoad.SaveData;

import java.util.Objects;

public class Currency extends Common{
	private String title;
	private String code;
	private double rate;
	private boolean on;
	private boolean isBase;

	public Currency(){}

	public Currency( String title, String code, double rate, boolean On, boolean isBase) throws ModelExeption {
		if(title.length() == 0) throw new ModelExeption(ModelExeption.TITLE_EMPTY);
		if(code.length() == 0) throw new ModelExeption(ModelExeption.CODE_EMPTY);
		if(rate <= 0) throw new ModelExeption(ModelExeption.RATE_INCORRECT);

		this.title = title;
		this.code = code;
		this.rate = rate;
		this.on = On;
		this.isBase = isBase;
		if(this.isBase) this.on = true;
	}

	public String getValueForComboBox(){
		return title;
	}

	public double getRateByCurrency(Currency currency){
		return rate / currency.rate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean On) {
		this.on = On;
	}

	public boolean isBase() {
		return isBase;
	}

	public void setBase(boolean base) {
		isBase = base;
	}

	@Override
	public String toString() {
		return "Currency{" +
				"title='" + title + '\'' +
				", code='" + code + '\'' +
				", rate=" + rate +
				", isOn=" + on +
				", isBase=" + isBase +
				'}';
	}


	@Override
	public void postAdd(SaveData data){
		SaveData sd = data;
		clearBase(sd);
	}
	@Override
	public void postEdit(SaveData data){
		SaveData sd = data;
		clearBase(sd);
		for (Account a: sd.getAccounts()) {
			if(a.getCurrency().equals(sd.getOldCommon())) a.setCurrency(this);
			for (Currency cur : sd.getCurrencies()) {
				if(a.getCurrency().getCode().equals(cur.getCode()))
					a.setCurrency(cur);
			}
		}
		for (Transaction t: sd.getTransactions()) {
			for (Account account : sd.getAccounts()) {
				if(t.getAccount().getTitle().equals(account.getTitle()))
					t.setAccount(account);
			}
		}
		for (Transfer t: sd.getTransfers()) {
			for (Account account : sd.getAccounts()) {
				if(t.getFromAccount().getTitle().equals(account.getTitle()))
					t.setFromAccount(account);
				if(t.getToAccount().getTitle().equals(account.getTitle()))
					t.setToAccount(account);
			}
		}
	}

	private void clearBase(SaveData sd) {
		if(isBase) {
			rate = 1;
			Currency oldC = (Currency) sd.getOldCommon();
			for (Currency c: sd.getCurrencies()) {
				if(!this.equals(c)){
					c.setBase(false);
					if(oldC != null) c.setRate(c.rate / oldC.rate);//проверить
				}
			}
		}
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Currency currency = (Currency) o;
		return code.equals(currency.code);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
}
