/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientapp.view.controller;

import clientapp.view.coordinator.MainCoordinator;
import clientapp.view.form.MainForm;
import commonlib.domain.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clientapp.view.constants.Constant;

/**
 *
 * @author Lenovo
 */
public class MainController {
    
    private final MainForm mainForm;
    
    public MainController(MainForm mainForm) {
        this.mainForm = mainForm;
        addActionListeners();
    }
    
    public void openForm() {
        mainForm.setTitle("Main menu");
        User user = (User) MainCoordinator.getInstance().getParam(Constant.LOGGED_IN_USER);
        mainForm.getLblCurrentUser().setText("Logged in user: " + user.getUsername());
        mainForm.setLocationRelativeTo(null);
        mainForm.setVisible(true);
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
