package individualFinance.exeption;

import individualFinance.settings.Text;

public class ModelExeption extends Exception{

	public static final int TITLE_EMPTY = 0;
	public static final int IS_EXIST = 1;
	public static final int DATA_FORMAT = 2;
	public static final int CODE_EMPTY = 3;
	public static final int CURRENCY_EMPTY = 4;
	public static final int ARTICLE_EMPTY = 5;
	public static final int ACCOUNT_EMPTY = 6;
	public static final int RATE_INCORRECT = 7;
	public static final int AMOUNT_FORMAT = 8;
	public static final int NO_BASE_CURRENCY = 9;

	private final int code;

	public ModelExeption(int code){
		this.code = code;
	}

	public String getMassage() {
		switch (code) {
			case TITLE_EMPTY:
				return "ERROR_TITLE_EMPTY";
			case IS_EXIST:
				return "ERROR_IS_EXIST";
			case DATA_FORMAT:
				return "ERROR_DATA_FORMAT";
			case CODE_EMPTY:
				return "ERROR_CODE_EMPTY";
			case CURRENCY_EMPTY:
				return "ERROR_CURRENCY_EMPTY";
			case ARTICLE_EMPTY:
				return "ERROR_ARTICLE_EMPTY";
			case ACCOUNT_EMPTY:
				return "ERROR_ACCOUNT_EMPTY";
			case RATE_INCORRECT:
				return "ERROR_RATE_INCORRECT";
			case AMOUNT_FORMAT:
				return "ERROR_AMOUNT_FORMAT";
			case NO_BASE_CURRENCY:
				return "ERROR_NO_BASE_CURRENCY";
			default: return "";
		}
	}
}
