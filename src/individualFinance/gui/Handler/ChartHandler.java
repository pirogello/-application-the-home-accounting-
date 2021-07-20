package individualFinance.gui.Handler;

import individualFinance.gui.MainFrame;
import individualFinance.gui.panel.StatisticPanel;
import individualFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class ChartHandler extends Handler{

    public ChartHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case HandlerCode.TYPE: {
                ((StatisticPanel)frame.getRp()).nextType();
            }
            default: {
                break;
            }
        }
        super.actionPerformed(e);
    }
}
