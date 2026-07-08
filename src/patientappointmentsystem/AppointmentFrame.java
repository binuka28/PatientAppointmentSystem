
package patientappointmentsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AppointmentFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AppointmentFrame.class.getName());

    public AppointmentFrame() {
     initComponents();

    loadPatients();
    loadDoctors();
    loadAppointmentTable();
    
}
    public void loadPatients() {

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM patient";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        cmbPatient.removeAllItems();

        while (rs.next()) {

            cmbPatient.addItem(rs.getString("name"));

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e.getMessage());

    }

}
    public void loadDoctors() {

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM doctor";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        cmbDoctor.removeAllItems();

        while (rs.next()) {

            cmbDoctor.addItem(rs.getString("name"));

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e.getMessage());

    }

}
    public void loadAppointmentTable() {

    try {

        Connection con = DBConnection.getConnection();

        String sql =
        "SELECT appointment.appointment_id,patient.name,doctor.name,appointment.appointment_date,appointment.appointment_time,appointment.status "
      + "FROM appointment "
      + "JOIN patient ON appointment.patient_id=patient.patient_id "
      + "JOIN doctor ON appointment.doctor_id=doctor.doctor_id";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        DefaultTableModel model =
        (DefaultTableModel) tblAppointment.getModel();

        model.setRowCount(0);

        while(rs.next()){

            model.addRow(new Object[]{

                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDate(4),
                rs.getTime(5),
                rs.getString(6)

            });

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this,e);

    }

}
    public void clearFields(){

    txtDate.setText("");
    txtTime.setText("");
    txtStatus.setText("");

    cmbPatient.setSelectedIndex(0);
    cmbDoctor.setSelectedIndex(0);

}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbDoctor = new javax.swing.JComboBox<>();
        cmbPatient = new javax.swing.JComboBox<>();
        txtDate = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Patient");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doctor");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Appointment Date");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Appointment Time");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Status");

        cmbDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbPatient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        txtBack.setText("Back");
        txtBack.addActionListener(this::txtBackActionPerformed);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnSave.setText("Save");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Appointment ID", "Patient", "Doctor", "Date", "Time", "Status"
            }
        ));
        tblAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAppointmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAppointment);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText(" APPOINTMENT DETAILS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClear)
                                .addGap(18, 18, 18)
                                .addComponent(txtBack))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPatient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDate)
                            .addComponent(txtTime, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnSave)
                    .addComponent(txtBack))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {

    int row = tblAppointment.getSelectedRow();

    if(row==-1){

        JOptionPane.showMessageDialog(this,"Select Appointment");

        return;

    }

    int id =
    Integer.parseInt(tblAppointment.getValueAt(row,0).toString());

    Connection con = DBConnection.getConnection();

    String sql =
    "DELETE FROM appointment WHERE appointment_id=?";

    PreparedStatement pst = con.prepareStatement(sql);

    pst.setInt(1,id);

    pst.executeUpdate();

    JOptionPane.showMessageDialog(this,"Deleted Successfully");

    loadAppointmentTable();

    clearFields();

} catch(Exception e){

    JOptionPane.showMessageDialog(this,e.getMessage());

}
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBackActionPerformed
        DashboardFrame Back = new DashboardFrame();
        Back.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_txtBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    try {

    int row = tblAppointment.getSelectedRow();

    if(row==-1){

        JOptionPane.showMessageDialog(this,"Select Appointment");

        return;

    }

    int id =
    Integer.parseInt(tblAppointment.getValueAt(row,0).toString());

    Connection con = DBConnection.getConnection();

    String sql =
    "UPDATE appointment SET patient_id=(SELECT patient_id FROM patient WHERE name=?),doctor_id=(SELECT doctor_id FROM doctor WHERE name=?),appointment_date=?,appointment_time=?,status=? WHERE appointment_id=?";

    PreparedStatement pst = con.prepareStatement(sql);

    pst.setString(1,cmbPatient.getSelectedItem().toString());
    pst.setString(2,cmbDoctor.getSelectedItem().toString());
    pst.setString(3,txtDate.getText());
    pst.setString(4,txtTime.getText());
    pst.setString(5,txtStatus.getText());
    pst.setInt(6,id);

    pst.executeUpdate();

    JOptionPane.showMessageDialog(this,"Updated Successfully");

    loadAppointmentTable();

    clearFields();

} catch(Exception e){

    JOptionPane.showMessageDialog(this,e.getMessage());

}

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       try {

    Connection con = DBConnection.getConnection();

    String sql = "INSERT INTO appointment(patient_id,doctor_id,appointment_date,appointment_time,status) VALUES((SELECT patient_id FROM patient WHERE name=?),(SELECT doctor_id FROM doctor WHERE name=?),?,?,?)";

    PreparedStatement pst = con.prepareStatement(sql);

    pst.setString(1, cmbPatient.getSelectedItem().toString());
    pst.setString(2, cmbDoctor.getSelectedItem().toString());
    pst.setString(3, txtDate.getText());
    pst.setString(4, txtTime.getText());
    pst.setString(5, txtStatus.getText());

    pst.executeUpdate();

    JOptionPane.showMessageDialog(this, "Appointment Saved");

    loadAppointmentTable();
    clearFields();

} catch (Exception e) {

    JOptionPane.showMessageDialog(this, e.getMessage());

}
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAppointmentMouseClicked
      
        int row = tblAppointment.getSelectedRow();

cmbPatient.setSelectedItem(tblAppointment.getValueAt(row,1).toString());

cmbDoctor.setSelectedItem(tblAppointment.getValueAt(row,2).toString());

txtDate.setText(tblAppointment.getValueAt(row,3).toString());

txtTime.setText(tblAppointment.getValueAt(row,4).toString());

txtStatus.setText(tblAppointment.getValueAt(row,5).toString());
    }//GEN-LAST:event_tblAppointmentMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AppointmentFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbDoctor;
    private javax.swing.JComboBox<String> cmbPatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAppointment;
    private javax.swing.JButton txtBack;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
