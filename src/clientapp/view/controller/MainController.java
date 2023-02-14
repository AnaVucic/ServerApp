package clientapp.view.controller;

import clientapp.view.coordinator.MainCoordinator;
import clientapp.view.form.MainForm;
import commonlib.domain.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clientapp.view.constants.Constant;

public class MainController {
    
    private final MainForm mainForm;
    
    public MainController(MainForm mainForm) {
        this.mainForm = mainForm;
        addActionListeners();
    }
    
    public void openForm() {
        User user = (User) MainCoordinator.getInstance().getParam(Constant.LOGGED_IN_USER);
        mainForm.setLocationRelativeTo(null);
        mainForm.setVisible(true);
        mainForm.getLblCurrentUser().setText(user.getUsername());
    }
    
    public MainForm getMainForm() {
        return mainForm;
    }
    
    private void addActionListeners() {
        mainForm.mniAppointmentsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                MainCoordinator.getInstance().openAppointmentsForm();
            }
        });
        
        
        
    }
    
}
