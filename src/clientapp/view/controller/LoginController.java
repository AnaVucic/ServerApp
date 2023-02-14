package clientapp.view.controller;

import clientapp.view.constants.Constant;
import clientapp.view.coordinator.MainCoordinator;
import clientapp.view.form.LoginForm;
import commonlib.domain.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clientapp.communication.Communication;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LoginController {

    private final LoginForm loginForm;

    public LoginController(LoginForm loginForm) {
        this.loginForm = loginForm;
        addActionListeners();
    }

    public void openForm() {
        loginForm.setVisible(true);
        loginForm.setLocationRelativeTo(null);
    }

    private void addActionListeners() {
        
        loginForm.btnLoginActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    resetForm();
                    String username = loginForm.getTxtUsername().getText().trim();
                    String password = loginForm.getTxtPassword().getText().trim();
                    validateForm(username, password);
                    User user = Communication.getInstance().login(username, password);
                    JOptionPane.showMessageDialog(loginForm, "User " + user.getUsername()
                            + " logged in!",
                            "Login", JOptionPane.INFORMATION_MESSAGE);
                    loginForm.dispose();
                    MainCoordinator.getInstance().addParam(Constant.LOGGED_IN_USER, user);
                    MainCoordinator.getInstance().openMainForm();
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            private void resetForm() {
                loginForm.getLblUsernameError().setText("");
                loginForm.getLblPasswordError().setText("");
            }
            private void validateForm(String username, String password) throws Exception {
                String errorMessage = "";
                if (username.isEmpty()) {
                    loginForm.getLblUsernameError().setText("Username must be entered!");
                    errorMessage += "Username must be entered!\n";
                }
                if (password.isEmpty()) {
                    loginForm.getLblPasswordError().setText("Password must be entered!");
                    errorMessage += "Password must be entered!\n";
                }
                if (!errorMessage.isEmpty()) {
                    throw new Exception(errorMessage);
                }
            }
            private void clearInput() {
                loginForm.getTxtUsername().setText("");
                loginForm.getTxtPassword().setText("");
            }
        });
        
        
    }

}
