package individualFinance.gui.dialog;

import individualFinance.exeption.ModelExeption;
import individualFinance.gui.MainDatePicker;
import individualFinance.gui.MainFrame;
import individualFinance.model.*;
import individualFinance.saveLoad.SaveData;
import individualFinance.settings.Format;
import individualFinance.settings.Style;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.util.Date;

public class TransactionAddEditDialog extends AddEditDialog{

    public TransactionAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put("LABEL_DATE", new MainDatePicker().getDatePicker());
        components.put("LABEL_ACCOUNT", new CommonComboBox(SaveData.getInstance().getAccounts().toArray()));
        components.put("LABEL_ARTICLE", new CommonComboBox(SaveData.getInstance().getArticles().toArray()));
        components.put("LABEL_AMOUNT", new JTextField());
        components.put("LABEL_NOTICE", new JTextField());

        icons.put("LABEL_DATE", Style.ICON_DATE);
        icons.put("LABEL_ACCOUNT", Style.ICON_ACCOUNT);
        icons.put("LABEL_ARTICLE", Style.ICON_ARTICLE);
        icons.put("LABEL_AMOUNT", Style.ICON_AMOUNT);
        icons.put("LABEL_NOTICE", Style.ICON_NOTICE);

        values.put("LABEL_DATE", new Date());
    }

    @Override
    protected void setValues() {
        Transaction transaction = (Transaction) c;
        values.put("LABEL_DATE", transaction.getDate());
        values.put("LABEL_ACCOUNT", transaction.getAccount());
        values.put("LABEL_ARTICLE", transaction.getArticle());
        values.put("LABEL_AMOUNT",transaction.getAmount());
        values.put("LABEL_NOTICE", transaction.getNotice());
    }

    @Override
    public Common getCommonFromForm() throws ModelExeption {
        try {
            Account account =  (Account) (((CommonComboBox) components.get("LABEL_ACCOUNT")).getSelectedItem());
            Article article =  (Article) (((CommonComboBox) components.get("LABEL_ARTICLE")).getSelectedItem());
            String notice = ((JTextField) components.get("LABEL_NOTICE")).getText();
            String amount = ((JTextField) components.get("LABEL_AMOUNT")).getText();
            Date date = (Date) (((JDatePickerImpl) components.get("LABEL_DATE")).getModel().getValue());

            return new Transaction(account, article,Format.fromAmountToNumb(amount), notice, date);
        }catch (NumberFormatException e){
            throw new ModelExeption(ModelExeption.AMOUNT_FORMAT);
        }
    }
}
