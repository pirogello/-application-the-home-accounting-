package individualFinance.gui.panel;

import individualFinance.gui.EnableEditDelete;
import individualFinance.gui.MainFrame;
import individualFinance.gui.Refresh;
import individualFinance.gui.table.TableData;
import individualFinance.gui.menu.MainMenu;
import individualFinance.gui.toolbar.AbstractToolbar;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

abstract public class RightPanel extends AbstractPanel{

    protected TableData td;

    private String title;
    private ImageIcon icon;
    private JPanel[] panels;

    public RightPanel(MainFrame frame, TableData td,String title, ImageIcon icon, JPanel[] panels){
        super(frame);
        this.td = td;
        this.title = title;
        this.icon = icon;
        this.panels = panels;
        init();
    }

    public RightPanel(MainFrame frame, TableData td, String title, ImageIcon icon, AbstractToolbar tb){
        this(frame,td,title, icon, new JPanel[]{tb});
    }

    public RightPanel(MainFrame frame, TableData td, String title, ImageIcon icon){
        this(frame,td,title, icon, new JPanel[]{});
    }

    @Override
    public void refresh(){
        super.refresh();
        if(td != null)
            td.refresh();
        for (JPanel panel : panels) {
            if(panel instanceof Refresh)
                ((Refresh) panel).refresh();
        }
    }

    private void enableEditDelete(){
        for (JPanel panel : panels){
            if(panel instanceof EnableEditDelete)
                ((EnableEditDelete) panel).setEnableEditDelete(false);
        }
        ((MainMenu)frame.getJMenuBar()).setEnableEditDelete(false);

        if(td != null) {
            if (td.getSelectedRow() != -1) {
                for (JPanel panel : panels) {
                    if (panel instanceof EnableEditDelete)
                        ((EnableEditDelete) panel).setEnableEditDelete(true);
                }
                ((MainMenu) frame.getJMenuBar()).setEnableEditDelete(true);
            }
        }
    }

    protected void setPanels(JPanel[] panels){
        this.panels = panels;
    }

    @Override
    protected final void init() {
        enableEditDelete();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel header = new JLabel(Text.get(title));
        header.setFont(Style.FONT_LABEL_HEADER);
        header.setIcon(icon);
        header.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(header);

        if(panels.length == 0)
            add(Box.createVerticalStrut(Style.PADDING_PANEL_EMPTY));

        for (JPanel panel : panels) {
            add(panel);
            add(Box.createVerticalStrut(Style.PADDING_PANEL));
        }

        if(td != null) {
            JScrollPane scroll = new JScrollPane(td);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            add(scroll);
            ListSelectionModel selectionModel = td.getSelectionModel();
            selectionModel.addListSelectionListener(e -> enableEditDelete());
        }
    }


    public TableData getTableData(){
        return td;
    }

}
