package individualFinance.gui.panel;

import individualFinance.gui.MainFrame;
import individualFinance.model.Currency;
import individualFinance.model.Statistics;
import individualFinance.saveLoad.SaveData;
import individualFinance.settings.Format;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public final class LeftPanel extends AbstractPanel{

    public LeftPanel(MainFrame frame) {
        super(frame);
        init();

    }

    @Override
    protected void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(Style.BORDER_LEFT_PANEL);
        JLabel headerBG = new JLabel(Text.get("BALANCE_CURRENCIES"));
        headerBG.setFont(Style.FONT_LABEL_HEADER);
        headerBG.setIcon(Style.ICON_LEFT_PANEL_BALANCE_CURRENCIES);
        headerBG.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headerBG);

        addBalanceCurrency();
        add(Box.createVerticalStrut(Style.PADDING_LABEL_BALANCE));

        JLabel headerB = new JLabel(Text.get("BALANCE"));
        headerB.setFont(Style.FONT_LABEL_HEADER);
        headerB.setIcon(Style.ICON_LEFT_PANEL_BALANCE);
        headerB.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        add(headerB);
        addBalance();

    }

    private void addBalance() {
        JPanel panelBalance = new JPanel();
        panelBalance.setLayout(new BorderLayout());
        CommonComboBox cb = new CommonComboBox(SaveData.getInstance().getEnableCurrency().toArray());
        Currency startCurrency = SaveData.getInstance().getBaseCurrency();
        PanelBalanceCurrency balance = new PanelBalanceCurrency(startCurrency, Statistics.getBalanceCurrency(startCurrency));
        balance.OnlyBalance(new JLabel(Format.amount(Statistics.getBalance(startCurrency), startCurrency)));
        panelBalance.add(balance, BorderLayout.EAST);
        cb.addActionListener(e -> {
            for (Currency currency: SaveData.getInstance().getCurrencies()) {
                if(currency.equals(cb.getSelectedItem())) {
                    balance.OnlyBalance(new JLabel(Format.amount(Statistics.getBalance(currency), currency)));
                    //revalidate();
                    frame.pack();
                }
            }
        });
        panelBalance.add(cb, BorderLayout.WEST);
        add(panelBalance);
    }



    private void addBalanceCurrency() {
        for (Currency currency : SaveData.getInstance().getEnableCurrency()) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE));
            add(new PanelBalanceCurrency(currency, Statistics.getBalanceCurrency(currency)));
        }
    }

    private class PanelBalanceCurrency extends JPanel{

        JLabel currencyLabel;
        JLabel amountLabel;

        public PanelBalanceCurrency(Currency currency, double amount){
            super();
            setLayout(new BorderLayout());
            setBackground(Style.COLOR_LEFT_PANEL_BALANCE);
            setBorder(Style.BORDER_PANEL);

            currencyLabel = new JLabel(currency.getTitle());
            amountLabel = new JLabel(Format.amount(amount, currency));
            currencyLabel.setFont(Style.FONT_LEFT_PANEL_CURRENCY);
            amountLabel.setFont(Style.FONT_LEFT_PANEL_AMOUNT);
            add(currencyLabel, BorderLayout.WEST);
            add(Box.createRigidArea(Style.DIMENSION_PADDING_BALANCE));
            add(amountLabel, BorderLayout.EAST);
        }

        public void OnlyBalance(JLabel amount){
            removeAll();
            amountLabel = amount;
            amountLabel.setFont(Style.FONT_LEFT_PANEL_AMOUNT);
            add(amountLabel, BorderLayout.EAST);
        }

    }


    private class CommonComboBox extends JComboBox {

        public CommonComboBox(Object[] objs){
            super(objs);
            setRenderer(new DefaultListCellRenderer(){

                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                    DefaultListCellRenderer renderer = (DefaultListCellRenderer)super.getListCellRendererComponent(list, value,index,isSelected,cellHasFocus);
                    Currency currency = (Currency) value;
                    if(currency != null) renderer.setText(currency.getValueForComboBox());
                    return renderer;
                }
            });
        }

    }
}
