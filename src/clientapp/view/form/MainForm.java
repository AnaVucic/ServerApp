/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clientapp.view.form;

import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 *
 * @author Lenovo
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCurrentUser = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mniAppointments = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mniPersons = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mniDogs = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mniSalons = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mniPrices = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        mniSoftware = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Dog Grooming Salon Management");

        jLabel2.setText("Currently loggen in as:");

        lblCurrentUser.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblCurrentUser.setText("Current User");

        btnLogOut.setText("Log out");

        jMenu2.setText("Appointments");

        mniAppointments.setText("View Appointments");
        mniAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAppointmentsActionPerformed(evt);
            }
        });
        jMenu2.add(mniAppointments);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Owners");

        mniPersons.setText("View Owners");
        mniPersons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPersonsActionPerformed(evt);
            }
        });
        jMenu3.add(mniPersons);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Dogs");

        mniDogs.setText("View Dogs");
        mniDogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDogsActionPerformed(evt);
            }
        });
        jMenu4.add(mniDogs);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Salons");

        mniSalons.setText("View Salons");
        mniSalons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalonsActionPerformed(evt);
            }
        });
        jMenu5.add(mniSalons);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Price Rates Information");

        mniPrices.setText("Prices");
        jMenu6.add(mniPrices);

        jMenuBar1.add(jMenu6);

        jMenu7.setText(" About");

        mniSoftware.setText("Software");
        jMenu7.add(mniSoftware);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCurrentUser)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogOut))
                        .addComponent(jLabel1)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCurrentUser)
                    .addComponent(btnLogOut))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAppointmentsActionPerformed
        AppointmentsForm af = new AppointmentsForm();
        af.setVisible(true);
    }//GEN-LAST:event_mniAppointmentsActionPerformed

    private void mniPersonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPersonsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniPersonsActionPerformed

    private void mniDogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDogsActionPerformed
        DogsForm df = new DogsForm();
        df.setVisible(true);
    }//GEN-LAST:event_mniDogsActionPerformed

    private void mniSalonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSalonsActionPerformed
        SalonForm sf = new SalonForm();
        sf.setVisible(true);
    }//GEN-LAST:event_mniSalonsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JLabel lblCurrentUser;
    private javax.swing.JMenuItem mniAppointments;
    private javax.swing.JMenuItem mniDogs;
    private javax.swing.JMenuItem mniPersons;
    private javax.swing.JMenuItem mniPrices;
    private javax.swing.JMenuItem mniSalons;
    private javax.swing.JMenuItem mniSoftware;
    // End of variables declaration//GEN-END:variables


    public JButton getBtnLogOut() {
        return btnLogOut;
    }

    public void setBtnLogOut(JButton btnLogOut) {
        this.btnLogOut = btnLogOut;
    }

    public JLabel getLblCurrentUser() {
        return lblCurrentUser;
    }

    public void setLblCurrentUser(JLabel lblCurrentUser) {
        this.lblCurrentUser = lblCurrentUser;
    }
    
    //|
    //|-----------------------------------------------------
    //|
    
    public void mniAppointmentsActionListener (ActionListener actionListener){
        mniAppointments.addActionListener(actionListener);
    }
    
    public void mniPersonsActionListener (ActionListener actionListener){
        mniPersons.addActionListener(actionListener);
    }
    
    public void mniDogsActionListener (ActionListener actionListener){
        mniDogs.addActionListener(actionListener);
    }
    
    public void mniSalonsActionListener (ActionListener actionListener){
        mniSalons.addActionListener(actionListener);
    }
    
    public void mniPricesActionListener (ActionListener actionListener){
        mniPrices.addActionListener(actionListener);
    }
    
    public void mniSoftwareActionListener (ActionListener actionListener) {
        mniSoftware.addActionListener(actionListener);
    }
    
    public void btnLogOutActionListener (ActionListener actionListener) {
        btnLogOut.addActionListener(actionListener);
    }
    
}
