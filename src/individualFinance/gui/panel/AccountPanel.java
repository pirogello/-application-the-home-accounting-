package individualFinance.gui.panel;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.AccountAddEditDialog;
import individualFinance.gui.table.AccountTableData;
import individualFinance.gui.table.TransactionTableData;
import individualFinance.gui.toolbar.FunctoinsToolbar;
import individualFinance.settings.Settings;
import individualFinance.settings.Style;

public class AccountPanel extends RightPanel{

    public AccountPanel(MainFrame frame){
        super(frame, new AccountTableData(new FunctionHandler(frame, new AccountAddEditDialog(frame))), "ACCOUNTS", Style.ICON_PANEL_ACCOUNTS,
                new FunctoinsToolbar(new FunctionHandler(frame, new AccountAddEditDialog(frame))));
    }
}
