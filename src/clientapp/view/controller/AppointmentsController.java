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
import clientapp.view.coordinator.MainCoordinator;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Lenovo
 */
public class AppointmentsController {

    private final AppointmentsForm form;
    private List<Appointment> appointments;
    private List<Salon> salons;

    public AppointmentsController(AppointmentsForm appointmentsForm) {
        this.form = appointmentsForm;
        addActionListeners();
    }

    private void addActionListeners() {
        form.btnAddAppointmentActionListener((ActionEvent e) -> {
            MainCoordinator.getInstance().openAddAppointmentForm(this);
        });

        form.cmbSalonPropertyChangeListener((ActionEvent e) -> {
            Salon selectedSalon = (Salon) form.getCmbSalon().getSelectedItem();
            if (selectedSalon != null) {
                fillTableAppointments(selectedSalon, null, null);
            }
        });

        form.btnViewAllActionListener((ActionEvent e) -> {
            fillTableAppointments(null, null, null);
        });

        form.btnEditAppointmentActionListener((ActionEvent e) -> {
            int row = form.getTblAppointments().getSelectedRow();
            if (row != -1) {
                Long id = (Long) form.getTblAppointments().getValueAt(row, 0);
                MainCoordinator.getInstance().openEditAppointmentForm(id, this);
            } else {
                JOptionPane.showMessageDialog(form, "You must select an appointment to edit.", "Select an appointment", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        form.btnDateDisplayActionListener((ActionEvent e) -> {  // OVDE!!!!!!!!!!!!
            try {
                Salon selectedSalon = (Salon) form.getCmbSalon().getSelectedItem();

                String fromString = form.getTxtDateFrom().getText();
                String toString = form.getTxtDateTo().getText();
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

                LocalDate fromDate = LocalDate.parse(fromString, formatter);
                LocalDate toDate = LocalDate.parse(toString, formatter);
                
                if (selectedSalon != null) {
                    fillTableAppointments(selectedSalon, fromDate, toDate);
                } else {
                    fillTableAppointments(null, fromDate, toDate);
                }
               
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(form, "Unable to parse date.\n" + ex.getMessage());
            }
        });

        form.btnDeleteAppointmentActionListener((ActionEvent e) -> {
            int row = form.getTblAppointments().getSelectedRow();
            if (row != -1) {
                AppointmentTableModel atm = (AppointmentTableModel) (form.getTblAppointments().getModel());
                Appointment a = atm.getAppointment(row);
                try {
                    Communication.getInstance().removeAppointment(a);
                } catch (Exception ex) {
                    Logger.getLogger(AppointmentsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(form, "System has successfully deleted appointment with id " + a.getAppointmentID());
                fillTableAppointments(null, null, null);
            } else {
                JOptionPane.showMessageDialog(form, "You must select an appointment to delete.", "Select an appointment", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void openForm() {
        form.setVisible(true);
        prepareView();

    }

    private void prepareView() {
        fillTableAppointments(null, null, null);
        fillComboSalon();
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
            form.getCmbSalon().setSelectedItem(null);
            form.getCmbSalon().setEnabled(true);

        } catch (Exception ex) {
            Logger.getLogger(AppointmentsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillTableAppointments(Salon filter, LocalDate from, LocalDate to) {
        try {
            appointments = Communication.getInstance().getAllAppointments();
            AppointmentTableModel model = new AppointmentTableModel(appointments);
            form.getTblAppointments().setModel(model);
            TableRowSorter sorter = new TableRowSorter(model);
            form.getTblAppointments().setRowSorter(sorter);
            
            
            // FILTERI TREBA DA SE IMPL PREKO UPITA NAD BAZOM
            
            if (filter != null) {
                sorter.setRowFilter(new RowFilter() {
                    @Override
                    public boolean include(RowFilter.Entry entry) {
                        return entry.getStringValue(5).contains(filter.toString());
                    }
                });
            }
            if (from != null && to != null) {
                sorter.setRowFilter(new RowFilter() {
                    @Override
                    public boolean include(RowFilter.Entry entry) {
                        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
                        LocalDate date = LocalDate.parse(entry.getStringValue(1), formatter);
                        return date.isAfter(from.minusDays(1l)) && date.isBefore(to.plusDays(1l));
                    }
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
