package individualFinance.gui.panel;

import individualFinance.gui.Handler.FilterHandler;
import individualFinance.gui.MainButton;
import individualFinance.gui.MainFrame;
import individualFinance.saveLoad.SaveData;
import individualFinance.settings.Format;
import individualFinance.settings.HandlerCode;
import individualFinance.settings.Style;

import java.awt.*;

public final class FilterPanel extends AbstractPanel{


    public FilterPanel(MainFrame frame) {
        super(frame);
        init();
    }

    @Override
    protected void init() {
        FlowLayout layout = new FlowLayout();
        //layout.setVgap(0);
        setLayout(layout);
        MainButton left = new MainButton(Style.ICON_LEFT, new FilterHandler(frame), HandlerCode.LEFT);
        MainButton right = new MainButton(Style.ICON_RIGHT, new FilterHandler(frame), HandlerCode.RIGHT);
        MainButton step = new MainButton(Format.getTitleFilter(SaveData.getInstance().getFilter()), new FilterHandler(frame), HandlerCode.STEP);

        setBorder(Style.BORDER_FILTER_PANEL);
        step.setFont(Style.FONT_BUTTON_FILTER);
        step.setPreferredSize(new Dimension(Style.WIDTH_FILTER_BUTTON, left.getPreferredSize().height));

        add(left);
        add(step);
        add(right);
    }

}
