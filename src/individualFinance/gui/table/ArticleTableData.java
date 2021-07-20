package individualFinance.gui.table;

import individualFinance.gui.Handler.FunctionHandler;
import individualFinance.gui.table.model.AccountTableModel;
import individualFinance.gui.table.model.ArticleTableModel;
import individualFinance.settings.Style;

import javax.swing.*;

public final class ArticleTableData extends TableData{

    private static final String[] columns = new String[]{"TITLE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE};

    public ArticleTableData(FunctionHandler handler){
        super(new ArticleTableModel(columns),handler, icons, columns);
    }


}
