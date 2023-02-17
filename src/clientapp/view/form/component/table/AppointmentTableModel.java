/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientapp.view.form.component.table;

import commonlib.domain.Appointment;
import commonlib.domain.Salon;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class AppointmentTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "Date", "Time", "Dog",
        "Owner", "Salon", "Total fee", "Total duration"};

    private final List<Appointment> appointments;

    public AppointmentTableModel(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public int getRowCount() {
        if (appointments == null) {
            return 0;
        }
        return appointments.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Appointment a = appointments.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getAppointmentID();
            case 1:
                return a.getDateTime().toLocalDate();
            case 2:
                return a.getDateTime().toLocalTime();
            case 3:
                return a.getDog().getName();
            case 4:
                return a.getDog().getPerson().getFirstname() + " " + a.getDog().getPerson().getLastname();
            case 5:
                return a.getSalon();
            case 6:
                return a.getTotalFee();
            case 7:
                return a.getTotalDuration();   
            default:
                return "n/a";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Long.class;
            case 1:
                return LocalDate.class;
            case 2:
                return LocalTime.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Salon.class;
            case 6:
                return BigDecimal.class;
            case 7:
                return int.class;
            default:
                return String.class;
        }
    }
    
    public Appointment getAppointment (int rowIndex) {
        return appointments.get(rowIndex);
    }

}
