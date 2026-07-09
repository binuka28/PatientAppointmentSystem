
package patientappointmentsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DashboardFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DashboardFrame.class.getName());

    public DashboardFrame() {
        initComponents();
        
    

    loadDashboardCounts();
    loadRecentAppointments();
}
    public void loadDashboardCounts() {

    try {

        Connection con = DBConnection.getConnection();

        // Total Patients
        PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM patient");
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            lblPatients.setText(rs.getString(1));
        }

        // Total Doctors
        pst = con.prepareStatement("SELECT COUNT(*) FROM doctor");
        rs = pst.executeQuery();

        if (rs.next()) {
            lblDoctor.setText(rs.getString(1));
        }

        // Total Appointments
        pst = con.prepareStatement("SELECT COUNT(*) FROM appointment");
        rs = pst.executeQuery();

        if (rs.next()) {
            lblAppointments.setText(rs.getString(1));
            
        
        }
        pst = con.prepareStatement(
    "SELECT IFNULL(SUM(d.channel_fee),0) " +
    "FROM appointment a " +
    "JOIN doctor d ON a.doctor_id = d.doctor_id");

rs = pst.executeQuery();

if (rs.next()) {
    lblIncome.setText("Rs. " + rs.getString(1));
}

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e.getMessage());

    }

}
    public void loadRecentAppointments() {

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT p.name, d.name, d.specialization, "
                + "a.appointment_time, a.status "
                + "FROM appointment a "
                + "INNER JOIN patient p ON a.patient_id = p.patient_id "
                + "INNER JOIN doctor d ON a.doctor_id = d.doctor_id";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tblDashboard.getModel();

        model.setRowCount(0);

        while (rs.next()) {

            model.addRow(new Object[]{

                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getTime(4),
                rs.getString(5)

            });

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e.getMessage());

    }

}
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPatient = new javax.swing.JButton();
        btnDoctor = new javax.swing.JButton();
        btnAppointment = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        panelPatients = new javax.swing.JPanel();
        lbl2 = new javax.swing.JLabel();
        lblDoctor = new javax.swing.JLabel();
        panelPatients1 = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lblPatients = new javax.swing.JLabel();
        panelPatients2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblIncome = new javax.swing.JLabel();
        panelPatients3 = new javax.swing.JPanel();
        lbl3 = new javax.swing.JLabel();
        lblAppointments = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDashboard = new javax.swing.JTable();
        btnNewBooking = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnGenerateReport = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(768, 1366));

        menuPanel.setBackground(new java.awt.Color(159, 189, 209));
        menuPanel.setForeground(new java.awt.Color(102, 255, 255));
        menuPanel.setPreferredSize(new java.awt.Dimension(220, 768));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Medical Center System");
        jLabel1.setToolTipText("");

        btnPatient.setText("Patient");
        btnPatient.addActionListener(this::btnPatientActionPerformed);

        btnDoctor.setText("Doctor");
        btnDoctor.addActionListener(this::btnDoctorActionPerformed);

        btnAppointment.setText("Appointment");
        btnAppointment.addActionListener(this::btnAppointmentActionPerformed);

        btnReport.setText("Report");
        btnReport.addActionListener(this::btnReportActionPerformed);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 301, Short.MAX_VALUE))
        );

        panelPatients.setBackground(new java.awt.Color(220, 220, 220));
        panelPatients.setPreferredSize(new java.awt.Dimension(200, 100));

        lbl2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(51, 51, 51));
        lbl2.setText("Doctors");

        lblDoctor.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lblDoctor.setForeground(new java.awt.Color(0, 0, 0));
        lblDoctor.setText("20");

        javax.swing.GroupLayout panelPatientsLayout = new javax.swing.GroupLayout(panelPatients);
        panelPatients.setLayout(panelPatientsLayout);
        panelPatientsLayout.setHorizontalGroup(
            panelPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatientsLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(panelPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPatientsLayout.createSequentialGroup()
                        .addComponent(lblDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPatientsLayout.createSequentialGroup()
                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        panelPatientsLayout.setVerticalGroup(
            panelPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatientsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDoctor)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelPatients1.setBackground(new java.awt.Color(85, 170, 200));
        panelPatients1.setPreferredSize(new java.awt.Dimension(200, 100));

        lbl1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(51, 51, 51));
        lbl1.setText("Total Patients");

        lblPatients.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lblPatients.setForeground(new java.awt.Color(0, 0, 0));
        lblPatients.setText("125");

        javax.swing.GroupLayout panelPatients1Layout = new javax.swing.GroupLayout(panelPatients1);
        panelPatients1.setLayout(panelPatients1Layout);
        panelPatients1Layout.setHorizontalGroup(
            panelPatients1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatients1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(panelPatients1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPatients1Layout.createSequentialGroup()
                        .addComponent(lblPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPatients1Layout.createSequentialGroup()
                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        panelPatients1Layout.setVerticalGroup(
            panelPatients1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatients1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPatients)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelPatients2.setBackground(new java.awt.Color(180, 230, 180));
        panelPatients2.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Income");

        lblIncome.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lblIncome.setForeground(new java.awt.Color(0, 0, 0));
        lblIncome.setText("Rs500000");

        javax.swing.GroupLayout panelPatients2Layout = new javax.swing.GroupLayout(panelPatients2);
        panelPatients2.setLayout(panelPatients2Layout);
        panelPatients2Layout.setHorizontalGroup(
            panelPatients2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatients2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPatients2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        panelPatients2Layout.setVerticalGroup(
            panelPatients2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatients2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        panelPatients3.setBackground(new java.awt.Color(180, 230, 180));
        panelPatients3.setPreferredSize(new java.awt.Dimension(200, 100));

        lbl3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl3.setForeground(new java.awt.Color(51, 51, 51));
        lbl3.setText("Appointments");

        lblAppointments.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lblAppointments.setForeground(new java.awt.Color(0, 0, 0));
        lblAppointments.setText("50");

        javax.swing.GroupLayout panelPatients3Layout = new javax.swing.GroupLayout(panelPatients3);
        panelPatients3.setLayout(panelPatients3Layout);
        panelPatients3Layout.setHorizontalGroup(
            panelPatients3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatients3Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(panelPatients3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPatients3Layout.createSequentialGroup()
                        .addComponent(lblAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPatients3Layout.createSequentialGroup()
                        .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        panelPatients3Layout.setVerticalGroup(
            panelPatients3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatients3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAppointments)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tblDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patient", "Doctor", "Department", "Time", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblDashboard);

        btnNewBooking.setText("New Booking");
        btnNewBooking.addActionListener(this::btnNewBookingActionPerformed);

        jButton2.setText("Add Doctor ");

        btnGenerateReport.setText("Generate Report");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Today's Summary");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelPatients1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelPatients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelPatients3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelPatients2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 598, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPatients3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPatients2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPatients1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPatients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnNewBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointmentActionPerformed
         AppointmentFrame Back = new AppointmentFrame ();
        Back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAppointmentActionPerformed

    private void btnPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientActionPerformed
        PatientForm p = new PatientForm();
p.setVisible(true);
this.dispose();
    }//GEN-LAST:event_btnPatientActionPerformed

    private void btnNewBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewBookingActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
      loginForm login = new loginForm();
login.setVisible(true);
this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorActionPerformed
        DoctorFrame open = new DoctorFrame();
        open.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDoctorActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
      ReportFrame open = new ReportFrame();
        open.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnReportActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new DashboardFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAppointment;
    private javax.swing.JButton btnDoctor;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNewBooking;
    private javax.swing.JButton btnPatient;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lblAppointments;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblIncome;
    private javax.swing.JLabel lblPatients;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel panelPatients;
    private javax.swing.JPanel panelPatients1;
    private javax.swing.JPanel panelPatients2;
    private javax.swing.JPanel panelPatients3;
    private javax.swing.JTable tblDashboard;
    // End of variables declaration//GEN-END:variables
}
