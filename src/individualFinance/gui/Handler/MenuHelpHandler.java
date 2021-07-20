package individualFinance.gui.Handler;

import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.AboutDialog;
import individualFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MenuHelpHandler extends Handler{

    public MenuHelpHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case HandlerCode.MENU_HELP_ABOUT: {
                new AboutDialog().setVisible(true);
                break;
            }
            default: {
                break;
            }
        }
    }

}
