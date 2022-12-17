package clientapp;

import clientapp.view.coordinator.MainCoordinator;

/**
 *
 * @author Lenovo
 */
public class ClientApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
        ClientApp app = new ClientApp();
        app.connectToServer();
        */
        MainCoordinator.getInstance().openLoginForm();

    }

    /*
    private void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 9000);
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ClientApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    */
    

}
