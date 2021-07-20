package individualFinance.gui.panel;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.AccountAddEditDialog;
import individualFinance.gui.dialog.TransactionAddEditDialog;
import individualFinance.gui.table.TransactionTableData;
import individualFinance.gui.table.renderer.MainTableCellRenderer;
import individualFinance.settings.Settings;
import individualFinance.settings.Style;

public class OverviewPanel extends RightPanel{

    public OverviewPanel(MainFrame frame){
        super(frame, new TransactionTableData(Settings.COUNT_OVERVIEW_ROWS,
                new FunctionHandler(frame,
                        new TransactionAddEditDialog(frame))), "LAST_TRANSACTIONS", Style.ICON_PANEL_OVERVIEW);
    }
}
