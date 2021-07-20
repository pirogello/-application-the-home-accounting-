package individualFinance.gui.table;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.table.model.AccountTableModel;
import individualFinance.settings.Style;

import javax.swing.*;

public final class AccountTableData extends TableData{

    private static final String[] columns = new String[]{"TITLE","AMOUNT"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_AMOUNT};

    public AccountTableData(FunctionHandler handler){
        super(new AccountTableModel(columns),handler, icons, columns);
    }


}
