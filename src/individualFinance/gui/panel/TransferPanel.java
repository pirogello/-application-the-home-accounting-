package individualFinance.gui.panel;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.AccountAddEditDialog;
import individualFinance.gui.dialog.TransferAddEditDialog;
import individualFinance.gui.table.TransactionTableData;
import individualFinance.gui.table.TransferTableData;
import individualFinance.gui.toolbar.FunctoinsToolbar;
import individualFinance.settings.Style;

import javax.swing.*;

public class TransferPanel extends RightPanel{

    public TransferPanel(MainFrame frame){
        super(frame, new TransferTableData(new FunctionHandler(frame, new TransferAddEditDialog(frame))), "TRANSFERS", Style.ICON_PANEL_TRANSFER, new JPanel[] {
                new FunctoinsToolbar(new FunctionHandler(frame, new TransferAddEditDialog(frame))),
                new FilterPanel(frame)});
    }
}
