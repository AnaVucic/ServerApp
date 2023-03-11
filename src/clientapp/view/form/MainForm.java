package clientapp.view.form;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainForm extends javax.swing.JFrame {
    
    public MainForm() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
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
        jMenu2.add(mniAppointments);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Owners");

        mniPersons.setText("View Owners");
        jMenu3.add(mniPersons);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Dogs");

        mniDogs.setText("View Dogs");
        jMenu4.add(mniDogs);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Salons");

        mniSalons.setText("View Salons");
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
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCurrentUser, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)))
                .addContainerGap(228, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblCurrentUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
    
    // ACTION LISTENERS
    
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
