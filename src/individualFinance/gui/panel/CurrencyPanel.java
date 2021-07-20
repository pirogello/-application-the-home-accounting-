package individualFinance.gui.panel;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.AccountAddEditDialog;
import individualFinance.gui.dialog.CurrencyAddEditDialog;
import individualFinance.gui.table.ArticleTableData;
import individualFinance.gui.table.CurrencyTableData;
import individualFinance.gui.toolbar.FunctoinsToolbar;
import individualFinance.settings.Style;

public class CurrencyPanel extends RightPanel{

    public CurrencyPanel(MainFrame frame){
        super(frame, new CurrencyTableData(new FunctionHandler(frame, new CurrencyAddEditDialog(frame))), "CURRENCIES", Style.ICON_PANEL_CURRENCIES,
                new FunctoinsToolbar(new FunctionHandler(frame, new CurrencyAddEditDialog(frame))));
    }
}
