package individualFinance.gui;

import individualFinance.gui.Handler.MainToolbarHandler;
import individualFinance.gui.Handler.MainWindowHandler;
import individualFinance.gui.dialog.registerAndEnter.AuthenticationScreen;
import individualFinance.gui.menu.MainMenu;
import individualFinance.gui.panel.*;
import individualFinance.gui.table.TableData;
import individualFinance.gui.toolbar.MainToolbar;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh{

    private final GridBagConstraints constraints;
    private final MainMenu mb;
    private final MainToolbar toolbar;
    private final LeftPanel lp;
    private RightPanel rp;

    public MainFrame(){
        super(Text.get("PROGRAM_NAME"));
        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        mb = new MainMenu(this);
        setJMenuBar(mb);

        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        toolbar = new MainToolbar(new MainToolbarHandler(this));
        add(toolbar,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;

        lp = new LeftPanel(this);
        add(lp,constraints);

        setRightPanel(new OverviewPanel( this));


        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(new MainWindowHandler());

        new AuthenticationScreen(this).showScreen();
    }

    public void setRightPanel(RightPanel panel) {
        if(rp != null) remove(rp);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        rp = panel;
        rp.setBorder(Style.BORDER_PANEL);
        add(rp, constraints);
        pack();
    }


    @Override
    public void refresh() {
        //SwingUtilities.updateComponentTreeUI(this);
        mb.refresh();
        lp.refresh();
        rp.refresh();
        pack();

    }

    public LeftPanel getLp() {
        return lp;
    }

    public RightPanel getRp() {
        return rp;
    }
}
