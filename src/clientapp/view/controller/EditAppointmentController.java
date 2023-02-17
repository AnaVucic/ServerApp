package clientapp.view.controller;

import clientapp.communication.Communication;
import clientapp.view.form.EditAppointmentForm;
import commonlib.domain.Appointment;
import commonlib.domain.AppointmentService;
import commonlib.domain.Dog;
import commonlib.domain.Person;
import commonlib.domain.Salon;
import commonlib.domain.Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
    private List<Service> services;

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
                    generateAppointment();
                    Communication.getInstance().editAppointment(appointment);
                    for(Service s:appointment.getServices()){
                        AppointmentService as = new AppointmentService();
                        as.setAppointment(appointment.getAppointmentID());
                        as.setService(s.getServiceID());
                        
                    }
                    //Communication.getInstance().editAppointmentService();
                    JOptionPane.showMessageDialog(form, "System has changed appointment with ID: " + appointment.getAppointmentID() + "!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    form.dispose();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(form, "Invaid date and/or time input(s)" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void generateAppointment() throws ParseException, Exception {
        String dateTimeString = form.getTxtDate().getText() + " " + form.getTxtTime().getText();
        Date dateTime;
        try {
            dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateTimeString);
        } catch (ParseException ex) {
            throw ex;
        }
        appointment.setDateTime(dateTime.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());

        appointment.setDog((Dog) form.getCmbDog().getSelectedItem());
        appointment.setSalon((Salon) form.getCmbSalon().getSelectedItem());

        List<Service> newServices = new ArrayList<Service>();
        if (form.getChkBath().isSelected()) {
            newServices.add(services.get(0));
        }
        if (form.getChkTrim().isSelected()) {
            newServices.add(services.get(1));
        }
        if (form.getChkNail().isSelected()) {
            newServices.add(services.get(2));
        }
        if (form.getChkEar().isSelected()) {
            newServices.add(services.get(3));
        }
        if (form.getChkTeeth().isSelected()) {
            newServices.add(services.get(4));
        }
        if (form.getChkStyle().isSelected()) {
            newServices.add(services.get(5));
        }
        if (newServices.size() == 0) {
            throw new Exception("Choose at least one service.");
        }
        appointment.setServices(newServices);
        int duration = 0;
        BigDecimal fee = new BigDecimal(0);
        for (Service s : appointment.getServices()) {
            duration += s.getDuration();
            fee = fee.add(s.getFee());
        }
        System.out.println("Duration: " + duration);
        System.out.println("Fee: " + fee);
        appointment.setTotalDuration(duration);
        appointment.setTotalFee(fee);
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
        getServices();
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
        String time = appointment.getDateTime().getHour() + ":"
                + appointment.getDateTime().getMinute();
        form.getTxtTime().setText(time);
    }

    private void fillFieldsDurationFee() {
        form.getTxtTotalDuration().setText(String.valueOf(appointment.getTotalDuration()));
        form.getTxtTotalFee().setText(appointment.getTotalFee().toString());
    }

    private void getServices() {
        try {
            services = Communication.getInstance().getAllServices();
        } catch (Exception ex) {
            System.out.println("Exception while getting esrvices. " + ex.getMessage());
        }
    }
}
