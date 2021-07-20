package individualFinance.gui.dialog.registerAndEnter;

import individualFinance.gui.MainFrame;
import individualFinance.gui.dialog.ErrorDialog;
import individualFinance.saveLoad.User;
import individualFinance.saveLoad.Users;
import individualFinance.settings.Style;
import individualFinance.settings.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterScreen extends JDialog {

    private JPasswordField password;
    private JPasswordField passwordCheck;
    private JTextField login;
    protected MainFrame frame;

    public RegisterScreen(MainFrame frame){
        super(frame, Text.get("REGISTER"), true);
        setResizable(false);
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

        JPanel panelPasswordCheck = new JPanel();
        panelPasswordCheck.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelPasswordCheck = new JLabel(Text.get("INPUT_PASSWORD_AGAIN"), SwingConstants.RIGHT);
        labelPasswordCheck.setFont(Style.FONT_TABLE_HEADER);
        labelPasswordCheck.setPreferredSize(Style.DIMENSION_REGISTER_TEXT_FIELD_SIZE);
        panelPasswordCheck.add(labelPasswordCheck);
        passwordCheck = new JPasswordField();
        passwordCheck.setPreferredSize(Style.DIMENSION_REGISTER_TEXT_FIELD_SIZE);
        passwordCheck.setText("PASSWORD");
        panelPasswordCheck.add(passwordCheck);
        add(panelPasswordCheck);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelButton.add(new RegisterScreen.RegisterButton());
        add(panelButton);

        pack();
    }

    public void showScreen(){
        init();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void closeScreen(){
        setVisible(false);
    }


    public class RegisterButton extends JButton {

        public RegisterButton(){
            super(Text.get("REGISTER"));
            setFocusPainted(false);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    boolean loginExists = false;
                    for (User user : Users.getInstance().getUsers()) {
                        if(user.getLogin().equals(login.getText()))
                            loginExists = true;
                    }
                    if(!loginExists && new String(password.getPassword()).equals(new String(passwordCheck.getPassword()))) {
                        Users.getInstance().addUser(new User(login.getText(), new String(password.getPassword())));
                        closeScreen();
                    }
                    else {
                       new ErrorDialog().show(frame, Text.get("LOGIN_IS_EXIST_OR_PASS_DOESNT_MATCH"));
                    }
                }
            });
        }
    }
}
