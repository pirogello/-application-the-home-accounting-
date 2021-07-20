package individualFinance.gui.panel;

import individualFinance.gui.MainFrame;
import individualFinance.gui.Refresh;
import individualFinance.model.Account;

import javax.swing.*;

public abstract class AbstractPanel extends JPanel implements Refresh {

    protected final MainFrame frame;

    public AbstractPanel(MainFrame frame){
        this.frame = frame;
    }

    protected abstract void init();

    @Override
    public void refresh() {
        removeAll();
        init();
    }
}
