package clientapp.view.controller;

import clientapp.communication.Communication;
import clientapp.view.form.EditAppointmentForm;
import clientapp.view.form.component.table.ServiceTableModel;
import commonlib.domain.Appointment;
import commonlib.domain.AppointmentService;
import commonlib.domain.Dog;
import commonlib.domain.Person;
import commonlib.domain.Salon;
import commonlib.domain.Service;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        form.btnSaveActionListener((ActionEvent e) -> {
            try {
                validateAppointment();
                generateAppointment();
                Communication.getInstance().editAppointment(appointment);
                JOptionPane.showMessageDialog(form, "System has changed appointment with ID: " + appointment.getAppointmentID() + "!", "Message", JOptionPane.INFORMATION_MESSAGE);
                form.dispose();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(form, "Invaid date and/or time input(s)" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        form.cmbPersonPropertyChangeListener((ActionEvent e) -> {
            Person newPerson = (Person) form.getCmbPerson().getSelectedItem();
            fillComboDog();
            form.getCmbDog().setSelectedIndex(1);
        });

        form.btnIncludeActionListener((ActionEvent e) -> {
            int row = form.getTblServices().getSelectedRow();
            if (row == -1 || form.getTblServices().getValueAt(row, 4) == Boolean.TRUE) {
                System.out.println("This service is already included or no service is selected");
            } else {
                AppointmentService as = new AppointmentService();
                as.setAppointment(appointment.getAppointmentID());
                as.setService((Long) form.getTblServices().getValueAt(row, 0));
                try {
                    Communication.getInstance().saveAppointmentService(as);

                } catch (Exception ex) {
                    Logger.getLogger(EditAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Service newService = ((ServiceTableModel) form.getTblServices().getModel()).getService(row);
                appointment.getServices().add(newService);
                form.getTxtTotalDuration().setText(String.valueOf(Integer.parseInt(form.getTxtTotalDuration().getText()) + newService.getDuration()));
                form.getTxtTotalFee().setText(String.valueOf(newService.getFee().add(new BigDecimal(form.getTxtTotalFee().getText()))));
                form.getTblServices().setValueAt(Boolean.TRUE, row, 4);
                ((ServiceTableModel) form.getTblServices().getModel()).fireTableCellUpdated(row, 4);
            }
        });

        form.btnExcludeActionListener((ActionEvent) -> {
            System.out.println(appointment.getServices().size());
            int row = form.getTblServices().getSelectedRow();
            if (row == -1 || form.getTblServices().getValueAt(row, 4) == Boolean.FALSE || appointment.getServices().size() == 1) {
                System.out.println("This service is already excluded or no service is selected");
            } else {
                AppointmentService as = new AppointmentService();
                as.setAppointment(appointment.getAppointmentID());
                as.setService((Long) form.getTblServices().getValueAt(row, 0));
                try {
                    Communication.getInstance().removeAppointmentService(as);
                } catch (Exception ex) {
                    Logger.getLogger(EditAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Service oldService = ((ServiceTableModel) form.getTblServices().getModel()).getService(row);
                appointment.getServices().remove(oldService);
                form.getTxtTotalDuration().setText(String.valueOf(Integer.parseInt(form.getTxtTotalDuration().getText()) - oldService.getDuration()));
                form.getTxtTotalFee().setText(String.valueOf(new BigDecimal(form.getTxtTotalFee().getText()).subtract(oldService.getFee())));
                form.getTblServices().setValueAt(Boolean.FALSE, row, 4);
                ((ServiceTableModel) form.getTblServices().getModel()).fireTableCellUpdated(row, 4);
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d H:m");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        appointment.setDateTime(dateTime);

        appointment.setDog((Dog) form.getCmbDog().getSelectedItem());
        appointment.setSalon((Salon) form.getCmbSalon().getSelectedItem());

        List<Service> newServices = new ArrayList<Service>();

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
        form.setLocationRelativeTo(null);
        form.setExtendedState(Frame.MAXIMIZED_BOTH);
        prepareID();
        prepareForm();
    }

    private void prepareID() {
        Long id = form.getId();
        Appointment a = new Appointment();
        a.setAppointmentID(id);
        try {
            appointment = (Appointment) Communication.getInstance().findAppointments(a).get(0);
            form.getTxtAppointmentId().setText(appointment.getAppointmentID().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Error while getting the appointment\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            form.dispose();
        }
    }

    private void prepareForm() {
        fillTableServices();
        perpareComboBoxes();
        fillFieldsDateTime();
        fillFieldsDurationFee();
    }

    private void fillTableServices() {
        try {
            services = Communication.getInstance().getAllServices();
            ServiceTableModel model = new ServiceTableModel(services, appointment.getServices());
            form.getTblServices().setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void perpareComboBoxes() {
        fillComboOwner();
        fillComboDog();
        fillComboSalon();
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
        LocalDate date = appointment.getDateTime().toLocalDate();
        LocalTime time = appointment.getDateTime().toLocalTime();
        form.getTxtDate().setText(date.toString());
        form.getTxtTime().setText(time.toString());
    }

    private void fillFieldsDurationFee() {
        form.getTxtTotalDuration().setText(String.valueOf(appointment.getTotalDuration()));
        form.getTxtTotalFee().setText(appointment.getTotalFee().toString());
    }
}
