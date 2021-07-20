package individualFinance.gui.Handler;

import individualFinance.gui.MainFrame;
import individualFinance.gui.panel.*;
import individualFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MenuViewHandler extends Handler{

    public MenuViewHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case HandlerCode.MENU_VIEW_ACCOUNTS: {
                showAccountPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_ARTICLES: {
                showArticlePanel();
                break;
            }
            case HandlerCode.MENU_VIEW_CURRENCIES: {
                showCurrencyPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_STATISTICS: {
                showStatisticPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_TRANSACTIONS: {
                showTransactionPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_TRANSFERS: {
                showTransferPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_OVERVIEW: {
                showOverviewPanel();
            }
            default: {
                break;
            }
        }
    }

    protected void showOverviewPanel(){
        frame.setRightPanel(new OverviewPanel(frame));
    }
    protected void showAccountPanel(){
        frame.setRightPanel(new AccountPanel(frame));
    }
    protected void showArticlePanel(){
        frame.setRightPanel(new ArticlePanel(frame));
    }
    protected void showCurrencyPanel(){
        frame.setRightPanel(new CurrencyPanel(frame));
    }
    protected void showTransactionPanel(){
        frame.setRightPanel(new TransactionPanel(frame));
    }
    protected void showTransferPanel(){
        frame.setRightPanel(new TransferPanel(frame));
    }
    protected void showStatisticPanel(){
        frame.setRightPanel(new StatisticPanel(frame));
    }

}
