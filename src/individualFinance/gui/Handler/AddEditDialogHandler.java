package individualFinance.gui.Handler;

import individualFinance.exeption.ModelExeption;
import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.AddEditDialog;
import individualFinance.gui.dialog.ErrorDialog;
import individualFinance.saveLoad.SaveData;
import individualFinance.settings.HandlerCode;

import java.awt.event.*;

public class AddEditDialogHandler extends Handler implements WindowListener, KeyListener {

    private final AddEditDialog dialog;

    public AddEditDialogHandler(MainFrame frame, AddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case HandlerCode.ADD: {
                addEdit(true);
                break;
            }
            case HandlerCode.EDIT: {
                addEdit(false);
                break;
            }
            case HandlerCode.CANCEL: {
                closeDialog();
            }
        }
        super.actionPerformed(e);
    }

    private void addEdit(boolean add){
        try {
            if(add) add();
            else edit();
            closeDialog();
        }
        catch (ModelExeption ex){
            ErrorDialog.show(frame, ex.getMassage());
        }
    }

    private void add() throws ModelExeption{
        SaveData.getInstance().add(dialog.getCommonFromForm());
    }
    private void edit() throws ModelExeption{
        SaveData.getInstance().edit(dialog.getCommon(), dialog.getCommonFromForm());
    }

    @Override
    public void windowClosing(WindowEvent e) {
        closeDialog();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
          addEdit(dialog.isAdd());
        }
    }

    private void closeDialog(){
        dialog.closeDialog();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }


    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
