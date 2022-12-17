/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientapp;

import clientapp.view.form.LoginForm;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ClientApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClientApp app = new ClientApp();
        app.connectToServer();

    }

    private void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 9000);
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ClientApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
