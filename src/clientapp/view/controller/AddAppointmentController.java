/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientapp.view.controller;

import clientapp.communication.Communication;
import clientapp.view.form.AddAppointmentForm;
import commonlib.domain.Appointment;
import commonlib.domain.Dog;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class AddAppointmentController {

    private final AddAppointmentForm form;
    private List<Dog> dogs;
    private List<Salon> salons;
    private List<Service> services;
    private Appointment appointment;
    private Long id;

    public AddAppointmentController(AddAppointmentForm form) {
        this.form = form;
        addActionListeners();
    }

    private void addActionListeners() {
        form.getBtnAdd().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    addAppointment(appointment);
                    appointment.setAppointmentID(id);
                    JOptionPane.showMessageDialog(form, "Saved appointment with ID: " + appointment.getAppointmentID(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    form.dispose();
                }
                System.out.println(appointment);
            }

            private boolean validateFields() {
                boolean valid = false;
                try {
                    String dateTimeString = form.getTxtDate().getText() + " " + form.getTxtTime().getText();
                    Date dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateTimeString);

                    Dog dog = (Dog) form.getCmbDog().getSelectedItem();

                    Salon salon = (Salon) form.getCmbSalon().getSelectedItem();

                    if (dog == null) {
                        throw new Exception("Choose a dog.");
                    }
                    if (salon == null) {
                        throw new Exception("Choose a salon");
                    }
                    List<Service> selectedServices = new ArrayList<>();

                    if (form.getCbxBath().isSelected()) {
                        selectedServices.add(services.get(0));
                    }
                    if (form.getCbxTrimming().isSelected()) {
                        selectedServices.add(services.get(1));
                    }
                    if (form.getCbxNail().isSelected()) {
                        selectedServices.add(services.get(2));
                    }
                    if (form.getCbxEar().isSelected()) {
                        selectedServices.add(services.get(3));
                    }
                    if (form.getCbxTeeth().isSelected()) {
                        selectedServices.add(services.get(4));
                    }
                    if (form.getCbxStyling().isSelected()) {
                        selectedServices.add(services.get(5));
                    }
                    if (selectedServices.size() == 0) {
                        throw new Exception("Choose at least one service.");
                    }
                    valid = true;
                    constructAppointment(dateTime, dog, salon, selectedServices);
                    calculateDuarionAndFee();
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(form, e.getMessage());
                    appointment = null;
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(form, e.getMessage());
                    appointment = null;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(form, ex.getMessage());
                    appointment = null;
                }
                return valid;
            }

            private void constructAppointment(Date dateTime, Dog dog, Salon salon, List<Service> services) {
                appointment = new Appointment();
                appointment.setDateTime(dateTime.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime());
                appointment.setDog(dog);
                appointment.setSalon(salon);
                appointment.setTotalDuration(0);
                appointment.setTotalFee(new BigDecimal(0));
                appointment.setServices(services);
            }

            private void addAppointment(Appointment appointment) {
                try {
                    id = Communication.getInstance().saveAppointment(appointment);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void calculateDuarionAndFee() {
                int duration = 0;
                BigDecimal fee = new BigDecimal(0);
                for(Service s: appointment.getServices()){
                    duration+=s.getDuration();
                    fee = fee.add(s.getFee());
                }
                System.out.println("Duration: " + duration);
                System.out.println("Fee: " + fee);
                appointment.setTotalDuration(duration);
                appointment.setTotalFee(fee);
            }
        });
    }

    public void openForm() {
        form.setVisible(true);
        prepareView();
    }

    private void prepareView() {
        fillComboDogs();
        fillComboSalons();
        getServices();
    }

    private void fillComboDogs() {
        try {
            form.getCmbDog().removeAllItems();
            form.getCmbDog().setEnabled(false);
            form.getCmbDog().addItem(null);
            dogs = Communication.getInstance().getAllDogs();
            for (Dog d : dogs) {
                form.getCmbDog().addItem(d);
            }
            form.getCmbDog().setSelectedItem(null);
            form.getCmbDog().setEnabled(true);

        } catch (Exception ex) {
            System.out.println("Exception while getting dogs. " + ex.getMessage());
        }
    }

    private void fillComboSalons() {
        try {
            form.getCmbSalon().removeAllItems();
            form.getCmbSalon().setEnabled(false);
            form.getCmbSalon().addItem(null);
            salons = Communication.getInstance().getAllSalons();
            for (Salon s : salons) {
                form.getCmbSalon().addItem(s);
            }
            form.getCmbSalon().setSelectedItem(null);
            form.getCmbSalon().setEnabled(true);

        } catch (Exception ex) {
            System.out.println("Exception while getting salons. " + ex.getMessage());
        }
    }

    private void getServices() {
        try {
            services = Communication.getInstance().getAllServices();
        } catch (Exception ex) {
            System.out.println("Exception while getting esrvices. " + ex.getMessage());

        }
    }
}
