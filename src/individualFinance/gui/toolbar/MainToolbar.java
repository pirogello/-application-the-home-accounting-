package individualFinance.gui.toolbar;

import individualFinance.gui.Handler.MainToolbarHandler;
import individualFinance.settings.HandlerCode;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

public final class MainToolbar extends AbstractToolbar{

    private MainToolbarHandler handler;

    public MainToolbar(MainToolbarHandler handler){
        super(Style.BORDER_MAIN_TOOLBAR,handler);
        this.handler = handler;
        init();
    }

    @Override
    protected void init() {
        addButton(Text.get("TOOLBAR_OVERVIEW"), Style.ICON_TOOLBAR_OVERVIEW, HandlerCode.TOOLBAR_OVERVIEW, true);
        addButton(Text.get("TOOLBAR_ACCOUNTS"), Style.ICON_TOOLBAR_ACCOUNTS, HandlerCode.TOOLBAR_ACCOUNTS, true);
        addButton(Text.get("TOOLBAR_ARTICLES"), Style.ICON_TOOLBAR_ARTICLES, HandlerCode.TOOLBAR_ARTICLES, true);
        addButton(Text.get("TOOLBAR_CURRENCIES"), Style.ICON_TOOLBAR_CURRENCY, HandlerCode.TOOLBAR_CURRENCIES, true);
        addButton(Text.get("TOOLBAR_TRANSFERS"), Style.ICON_TOOLBAR_TRANSFERS, HandlerCode.TOOLBAR_TRANSFERS, true);
        addButton(Text.get("TOOLBAR_STATISTICS"), Style.ICON_TOOLBAR_STATISTICS, HandlerCode.TOOLBAR_STATISTICS, true);
        addButton(Text.get("TOOLBAR_TRANSACTIONS"), Style.ICON_TOOLBAR_TRANSACTIONS, HandlerCode.TOOLBAR_TRANSACTIONS, true);
    }


}
