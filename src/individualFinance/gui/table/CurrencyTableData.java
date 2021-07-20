package individualFinance.gui.table;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.table.model.CurrencyTableModel;
import individualFinance.gui.table.model.MainTableModel;
import individualFinance.gui.table.renderer.MainTableCellRenderer;
import individualFinance.model.Currency;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public final class CurrencyTableData extends TableData{

    private static final String[] columns = new String[]{"TITLE", "CODE", "RATE", "ON", "BASE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_CODE, Style.ICON_RATE, Style.ICON_ON, Style.ICON_BASE,};

    public CurrencyTableData(FunctionHandler handler){
        super(new CurrencyTableModel(columns),handler, icons, columns);
        init();
    }

    @Override
    protected void init() {
        for (String column : columns) {
            getColumn(Text.get(column)).setCellRenderer(new TableCellOnOffRenderer());
        }
    }


    private class TableCellOnOffRenderer extends MainTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
           if(((Currency)(((MainTableModel)table.getModel()).getCommonByRow(row))).isOn())
               renderer.setForeground(Style.COLOR_ON);
           else renderer.setForeground(Style.COLOR_OFF);
           return renderer;
        }
    }

}
