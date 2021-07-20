package individualFinance.gui.dialog;

import individualFinance.gui.MainFrame;
import individualFinance.settings.Text;

import javax.swing.*;

public class ErrorDialog {


    public static void show(MainFrame frame, String text){
        JOptionPane.showMessageDialog(frame, Text.get(text), Text.get("ERROR"), JOptionPane.ERROR_MESSAGE);
    }
}
