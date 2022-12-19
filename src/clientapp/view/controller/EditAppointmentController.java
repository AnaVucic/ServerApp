/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientapp.view.controller;

import clientapp.communication.Communication;
import clientapp.view.constants.Constant;
import clientapp.view.coordinator.MainCoordinator;
import clientapp.view.form.EditAppointmentForm;
import commonlib.domain.Appointment;
import commonlib.domain.Dog;
import commonlib.domain.Salon;
import commonlib.domain.Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class EditAppointmentController {

    private final EditAppointmentForm editAppointmentForm;
    List<Service> services;

    public EditAppointmentController(EditAppointmentForm editAppointmentForm) {
        this.editAppointmentForm = editAppointmentForm;
        addActionListeners();
    }

    private void addActionListeners() {
        editAppointmentForm.btnSaveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateAppointment();
                    Appointment a = generateAppointment(new Appointment());
                    Appointment savedAppointment = Communication.getInstance().saveAppointment(a);
                    JOptionPane.showMessageDialog(editAppointmentForm, "System has saved appointment with ID: " + savedAppointment.getAppointmentID() + "!", "Message", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    Logger.getLogger(EditAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        );

        editAppointmentForm.chkBathActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Service s = Communication.getInstance().getService("bath");
                    services.add(s);
                } catch (Exception ex) {
                    Logger.getLogger(EditAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        
        editAppointmentForm.chkEarActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Service s = Communication.getInstance().getService("ear care");
                    services.add(s);
                } catch (Exception ex) {
                    Logger.getLogger(EditAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }

    private void validateAppointment() throws Exception {

        String error = "";

        if (editAppointmentForm.getCmbPerson().getSelectedItem() == null) {
            error += "Owner must be selected!\n";
        }

        if (editAppointmentForm.getCmbSalon().getSelectedItem() == null) {
            error += "Salon must be selected!\n";
        }

        if (editAppointmentForm.getCmbDog().getSelectedItem() == null) {
            error += "Dog must be selected!\n";
        }

        if (editAppointmentForm.getChkBath().isSelected() == false
                && editAppointmentForm.getChkEar().isSelected() == false
                && editAppointmentForm.getChkNail().isSelected() == false
                && editAppointmentForm.getChkStyle().isSelected() == false
                && editAppointmentForm.getChkTeeth().isSelected() == false
                && editAppointmentForm.getChkTrim().isSelected() == false) {
            error += "At least one service must be selected!\n";
        }

        if (editAppointmentForm.getTxtDate().getText().isEmpty()) {
            error += "Date must be filled!\n";
        }

        if (editAppointmentForm.getTxtTime().getText().isEmpty()) {
            //check if that time and that date is occupied
            error += "Time must be filled!\n";
        }

        if (!error.isEmpty()) {
            throw new Exception(error);
        }
    }

    private Appointment generateAppointment(Appointment a) {

        //
        // impl services and dateTime
        //
        a.setDog((Dog) editAppointmentForm.getCmbDog().getSelectedItem());
        a.setSalon((Salon) editAppointmentForm.getCmbSalon().getSelectedItem());
        a.setServices(services);
        a.setAppointmentID(Long.MIN_VALUE);

        return a;
    }
}
