package serverapp.view.form;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MainForm extends javax.swing.JFrame {

   
    public MainForm() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        lblServerStatus = new javax.swing.JLabel();
        lblNumberOnlineClients = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnStart.setText("Start");

        btnStop.setText("Stop");

        lblServerStatus.setText("Server Status");

        lblNumberOnlineClients.setText("Number of clients");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnStop)
                    .addComponent(btnStart))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(lblServerStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(lblNumberOnlineClients)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblServerStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNumberOnlineClients)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(btnStart)
                .addGap(10, 10, 10)
                .addComponent(btnStop)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel lblNumberOnlineClients;
    private javax.swing.JLabel lblServerStatus;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnStart() {
        return btnStart;
    }

    public void setBtnStart(JButton btnStart) {
        this.btnStart = btnStart;
    }

    public JButton getBtnStop() {
        return btnStop;
    }

    public void setBtnStop(JButton btnStop) {
        this.btnStop = btnStop;
    }

    
    //**** ACTION LISTENERS ****\\
    
    public void btnStartActionListener(ActionListener actionListener) {
        btnStart.addActionListener(actionListener);
    }

    public void btnStopActionListener(ActionListener actionListener) {
        btnStop.addActionListener(actionListener);
    }
    
    
    
    
}
