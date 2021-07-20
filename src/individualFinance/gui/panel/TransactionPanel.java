package individualFinance.gui.panel;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.AccountAddEditDialog;
import individualFinance.gui.dialog.TransactionAddEditDialog;
import individualFinance.gui.table.TransactionTableData;
import individualFinance.gui.toolbar.FunctoinsToolbar;
import individualFinance.settings.Settings;
import individualFinance.settings.Style;

import javax.swing.*;

public class TransactionPanel extends RightPanel{

    public TransactionPanel(MainFrame frame){
        super(frame, new TransactionTableData(new FunctionHandler(frame,
                new TransactionAddEditDialog(frame))), "TRANSACTIONS", Style.ICON_PANEL_TRANSACTION,new JPanel[] {
                        new FunctoinsToolbar(new FunctionHandler(frame, new TransactionAddEditDialog(frame))),
                        new FilterPanel(frame) });
    }
}
