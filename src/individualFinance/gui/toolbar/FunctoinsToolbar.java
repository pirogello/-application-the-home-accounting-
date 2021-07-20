package individualFinance.gui.toolbar;

import individualFinance.gui.EnableEditDelete;
import individualFinance.gui.Handler.Handler;
import individualFinance.gui.MainButton;
import individualFinance.settings.HandlerCode;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

public final class FunctoinsToolbar extends AbstractToolbar implements EnableEditDelete {

    private MainButton editButton;
    private MainButton deleteButton;

    public FunctoinsToolbar(Handler handler){
        super(Style.BORDER_FUNCTIONS_TOOLBAR, handler);
        init();
    }

    @Override
    protected void init() {
        addButton(Text.get("ADD"), Style.ICON_ADD, HandlerCode.ADD, false);
        editButton =  addButton(Text.get("EDIT"), Style.ICON_EDIT, HandlerCode.EDIT, false);
        deleteButton =  addButton(Text.get("DELETE"), Style.ICON_DELETE, HandlerCode.DELETE, false);
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        editButton.setEnabled(enable);
        deleteButton.setEnabled(enable);
    }
}
