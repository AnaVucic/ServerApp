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
import java.awt.event.ActionListener;
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
        form.btnAddAppointmentActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openAddAppointmentForm();
            }
        });

        form.cmbSalonPropertyChangeListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                Salon selectedSalon = (Salon) form.getCmbSalon().getSelectedItem();
                if (selectedSalon != null) {
                    fillTableAppointments(selectedSalon);
                }
            }

        }
        );

        form.btnViewAllActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillTableAppointments(null);
            }
        }
        );

        form.btnEditAppointmentActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = form.getTblAppointments().getSelectedRow();
                if (row != -1) {
                    Long id = (Long) form.getTblAppointments().getValueAt(row, 0);
                    MainCoordinator.getInstance().openEditAppointmentForm(id);
                } else {
                    JOptionPane.showMessageDialog(form, "You must select an appointment to edit.","Select an appointment",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public void openForm() {
        form.setVisible(true);
        prepareView();

    }

    private void prepareView() {
        fillTableAppointments(null);
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

    private void fillTableAppointments(Salon filter) {
        try {
            appointments = Communication.getInstance().getAllAppointments();
            AppointmentTableModel model = new AppointmentTableModel(appointments);
            form.getTblAppointments().setModel(model);
            TableRowSorter sorter = new TableRowSorter(model);
            form.getTblAppointments().setRowSorter(sorter);
            if (filter != null) {
                sorter.setRowFilter(new RowFilter() {
                    @Override
                    public boolean include(RowFilter.Entry entry) {
                        return entry.getStringValue(5).contains(filter.toString());
                    }
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
