package individualFinance.gui.Handler;

import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.ConfirmDialog;
import individualFinance.gui.dialog.ErrorDialog;
import individualFinance.gui.dialog.registerAndEnter.AuthenticationScreen;
import individualFinance.saveLoad.SaveData;
import individualFinance.saveLoad.User;
import individualFinance.saveLoad.Users;
import individualFinance.settings.HandlerCode;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuFileHandler extends Handler{


    public MenuFileHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case HandlerCode.MENU_FILE_SAVE: {
                    Users.getInstance().save();
                    break;
            }
            case HandlerCode.MENU_FILE_UPDATE_CURRENCY: {
                try {
                    SaveData.getInstance().updateCurrency();
                    super.actionPerformed(e);
                } catch (Exception exception) {
                    ErrorDialog.show(frame, "ERROR_UPDATE_CURRENCY");
                }
                break;
            }
            case HandlerCode.MENU_FILE_EXIT: {
                if(!Users.getInstance().isSaved()) {
                    int result = ConfirmDialog.show(frame, "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
                    if (result == JOptionPane.YES_OPTION){
                        for (User user : Users.getInstance().getUsers()) {
                            if (user.isSave()) {
                                user.setSave(false);
                                SaveData.getInstance().clear();
                                frame.pack();
                                new AuthenticationScreen(frame).showScreen();
                                break;
                            }
                        }
                    }
                }
                else {
                    for (User user : Users.getInstance().getUsers()) {
                        if (user.isSave()) {
                            user.setSave(false);
                            Users.getInstance().save();
                            SaveData.getInstance().clear();
                            new AuthenticationScreen(frame).showScreen();
                            break;
                        }
                    }
                }
            }
            default: {
                break;
            }
        }
    }
}
