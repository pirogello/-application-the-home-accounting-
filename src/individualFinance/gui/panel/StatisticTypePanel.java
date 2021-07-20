package individualFinance.gui.panel;

import individualFinance.gui.Handler.ChartHandler;
import individualFinance.gui.MainButton;
import individualFinance.gui.MainFrame;
import individualFinance.settings.HandlerCode;

public class StatisticTypePanel extends AbstractPanel{

    String title;

    public StatisticTypePanel(MainFrame frame, String title) {
        super(frame);
        this.title = title;
        init();
    }

    @Override
    protected void init() {

        MainButton button = new MainButton(title, new ChartHandler(frame), HandlerCode.TYPE);
        add(button);
    }
}
