package clientapp.view.form;

import commonlib.domain.Salon;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class AppointmentsForm extends javax.swing.JFrame {

    public AppointmentsForm() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tblAppointments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbSalon = new javax.swing.JComboBox<>();
        btnEditAppointment = new javax.swing.JButton();
        btnAddAppointment = new javax.swing.JButton();
        btnDateDisplay = new javax.swing.JButton();
        btnViewAll = new javax.swing.JButton();
        txtDateFrom = new javax.swing.JTextField();
        txtDateTo = new javax.swing.JTextField();
        btnDeleteAppointment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dog Grooming Appointments");

        jLabel1.setText("Display appointments in range:");

        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAppointments.setToolTipText("");
        tblAppointments.setPreferredSize(new java.awt.Dimension(1000, 1000));
        jScrollPane1.setViewportView(tblAppointments);

        jLabel2.setText("From");

        jLabel3.setText("To");

        jLabel4.setText("Choose a salon");

        btnEditAppointment.setText("Edit appointment");

        btnAddAppointment.setText("Add new appointment");

        btnDateDisplay.setText("Display");

        btnViewAll.setText("View All");

        btnDeleteAppointment.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnDeleteAppointment.setForeground(new java.awt.Color(204, 0, 0));
        btnDeleteAppointment.setText("Delete Appointment");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnDeleteAppointment)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddAppointment))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbSalon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(472, 472, 472)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(191, 191, 191)
                                    .addComponent(btnDateDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDateFrom)
                                            .addComponent(txtDateTo)))))))
                    .addComponent(btnEditAppointment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(btnDateDisplay)
                        .addComponent(txtDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnViewAll))
                .addGap(89, 89, 89)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteAppointment)
                    .addComponent(btnAddAppointment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditAppointment)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAppointment;
    private javax.swing.JButton btnDateDisplay;
    private javax.swing.JButton btnDeleteAppointment;
    private javax.swing.JButton btnEditAppointment;
    private javax.swing.JButton btnViewAll;
    private javax.swing.JComboBox<Salon> cmbSalon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAppointments;
    private javax.swing.JTextField txtDateFrom;
    private javax.swing.JTextField txtDateTo;
    // End of variables declaration//GEN-END:variables

    public JComboBox<Salon> getCmbSalon() {
        return cmbSalon;
    }

    public void setCmbSalon(JComboBox<Salon> cmbSalon) {
        this.cmbSalon = cmbSalon;
    }

    public JTable getTblAppointments() {
        return tblAppointments;
    }

    public void setTblAppointments(JTable tblAppointments) {
        this.tblAppointments = tblAppointments;
    }

    public JTextField getTxtDateFrom() {
        return txtDateFrom;
    }

    public void setTxtDateFrom(JTextField txtDateFrom) {
        this.txtDateFrom = txtDateFrom;
    }

    public JTextField getTxtDateTo() {
        return txtDateTo;
    }

    public void setTxtDateTo(JTextField txtDateTo) {
        this.txtDateTo = txtDateTo;
    }

    public JButton getBtnEditAppointment() {
        return btnEditAppointment;
    }

    public void setBtnEditAppointment(JButton btnEditAppointment) {
        this.btnEditAppointment = btnEditAppointment;
    }

    public JButton getBtnDeleteAppointment() {
        return btnDeleteAppointment;
    }

    public void setBtnDeleteAppointment(JButton btnDeleteAppointment) {
        this.btnDeleteAppointment = btnDeleteAppointment;
    }
    
    

    // ACTION LISTENERS
    public void btnViewAllActionListener(ActionListener actionListener) {
        btnViewAll.addActionListener(actionListener);
    }

    public void btnDateDisplayActionListener(ActionListener actionListener) {
        btnDateDisplay.addActionListener(actionListener);
    }

    public void btnAddAppointmentActionListener(ActionListener actionListener) {
        btnAddAppointment.addActionListener(actionListener);
    }
    
    public void btnEditAppointmentActionListener(ActionListener actionListener) {
        btnEditAppointment.addActionListener(actionListener);
    }

    public void cmbSalonPropertyChangeListener(ActionListener actionListener) {
        cmbSalon.addActionListener(actionListener);
    }
    
    public void btnDeleteAppointmentActionListener(ActionListener actionListener) {
        btnDeleteAppointment.addActionListener(actionListener);
    }
}
