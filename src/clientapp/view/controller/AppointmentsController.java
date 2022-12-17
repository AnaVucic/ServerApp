/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientapp.view.controller;

import clientapp.view.form.AppointmentsForm;
import clientapp.view.form.component.table.AppointmentTableModel;
import commonlib.domain.Appointment;
import commonlib.domain.Salon;
import java.util.List;
import clientapp.communication.Communication;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class AppointmentsController {

    private final AppointmentsForm appointmentsForm;
    private List<Appointment> appointments;
    private List<Salon> salons;

    public AppointmentsController(AppointmentsForm appointmentsForm) {
        this.appointmentsForm = appointmentsForm;
        addActionListeners();
    }

    private void addActionListeners() {

    }

    public void openForm() {
        prepareView();

    }

    private void prepareView() {
        fillComboSalon();
    }

    private void fillComboSalon() {
        appointmentsForm.getCmbSalon().removeAllItems();
        appointmentsForm.getCmbSalon().setEnabled(false);
        appointmentsForm.getCmbSalon().insertItemAt(null, 0);
        for (Salon s : salons) {
            appointmentsForm.getCmbSalon().addItem(s.toString());
        }
    }
    
    private void setupComponents() {
        fillAppointmentTable(); //add date requirement whitch is from today into the future
    }

    private void fillAppointmentTable() {
        try {
        appointments = Communication.getInstance().getAllAppointments();
        AppointmentTableModel model = new AppointmentTableModel(appointments);
        appointmentsForm.getTblAppointments().setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(appointmentsForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 

}
