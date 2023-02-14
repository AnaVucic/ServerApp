package serverapp.view.coordinator;

import serverapp.view.controller.MainController;
import serverapp.view.form.MainForm;


public class MainCoordinator {

    private static MainCoordinator instance;
    private final MainController mainController;

    private MainCoordinator() {
        mainController = new MainController(new MainForm());
    }

    public static MainCoordinator getInstance() {
        if (instance == null) {
            instance = new MainCoordinator();
        }
        return instance;
    }

    public void openMainForm() {
        mainController.openForm();
    }

    public MainController getFrmMainController() {
        return mainController;
    }

}
