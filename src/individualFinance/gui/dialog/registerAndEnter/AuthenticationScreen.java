package individualFinance.gui.dialog.registerAndEnter;

import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.ConfirmDialog;
import individualFinance.saveLoad.SaveData;
import individualFinance.saveLoad.User;
import individualFinance.saveLoad.Users;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AuthenticationScreen extends JDialog {

    private JPasswordField password;
    private JTextField login;
    protected MainFrame frame;

    public AuthenticationScreen(MainFrame frame) {
        super(frame, Text.get("AUTHENTICATION"), true);
        this.frame = frame;
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Users.getInstance().save();
                System.exit(0);
            }
        });
       // setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    private void init(){
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelLogin = new JLabel(Text.get("INPUT_LOGIN"), SwingConstants.RIGHT);
        labelLogin.setFont(Style.FONT_TABLE_HEADER);
        labelLogin.setPreferredSize(Style.DIMENSION_REGISTER_TEXT_FIELD_SIZE);
        panelLogin.add(labelLogin);
        login = new JTextField();
        login.setPreferredSize(Style.DIMENSION_REGISTER_TEXT_FIELD_SIZE);
        login.setText("LOGIN");
        panelLogin.add(login);
        add(panelLogin);

        JPanel panelPassword = new JPanel();
        panelPassword.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelPassword = new JLabel(Text.get("INPUT_PASSWORD"), SwingConstants.RIGHT);
        labelPassword.setFont(Style.FONT_TABLE_HEADER);
        labelPassword.setPreferredSize(Style.DIMENSION_REGISTER_TEXT_FIELD_SIZE);
        panelPassword.add(labelPassword);
        password = new JPasswordField();
        password.setPreferredSize(Style.DIMENSION_REGISTER_TEXT_FIELD_SIZE);
        password.setText("PASSWORD");
        panelPassword.add(password);
        add(panelPassword);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelButton.add(new RegisterButton());
        panelButton.add(new InitButton());
        add(panelButton);
        pack();
    }

    public void showScreen(){
        init();
        setLocationRelativeTo(null);
        User userSaves = null;
        for (User user:Users.getInstance().getUsers()) {
            if(user.isSave())
                userSaves = user;
        }
        if(userSaves != null) {
            try {
                SaveData.getInstance().SetSaveData(userSaves);
                frame.refresh();
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
        }else
            setVisible(true);
    }

    public void closeScreen(){
        setVisible(false);
    }


    private class RegisterButton extends JButton{

        public RegisterButton(){
            super(Text.get("REGISTRATION"));
            setFocusPainted(false);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new RegisterScreen(frame).showScreen();
                }
            });
        }
    }

    private class InitButton extends JButton {

        public InitButton(){
            super(Text.get("ENTER"));
            setFocusPainted(false);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    User tryEnter = new User(login.getText(), new String(password.getPassword()));
                    for (User user: Users.getInstance().getUsers()) {
                        if(user.getLogin().equals(tryEnter.getLogin()) && user.getPassword().equals(tryEnter.getPassword())) {
                            user.setSave(true);
                            try {
                                SaveData.getInstance().SetSaveData(user);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                            closeScreen();
                            frame.refresh();
                        }
                    }
                }
            });
        }
    }
}

