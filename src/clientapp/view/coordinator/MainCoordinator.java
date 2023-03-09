package clientapp.view.coordinator;

import clientapp.view.controller.AddAppointmentController;
import clientapp.view.controller.AppointmentsController;
import clientapp.view.controller.EditAppointmentController;
import clientapp.view.controller.LoginController;
import clientapp.view.controller.MainController;
import clientapp.view.form.AddAppointmentForm;
import clientapp.view.form.AppointmentsForm;
import clientapp.view.form.EditAppointmentForm;
import clientapp.view.form.LoginForm;
import clientapp.view.form.MainForm;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class MainCoordinator {

    private static MainCoordinator instance;
    private final MainController mainController;

    private AppointmentsController appointmentsListener;
    
    
    
    private final Map<String, Object> params;


    private MainCoordinator() {
        mainController = new MainController(new MainForm());
        params = new HashMap<>();
    }

    public static MainCoordinator getInstance() {
        if (instance == null) {
            instance = new MainCoordinator();
        }
        return instance;
    }

    public void addParam(String name, Object key) {
        params.put(name, key);
    }

    public Object getParam(String name) {
        return params.get(name);
    }

    // LOGIN FORM
    public void openLoginForm() {
        LoginController loginController = new LoginController(new LoginForm());
        loginController.openForm();
    }

    // MAIN FORM
    public void openMainForm() {
        mainController.openForm();
    }

    public MainController getMainController() {
        return mainController;
    }
    
    // APPOINTMENT FORM
    public void openAppointmentsForm() {
        AppointmentsController appointmentController = new AppointmentsController(new AppointmentsForm());
        appointmentController.openForm();
    }
    
    // EDIT APPOINTMENT FORM
    public void openEditAppointmentForm(Long id, AppointmentsController parentController) {
        EditAppointmentController editController = new EditAppointmentController(new EditAppointmentForm(id, parentController));
        editController.openForm();
    }
    
    // ADD APPOINTMENT FORM
    public void openAddAppointmentForm(AppointmentsController parentController) {
        AddAppointmentController addController = new AddAppointmentController(new AddAppointmentForm(), parentController);
        addController.openForm();
    }
}
