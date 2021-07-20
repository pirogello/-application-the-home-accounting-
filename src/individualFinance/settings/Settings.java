package individualFinance.settings;

import java.io.File;

final public class Settings{

    public static final File FONT_BOLT = new File("Font/FontMy.ttf");

    public static final String FORMAT_AMOUNT = "%.2f";
    public static final String FORMAT_RATE = "%.4f";
    public static final String FORMAT_DATE = "dd.MM.yyyy";
    public static final String FORMAT_DATE_MONTH = "MMMM yyyy";
    public static final String FORMAT_DATE_YEAR = "yyyy";

    public static final int COUNT_OVERVIEW_ROWS = 10;

    public static final String[] CURRENCY_CODES = new String[]{"RUB", "USD", "EUR", "BYN", "UAH"};

    private static File FILE_SAVE = new File("saves/default.myrus");

    public static File getFileSave() {
        return FILE_SAVE;
    }


}
