/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.view.controller;

import javax.swing.JFrame;
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
    
    public void openForm(){
        mainForm.setLocationRelativeTo(null);
        mainForm.setVisible(true);
        mainForm.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
    
}
