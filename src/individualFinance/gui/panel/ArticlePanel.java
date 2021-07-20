package individualFinance.gui.panel;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.AccountAddEditDialog;
import individualFinance.gui.dialog.ArticleAddEditDialog;
import individualFinance.gui.table.AccountTableData;
import individualFinance.gui.table.ArticleTableData;
import individualFinance.gui.toolbar.FunctoinsToolbar;
import individualFinance.settings.Style;

public class ArticlePanel extends RightPanel{

    public ArticlePanel(MainFrame frame){
        super(frame, new ArticleTableData(new FunctionHandler(frame, new ArticleAddEditDialog(frame))), "ARTICLES", Style.ICON_PANEL_ARTICLES,
                new FunctoinsToolbar(new FunctionHandler(frame, new ArticleAddEditDialog(frame))));
    }
}
