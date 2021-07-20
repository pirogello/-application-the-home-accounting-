package individualFinance.gui.table;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.Handler.Handler;
import individualFinance.gui.Refresh;
import individualFinance.gui.menu.TablePopupMenu;
import individualFinance.gui.table.model.MainTableModel;
import individualFinance.gui.table.renderer.MainTableCellRenderer;
import individualFinance.gui.table.renderer.TableHeaderIconRenderer;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

abstract public class TableData extends JTable implements Refresh {

    private final ImageIcon[] icons;
    private final String[] columns;
    private TablePopupMenu popupMenu;
    private FunctionHandler handler;

    protected TableData(MainTableModel model, FunctionHandler handler, ImageIcon[] icons, String[] columns) {
        super(model);
        this.handler = handler;
        this.icons = icons;
        this.columns = columns;
        this.popupMenu = new TablePopupMenu(handler);

        getTableHeader().setFont(Style.FONT_TABLE_HEADER);
        setFont(Style.FONT_TABLE);
        setRowHeight(getRowHeight() + Style.TABLE_ADD_ROW_HEIGHT);

        //setAutoCreateRowSorter(true);

        setPreferredScrollableViewportSize(Style.DIMENSION_TABLE_SHOW_SIZE);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addMouseListener(handler);
        addKeyListener(handler);

        for(int i = 0; i < columns.length; i++){
            getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }
        setDefaultRenderer(String.class, new MainTableCellRenderer());
        setComponentPopupMenu(popupMenu);

    }

    @Override
   public JPopupMenu getComponentPopupMenu(){
        Point p = getMousePosition();
        if(p != null){
            if(isRowSelected(rowAtPoint(p))) {
                int row = rowAtPoint(p);
                if(isRowSelected(row)) return super.getComponentPopupMenu();
                else return null;
            }

        }
        return super.getComponentPopupMenu();
    }

    @Override
    public void refresh() {
        int selectedRow = getSelectedRow();
        ((MainTableModel) getModel()).refresh();
        for(int i = 0; i < columns.length; i++){
            getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }
        if(selectedRow != -1 && selectedRow < getRowCount()) {
            setRowSelectionInterval(selectedRow, selectedRow);
            requestFocus();
        }
        init();
    }

    public FunctionHandler getFunctionHandler(){
        return handler;
    }

    protected void init(){}

}
