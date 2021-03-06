package individualFinance.gui.table.model;

import individualFinance.model.Transaction;
import individualFinance.saveLoad.SaveData;
import individualFinance.settings.Format;

import java.util.ArrayList;
import java.util.Arrays;

public class TransactionTableModel extends MainTableModel{

    private static final int DATE = 0;
    private static final int ACCOUNT = 1;
    private static final int ARTICLE = 2;
    private static final int AMOUNT = 3;
    private static final int NOTICE = 4;

    private int count = -1;

    public TransactionTableModel(String[] columns) {
        super(SaveData.getInstance().getFilterTransaction(), columns);
    }

    public TransactionTableModel(String[] columns, int count) {
        super(SaveData.getInstance().getTransactions(count), columns);
        this.count = count;
    }

    @Override
    protected void updateData() {
        if(count == -1)
            data = SaveData.getInstance().getFilterTransaction();
        else
            data = SaveData.getInstance().getTransactions(count);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(data.isEmpty()) return null;
        Transaction transaction = (Transaction) data.get(rowIndex);
        switch (columnIndex){
            case DATE:
                return Format.date(transaction.getDate());
            case ACCOUNT:
                return transaction.getAccount().getTitle();
            case ARTICLE:
                return transaction.getArticle().getTitle();
            case AMOUNT:
                return Format.amount(transaction.getAmount(),transaction.getAccount().getCurrency());
            case NOTICE:
                return transaction.getNotice();
        }
        return null;
    }
}
