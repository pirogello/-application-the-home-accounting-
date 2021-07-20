package individualFinance.gui.dialog;

import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;

public class AboutDialog extends JDialog {

    public AboutDialog(){
        super();
        init();
        setTitle(Text.get("DIALOG_ABOUT_TITLE"));
        setResizable(false);
        setIconImage(Style.ICON_ABOUT.getImage());
    }

    private void init() {
        JEditorPane pane = new JEditorPane("text/html", Text.get("ABOUT"));
        pane.setEditable(false);
        pane.setOpaque(false);

        add(pane);
        pack();
        setLocationRelativeTo(null);
    }

}
