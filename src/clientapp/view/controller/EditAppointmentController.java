/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientapp.view.controller;

import clientapp.communication.Communication;
import clientapp.view.form.EditAppointmentForm;
import commonlib.domain.Appointment;
import commonlib.domain.Dog;
import commonlib.domain.Person;
import commonlib.domain.Salon;
import commonlib.domain.Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class EditAppointmentController {

    private final EditAppointmentForm form;
    private Appointment appointment;
    private List<Person> persons;
    private List<Dog> dogs;
    private List<Salon> salons;

    public EditAppointmentController(EditAppointmentForm editAppointmentForm) {
        this.form = editAppointmentForm;
        addActionListeners();
    }

    private void addActionListeners() {
        form.btnSaveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateAppointment();
                    Appointment a = generateAppointment(new Appointment());
                    //Appointment savedAppointment = Communication.getInstance().saveAppointment(a);
                    //JOptionPane.showMessageDialog(editAppointmentForm, "System has saved appointment with ID: " + savedAppointment.getAppointmentID() + "!", "Message", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    Logger.getLogger(EditAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        );

        form.cmbPersonPropertyChangeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person newPerson = (Person) form.getCmbPerson().getSelectedItem();
                fillComboDog();
                form.getCmbDog().setSelectedIndex(1);
            }
        });

    }

    private void validateAppointment() throws Exception {

        String error = "";

        if (form.getCmbPerson().getSelectedItem() == null) {
            error += "Owner must be selected!\n";
        }

        if (form.getCmbSalon().getSelectedItem() == null) {
            error += "Salon must be selected!\n";
        }

        if (form.getCmbDog().getSelectedItem() == null) {
            error += "Dog must be selected!\n";
        }

        if (form.getChkBath().isSelected() == false
                && form.getChkEar().isSelected() == false
                && form.getChkNail().isSelected() == false
                && form.getChkStyle().isSelected() == false
                && form.getChkTeeth().isSelected() == false
                && form.getChkTrim().isSelected() == false) {
            error += "At least one service must be selected!\n";
        }

        if (form.getTxtDate().getText().isEmpty()) {
            error += "Date must be filled!\n";
        }

        if (form.getTxtTime().getText().isEmpty()) {
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
        a.setDog((Dog) form.getCmbDog().getSelectedItem());
        a.setSalon((Salon) form.getCmbSalon().getSelectedItem());
        //a.setServices(services);
        a.setAppointmentID(Long.MIN_VALUE);

        return a;
    }

    public void openForm() {
        form.setVisible(true);
        prepareAppointment();
        prepareForm();
    }

    private void prepareAppointment() {
        Long id = form.getId();
        Appointment a = new Appointment();
        a.setAppointmentID(id);
        try {
            appointment = (Appointment) Communication.getInstance().findAppointments(a).get(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Error while getting the appointment\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            form.dispose();
        }
    }

    private void prepareForm() {
        form.getTxtAppointmentId().setText(appointment.getAppointmentID().toString());
        prepareServices();
        perpareComboBoxes();
    }

    private void prepareServices() {
        for (Service s : appointment.getServices()) {
            if (s.getName().equals("bath")) {
                form.getChkBath().setSelected(true);
            }
            if (s.getName().equals("trimming")) {
                form.getChkTrim().setSelected(true);
            }
            if (s.getName().equals("nail care")) {
                form.getChkNail().setSelected(true);
            }
            if (s.getName().equals("ear care")) {
                form.getChkEar().setSelected(true);
            }
            if (s.getName().equals("teeth care")) {
                form.getChkTeeth().setSelected(true);
            }
            if (s.getName().equals("styling")) {
                form.getChkStyle().setSelected(true);
            }
        }
    }

    private void perpareComboBoxes() {
        fillComboOwner();
        fillComboDog();
        fillComboSalon();
        fillFieldsDateTime();
        fillFieldsDurationFee();
    }

    private void fillComboOwner() {
        try {
            form.getCmbPerson().removeAllItems();
            form.getCmbPerson().setEnabled(false);
            form.getCmbPerson().addItem(null);
            persons = Communication.getInstance().getAllPersons();
            for (Person p : persons) {
                form.getCmbPerson().addItem(p);
            }
            form.getCmbPerson().setSelectedItem(appointment.getDog().getPerson());
            form.getCmbPerson().setEnabled(true);

        } catch (Exception ex) {
            Logger.getLogger(AppointmentsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillComboDog() {
        try {
            form.getCmbDog().removeAllItems();
            form.getCmbDog().setEnabled(false);
            form.getCmbDog().addItem(null);
            dogs = Communication.getInstance().getAllDogs();
            for (Dog d : dogs) {
                if (d.getPerson().equals(form.getCmbPerson().getSelectedItem())) {
                    form.getCmbDog().addItem(d);
                }
            }
            form.getCmbDog().setSelectedItem(appointment.getDog());
            form.getCmbDog().setEnabled(true);

        } catch (Exception ex) {
            Logger.getLogger(AppointmentsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillComboSalon() {
        try {
            form.getCmbSalon().removeAllItems();
            form.getCmbSalon().setEnabled(false);
            form.getCmbSalon().addItem(null);
            salons = Communication.getInstance().getAllSalons();
            for (Salon s : salons) {
                form.getCmbSalon().addItem(s);
            }
            form.getCmbSalon().setSelectedItem(appointment.getSalon());
            form.getCmbSalon().setEnabled(true);

        } catch (Exception ex) {
            Logger.getLogger(AppointmentsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillFieldsDateTime() {
        String date = appointment.getDateTime().getDayOfMonth() + "/"
                + appointment.getDateTime().getMonth().getValue() + "/"
                + appointment.getDateTime().getYear();
        form.getTxtDate().setText(date);
        String time = appointment.getDateTime().getHour() + ":" +
                appointment.getDateTime().getMinute();
        form.getTxtTime().setText(time);
    }

    private void fillFieldsDurationFee() {
        form.getTxtTotalDuration().setText(String.valueOf(appointment.getTotalDuration()));
        form.getTxtTotalFee().setText(appointment.getTotalFee().toString());
    }
}
