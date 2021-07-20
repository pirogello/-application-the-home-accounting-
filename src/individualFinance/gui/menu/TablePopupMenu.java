package individualFinance.gui.menu;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.Refresh;
import individualFinance.settings.HandlerCode;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;

public class TablePopupMenu extends JPopupMenu implements Refresh {

    private FunctionHandler handler;

    public TablePopupMenu(FunctionHandler handler){
        super();
        this.handler = handler;
        init();
    }

    private void init() {

        JMenuItem editItem = new JMenuItem(Text.get("EDIT"));
        JMenuItem deleteItem = new JMenuItem(Text.get("DELETE"));

        editItem.setActionCommand(HandlerCode.EDIT);
        deleteItem.setActionCommand(HandlerCode.DELETE);

        editItem.addActionListener(handler);
        deleteItem.addActionListener(handler);

        editItem.setIcon(Style.ICON_EDIT);
        deleteItem.setIcon(Style.ICON_DELETE);

        add(editItem);
        add(deleteItem);

    }

    @Override
    public void refresh() {

    }
}
