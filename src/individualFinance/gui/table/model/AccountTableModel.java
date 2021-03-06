package individualFinance.gui.table.model;

import individualFinance.model.Account;
import individualFinance.model.Transaction;
import individualFinance.saveLoad.SaveData;
import individualFinance.settings.Format;

import java.util.ArrayList;
import java.util.Arrays;

public class AccountTableModel extends MainTableModel{

    private static final int TITLE = 0;
    private static final int AMOUNT = 1;


    public AccountTableModel(String[] columns) {
        super(SaveData.getInstance().getAccounts(), columns);

    }


    @Override
    protected void updateData() {
            data = SaveData.getInstance().getAccounts();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(data.isEmpty()) return null;
        Account account = (Account) data.get(rowIndex);
        switch (columnIndex){
            case TITLE:
                return account.getTitle();
            case AMOUNT:
                return Format.amount(account.getAmount(), account.getCurrency());
        }
        return null;
    }
}
