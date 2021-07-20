package individualFinance.gui.Handler;

import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.ConfirmDialog;
import individualFinance.saveLoad.Users;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindowHandler extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        if(Users.getInstance().isSaved()) System.exit(0);
        else {
            int result = ConfirmDialog.show((MainFrame) e.getWindow(), "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
            if(result == JOptionPane.YES_OPTION) System.exit(0);
        }
    }
}
