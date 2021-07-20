package individualFinance.settings;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

final public class Style {
    public static final Color COLOR_BUTTON_BG_NORMAL = new Color(240, 240, 240);
    public static final Color COLOR_BUTTON_BG_HOVER = Color.YELLOW;
    public static final Color COLOR_LEFT_PANEL_BALANCE = Color.WHITE;
    public static final Color COLOR_EXP = new Color(200, 0, 0);
    public static final Color COLOR_INCOME = new Color(0, 150, 0);
    public static final Color COLOR_ON = Color.BLACK;
    public static final Color COLOR_OFF = new Color(150, 150, 150);


    public static final Font FONT_TABLE_HEADER = new Font("FontMy",Font.BOLD,16);
    public static final Font FONT_TABLE = new Font("FontMy",Font.PLAIN,14);
    public static final Font FONT_BUTTON_TOOLBAR = new Font("FontMy",Font.BOLD,14);
    public static final Font FONT_MAIN_BUTTON = new Font("FontMy",Font.BOLD,14);
    public static final Font FONT_DIALOG_LABEL = new Font("FontMy",Font.BOLD,12);
    public static final Font FONT_LABEL_HEADER = new Font("FontMy",Font.BOLD,16);
    public static final Font FONT_LEFT_PANEL_CURRENCY = new Font("FontMy",Font.BOLD,14);
    public static final Font FONT_LEFT_PANEL_AMOUNT = new Font("FontMy",Font.PLAIN,12);
    public static final Font FONT_BUTTON_FILTER = new Font("FontMy",Font.BOLD,12);

    public static final EmptyBorder BORDER_PANEL = new EmptyBorder(10,10,10,10);
    public static final EmptyBorder BORDER_LEFT_PANEL = new EmptyBorder(0,10,10,10);
    public static final EmptyBorder BORDER_MAIN_TOOLBAR = new EmptyBorder(10,10,10,10);
    public static final EmptyBorder BORDER_FUNCTIONS_TOOLBAR = new EmptyBorder(5,5,5,5);
    public static final EmptyBorder BORDER_DIALOG = new EmptyBorder(10,10,10,10);
    public static final EmptyBorder BORDER_FILTER_PANEL = new EmptyBorder(5,0,7,0);

    public static final Dimension DIMENSION_DIALOG_TEXT_FIELD_SIZE = new Dimension(200,25);
    public static final Dimension DIMENSION_DIALOG_PADDING_BUTTON_SIZE = new Dimension(10,0);
    public static final Dimension DIMENSION_PADDING_BALANCE = new Dimension(10,0);
    public static final Dimension DIMENSION_TABLE_SHOW_SIZE =  new Dimension(800,400);
    public static final Dimension DIMENSION_REGISTER_TEXT_FIELD_SIZE = new Dimension(170,30);
    public static final Dimension DIMENSION_CHART = new Dimension(818,400);

    public static final int PADDING_DIALOG = 10;
    public static final int PADDING_BALANCE = 3;
    public static final int PADDING_LABEL_BALANCE = 20;
    public static final int PADDING_PANEL = 3;
    public static final int PADDING_PANEL_EMPTY = 5;
    public static final int TABLE_ADD_ROW_HEIGHT = 18;
    public static final int WIDTH_FILTER_BUTTON = 200;

    public static final ImageIcon ICON_MAIN = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_TOOLBAR_OVERVIEW = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_TOOLBAR_ACCOUNTS = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_TOOLBAR_ARTICLES = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSFERS = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_TOOLBAR_CURRENCY = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_TOOLBAR_STATISTICS = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSACTIONS = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_MENU_FILE = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_EDIT = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_VIEW = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_HELP = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_MENU_FILE_SAVE = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_FILE_UPDATE_CURRENCIES = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_FILE_EXIT = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_MENU_EDIT_ADD = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_EDIT_EDIT = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_EDIT_DELETE = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_MENU_VIEW_OVERVIEW = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_VIEW_ACCOUNTS = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_VIEW_ARTICLES = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_VIEW_CURRENCIES = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_VIEW_STATISTICS = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_VIEW_TRANSACTIONS = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_VIEW_TRANSFERS = new ImageIcon("images/main.png");


    public static final ImageIcon ICON_ADD = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_EDIT = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_DELETE = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_ABOUT = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_MENU_HELP_ABOUT = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_DATE = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_OK = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_CANCEL = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_TITLE = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_CURRENCY = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_AMOUNT = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_ACCOUNT = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_ARTICLE = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_NOTICE = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_CODE = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_RATE = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_ON = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_BASE = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_LEFT_PANEL_BALANCE_CURRENCIES = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_LEFT_PANEL_BALANCE = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_PANEL_OVERVIEW = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_PANEL_TRANSACTION = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_PANEL_ACCOUNTS = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_PANEL_ARTICLES =  new ImageIcon("images/main.png");
    public static final ImageIcon ICON_PANEL_TRANSFER = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_PANEL_CURRENCIES = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_LEFT = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_RIGHT = new ImageIcon("images/main.png");


    public static final ImageIcon ICON_PANEL_STATISTICS = new ImageIcon("images/main.png");
}
