/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientapp.view.form.component.table;

import commonlib.domain.Service;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ANA
 */
public class ServiceTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "Name", "Fee", "Duration", "Included"};
    private final List<Service> services;
    private final List<Service> included;

    public ServiceTableModel(List<Service> services, List<Service> included) {
        this.services = services;
        this.included = included;
    }

    @Override
    public int getRowCount() {
        if (services == null) {
            return 0;
        }
        return services.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Service s = services.get(rowIndex);
        Boolean x = included.contains(s);
        return switch (columnIndex) {
            case 0 ->
                s.getServiceID();
            case 1 ->
                s.getName();
            case 2 ->
                s.getFee();
            case 3 ->
                s.getDuration();
            case 4 ->
                x;
            default ->
                "n/a";
        };
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
        return switch (columnIndex) {
            case 0 ->
                Long.class;
            case 1 ->
                String.class;
            case 2 ->
                BigDecimal.class;
            case 3 ->
                int.class;
            case 4 ->
                Boolean.class;
            default ->
                String.class;
        };
    }

    @Override
    public void fireTableCellUpdated(int row, int column) {
        super.fireTableCellUpdated(row, column);
    }
    
    public Service getService(int rowIndex) {
        return services.get(rowIndex);
    }

}
