package individualFinance.gui.Handler;

import individualFinance.gui.MainFrame;
import individualFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MenuEditHandler extends Handler{

    public MenuEditHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FunctionHandler fh = frame.getRp().getTableData().getFunctionHandler();
        switch (e.getActionCommand()) {
            case HandlerCode.MENU_EDIT_ADD: {
                    fh.add();
                    break;
            }
            case HandlerCode.MENU_EDIT_EDIT: {
                fh.edit();
                break;
            }
            case HandlerCode.MENU_EDIT_DELETE: {
                fh.delete();
            }
            default: {
                break;
            }
        }
    }
}
