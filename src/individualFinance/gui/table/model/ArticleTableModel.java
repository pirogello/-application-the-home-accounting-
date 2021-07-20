package individualFinance.gui.table.model;

import individualFinance.model.Account;
import individualFinance.model.Article;
import individualFinance.saveLoad.SaveData;
import individualFinance.settings.Format;

public class ArticleTableModel extends MainTableModel{

    private static final int TITLE = 0;


    public ArticleTableModel(String[] columns) {
        super(SaveData.getInstance().getArticles(), columns);

    }


    @Override
    protected void updateData() {
            data = SaveData.getInstance().getArticles();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(data.isEmpty()) return null;
        Article article = (Article) data.get(rowIndex);
        switch (columnIndex){
            case TITLE:
                return article.getTitle();
        }
        return null;
    }
}
