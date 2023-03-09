package clientapp.view.form;

import commonlib.domain.Dog;
import commonlib.domain.Salon;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class AddAppointmentForm extends javax.swing.JFrame {

    public AddAppointmentForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbDog = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbSalon = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxBath = new javax.swing.JCheckBox();
        cbxTrimming = new javax.swing.JCheckBox();
        cbxNail = new javax.swing.JCheckBox();
        cbxEar = new javax.swing.JCheckBox();
        cbxTeeth = new javax.swing.JCheckBox();
        cbxStyling = new javax.swing.JCheckBox();
        btnAdd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Date");

        jLabel2.setText("Time");

        jLabel3.setText("Dog");

        jLabel4.setText("Salon");

        jLabel5.setText("Services");

        cbxBath.setText("Bath");

        cbxTrimming.setText("Trimming");

        cbxNail.setText("Nail care");

        cbxEar.setText("Ear care");

        cbxTeeth.setText("Teeth care");

        cbxStyling.setText("Styling");

        btnAdd.setText("Add Appointment");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("New Appointment Parameters");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel4)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDate)
                                .addComponent(txtTime)
                                .addComponent(cmbDog, 0, 117, Short.MAX_VALUE)
                                .addComponent(cmbSalon, 0, 117, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxTeeth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxEar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxNail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTrimming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxBath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxStyling, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel5))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxBath)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addComponent(cbxTrimming)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxNail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTeeth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxStyling)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JCheckBox cbxBath;
    private javax.swing.JCheckBox cbxEar;
    private javax.swing.JCheckBox cbxNail;
    private javax.swing.JCheckBox cbxStyling;
    private javax.swing.JCheckBox cbxTeeth;
    private javax.swing.JCheckBox cbxTrimming;
    private javax.swing.JComboBox<Dog> cmbDog;
    private javax.swing.JComboBox<Salon> cmbSalon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JCheckBox getCbxBath() {
        return cbxBath;
    }

    public void setCbxBath(JCheckBox cbxBath) {
        this.cbxBath = cbxBath;
    }

    public JCheckBox getCbxEar() {
        return cbxEar;
    }

    public void setCbxEar(JCheckBox cbxEar) {
        this.cbxEar = cbxEar;
    }

    public JCheckBox getCbxNail() {
        return cbxNail;
    }

    public void setCbxNail(JCheckBox cbxNail) {
        this.cbxNail = cbxNail;
    }

    public JCheckBox getCbxStyling() {
        return cbxStyling;
    }

    public void setCbxStyling(JCheckBox cbxStyling) {
        this.cbxStyling = cbxStyling;
    }

    public JCheckBox getCbxTeeth() {
        return cbxTeeth;
    }

    public void setCbxTeeth(JCheckBox cbxTeeth) {
        this.cbxTeeth = cbxTeeth;
    }

    public JCheckBox getCbxTrimming() {
        return cbxTrimming;
    }

    public void setCbxTrimming(JCheckBox cbxTrimming) {
        this.cbxTrimming = cbxTrimming;
    }

    public JComboBox<Dog> getCmbDog() {
        return cmbDog;
    }

    public void setCmbDog(JComboBox<Dog> cmbDog) {
        this.cmbDog = cmbDog;
    }

    public JComboBox<Salon> getCmbSalon() {
        return cmbSalon;
    }

    public void setCmbSalon(JComboBox<Salon> cmbSalon) {
        this.cmbSalon = cmbSalon;
    }

    public JTextField getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(JTextField txtDate) {
        this.txtDate = txtDate;
    }

    public JTextField getTxtTime() {
        return txtTime;
    }

    public void setTxtTime(JTextField txtTime) {
        this.txtTime = txtTime;
    }
    
    

    // ACTION LISTENERS
    
    public void btnAddActionListener (ActionListener actionListener){
        btnAdd.addActionListener(actionListener);
    }


}


