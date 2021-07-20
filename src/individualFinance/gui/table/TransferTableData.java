package individualFinance.gui.table;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.table.model.TransferTableModel;
import individualFinance.gui.table.renderer.MainTableCellRenderer;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class TransferTableData extends TableData{

    private static final String[] columns = new String[]{"DATE", "FROM_ACCOUNT", "FROM_AMOUNT", "TO_ACCOUNT", "TO_AMOUNT", "NOTICE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_DATE, Style.ICON_ACCOUNT, Style.ICON_AMOUNT, Style.ICON_ACCOUNT, Style.ICON_AMOUNT, Style.ICON_AMOUNT, Style.ICON_NOTICE};

    public TransferTableData(FunctionHandler handler){
        super(new TransferTableModel(columns),handler, icons, columns);
        init();
    }

    @Override
    protected void init() {
        getColumn(Text.get("FROM_AMOUNT")).setCellRenderer(new TableCellAmountRenderer(Style.COLOR_EXP));
        getColumn(Text.get("TO_AMOUNT")).setCellRenderer(new TableCellAmountRenderer(Style.COLOR_INCOME));
    }

    private class TableCellAmountRenderer extends MainTableCellRenderer {

        private Color color;

        public TableCellAmountRenderer(Color color){
            this.color = color;
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            renderer.setForeground(color);
            return renderer;
        }
    }
}
