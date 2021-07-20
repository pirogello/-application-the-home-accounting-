package individualFinance.gui.toolbar;

import individualFinance.gui.Handler.Handler;
import individualFinance.gui.MainButton;
import individualFinance.gui.Refresh;
import individualFinance.saveLoad.RateCurrency;
import individualFinance.settings.Style;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public abstract class AbstractToolbar extends JPanel implements Refresh {

    private final Handler handler;

    public AbstractToolbar(EmptyBorder border, Handler handler){
        super();
        setBorder(border);
        this.handler = handler;
    }

    abstract protected void init();

    protected MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon){
        MainButton button = new MainButton(title,icon,handler, action);
        if(topIcon) {
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
        }else {
            button.setHorizontalTextPosition(SwingConstants.RIGHT);
            button.setVerticalTextPosition(SwingConstants.CENTER);
        }
        add(button);
        return button;
    }

    @Override
    public void refresh(){
        removeAll();
        init();
    }

}
