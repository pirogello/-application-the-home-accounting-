package individualFinance.gui.panel;

import individualFinance.gui.Chart;
import individualFinance.gui.MainFrame;
import individualFinance.model.Statistics;
import individualFinance.saveLoad.SaveData;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;

public class StatisticPanel extends RightPanel{

    public static final int TYPE_INCOME = 0;
    public static final int TYPE_EXP = 1;
    private int type = TYPE_INCOME;


    public StatisticPanel(MainFrame frame) {
        super(frame, null, "STATISTICS", Style.ICON_PANEL_STATISTICS,
                new JPanel[]{
                        new FilterPanel(frame),
                        new StatisticTypePanel(frame, Text.get("CHART_INCOME")),
                        new Chart(Statistics.getDataForChartOnIncomeArticles(), Text.get("CHART_INCOME"), SaveData.getInstance().getBaseCurrency().getCode()).getPanel()
                });
    }

    public void nextType(){
        type++;
        if(type > TYPE_EXP) type = TYPE_INCOME;
    }

    @Override
    public void refresh(){
        Chart chart = null;
        String title = null;
        if(type == TYPE_INCOME) {
            title = Text.get("CHART_INCOME");
            chart = new Chart(Statistics.getDataForChartOnIncomeArticles(), title, SaveData.getInstance().getBaseCurrency().getCode());
        }
        else {
            title = Text.get("CHART_EXP");
            chart = new Chart(Statistics.getDataForChartOnExpArticles(), title, SaveData.getInstance().getBaseCurrency().getCode());
        }
        setPanels(new JPanel[]{new FilterPanel(frame), new StatisticTypePanel(frame, title), chart.getPanel()});
        super.refresh();
    }
}
