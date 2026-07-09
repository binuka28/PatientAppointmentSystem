

package patientappointmentsystem;
import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class ReportFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReportFrame.class.getName());

   
    public ReportFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReportP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnReportD = new javax.swing.JButton();
        btnReportA = new javax.swing.JButton();
        txtBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReportP.setText("Generate Patient Report ");
        btnReportP.addActionListener(this::btnReportPActionPerformed);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Reports");

        btnReportD.setText("Generate Doctor Report");
        btnReportD.addActionListener(this::btnReportDActionPerformed);

        btnReportA.setText("Generate Appointment Report");
        btnReportA.addActionListener(this::btnReportAActionPerformed);

        txtBack.setText("Back");
        txtBack.addActionListener(this::txtBackActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReportA, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportD, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportP, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtBack)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnReportP, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnReportD, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReportA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBack)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportPActionPerformed
        try {

    Connection con = DBConnection.getConnection();

    JasperReport report = (JasperReport) JRLoader.loadObject(
            getClass().getResource("/reports/PatientReport.jasper"));

    JasperPrint print = JasperFillManager.fillReport(report, null, con);

    JasperViewer.viewReport(print, false);

} catch (Exception e) {

    JOptionPane.showMessageDialog(this, e.getMessage());

}
    }//GEN-LAST:event_btnReportPActionPerformed

    private void btnReportDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportDActionPerformed
        try {

    Connection con = DBConnection.getConnection();

    JasperReport report = (JasperReport) JRLoader.loadObject(
            getClass().getResource("/reports/DoctorReport.jasper"));

    JasperPrint print = JasperFillManager.fillReport(report, null, con);

    JasperViewer.viewReport(print, false);

} catch (Exception e) {

    JOptionPane.showMessageDialog(this, e.getMessage());

}
    }//GEN-LAST:event_btnReportDActionPerformed

    private void btnReportAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportAActionPerformed
        try {

    Connection con = DBConnection.getConnection();

    JasperReport report = (JasperReport) JRLoader.loadObject(
            getClass().getResource("/reports/AppointmentReport.jasper"));

    JasperPrint print = JasperFillManager.fillReport(report, null, con);

    JasperViewer.viewReport(print, false);

} catch (Exception e) {

    JOptionPane.showMessageDialog(this, e.getMessage());

}
    }//GEN-LAST:event_btnReportAActionPerformed

    private void txtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBackActionPerformed
        DashboardFrame Back = new DashboardFrame();
        Back.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_txtBackActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ReportFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportA;
    private javax.swing.JButton btnReportD;
    private javax.swing.JButton btnReportP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton txtBack;
    // End of variables declaration//GEN-END:variables
}
