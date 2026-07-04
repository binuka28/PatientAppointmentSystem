
package patientappointmentsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DoctorFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DoctorFrame.class.getName());

    public DoctorFrame() {
        initComponents();
    }
    public void loadDoctorTable() {
       

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM doctor";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tblDoctor.getModel();

        model.setRowCount(0);

        while (rs.next()) {

            model.addRow(new Object[]{
                rs.getInt("doctor_id"),
                rs.getString("name"),
                rs.getString("specialization"),
                rs.getDouble("channel_fee")
            });

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e.getMessage());

    }

}
    private void tblDoctorMouseClicked(java.awt.event.MouseEvent evt) {

    int row = tblDoctor.getSelectedRow();

    txtDoctorName.setText(tblDoctor.getValueAt(row, 1).toString());
    txtSpecialization.setText(tblDoctor.getValueAt(row, 2).toString());
    txtChannelFee.setText(tblDoctor.getValueAt(row, 3).toString());

}


    public void clearFields() {

    txtDoctorName.setText("");
    txtSpecialization.setText("");
    txtChannelFee.setText("");

}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoctor = new javax.swing.JTable();
        txtBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDoctorName = new javax.swing.JTextField();
        txtSpecialization = new javax.swing.JTextField();
        txtChannelFee = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        tblDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Doctor ID", "Doctor Name ", "Specialization", "Channel Fee"
            }
        ));
        jScrollPane1.setViewportView(tblDoctor);

        txtBack.setText("Back");
        txtBack.addActionListener(this::txtBackActionPerformed);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Doctor Detail");
        jLabel1.setToolTipText("");

        jLabel2.setText("Specialization");

        txtDoctorName.addActionListener(this::txtDoctorNameActionPerformed);

        txtSpecialization.addActionListener(this::txtSpecializationActionPerformed);

        txtChannelFee.addActionListener(this::txtChannelFeeActionPerformed);

        btnSave.setText("Save");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        jLabel4.setText("Channel Fee");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Doctor Name");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDoctorName)
                                        .addComponent(txtSpecialization)
                                        .addComponent(txtChannelFee, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClear)))
                        .addGap(18, 18, 18)
                        .addComponent(txtBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtChannelFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnSave)
                    .addComponent(txtBack))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {

        int row = tblDoctor.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a doctor.");
            return;
        }

        int id = Integer.parseInt(tblDoctor.getValueAt(row, 0).toString());

        Connection con = DBConnection.getConnection();

        String sql = "UPDATE doctor SET name=?, specialization=?, channel_fee=? WHERE doctor_id=?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, txtDoctorName.getText());
        pst.setString(2, txtSpecialization.getText());
        pst.setDouble(3, Double.parseDouble(txtChannelFee.getText()));
        pst.setInt(4, id);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Doctor Updated Successfully");

        loadDoctorTable();
        clearFields();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e.getMessage());

    }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    try {

        int row = tblDoctor.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a doctor.");
            return;
        }

        int id = Integer.parseInt(tblDoctor.getValueAt(row, 0).toString());

        Connection con = DBConnection.getConnection();

        String sql = "DELETE FROM doctor WHERE doctor_id=?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, id);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Doctor Deleted Successfully");

        loadDoctorTable();
        clearFields();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e.getMessage());

    }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        txtDoctorName.setText("");
        txtSpecialization.setText("");
        txtChannelFee.setText("");

    }//GEN-LAST:event_btnClearActionPerformed

    private void txtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBackActionPerformed
        DashboardFrame Back = new DashboardFrame();
        Back.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_txtBackActionPerformed

    private void txtSpecializationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpecializationActionPerformed

    }//GEN-LAST:event_txtSpecializationActionPerformed

    private void txtChannelFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChannelFeeActionPerformed

    }//GEN-LAST:event_txtChannelFeeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    try {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO doctor(name,specialization,channel_fee) VALUES(?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, txtDoctorName.getText());
        pst.setString(2, txtSpecialization.getText());
        pst.setDouble(3, Double.parseDouble(txtChannelFee.getText()));

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Doctor Saved Successfully");

        loadDoctorTable();
        clearFields();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e.getMessage());

    }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtDoctorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorNameActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new DoctorFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDoctor;
    private javax.swing.JButton txtBack;
    private javax.swing.JTextField txtChannelFee;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtSpecialization;
    // End of variables declaration//GEN-END:variables
}
