package individualFinance.gui.table;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.table.model.TransactionTableModel;
import individualFinance.gui.table.renderer.MainTableCellRenderer;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class TransactionTableData extends TableData{

    private static final String[] columns = new String[]{"DATE", "ACCOUNT", "ARTICLE", "AMOUNT", "NOTICE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_DATE, Style.ICON_ACCOUNT, Style.ICON_ARTICLE, Style.ICON_AMOUNT, Style.ICON_NOTICE};

    public TransactionTableData(FunctionHandler handler){
        super(new TransactionTableModel(columns),handler, icons, columns);
        init();
    }

    public TransactionTableData(int count, FunctionHandler handler){
        super(new TransactionTableModel(columns, count),handler, icons, columns);
        init();
    }


    @Override
    protected void init() {
        getColumn(Text.get("AMOUNT")).setCellRenderer(new TableCellAmountRenderer());
    }

    private class TableCellAmountRenderer extends MainTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if((value.toString()).contains("-")) renderer.setForeground(Style.COLOR_EXP);
            else renderer.setForeground(Style.COLOR_INCOME);
            return renderer;
        }
    }

}
