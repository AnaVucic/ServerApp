/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.view.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import serverapp.controller.Controller;
import serverapp.view.form.MainForm;

/**
 *
 * @author Lenovo
 */
public class MainController {
    
    private final MainForm mainForm;
    
    public MainController(MainForm serverForm) {
        this.mainForm = serverForm;
        
    }
    
    public void openForm() {
        try {
            mainForm.setLocationRelativeTo(null);
            mainForm.setVisible(true);
            mainForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Controller.getInstance().startServer();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
