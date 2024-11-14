/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package OPP;


import java.awt.Frame;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Akmal Kurniawan
 */
public class login extends javax.swing.JFrame {
    

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitorcashcreditcard_101090.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        jLabel3.setText("Username");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel3.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 180, -1));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel3.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 180, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 103, 380, 10));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel3.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 140, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 380, 180));

        jPanel1.add(jPanel2, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String user = txtUsername.getText();
        String pass = new String(txtPassword.getPassword());
        
        try {

            Connection K = Koneksi.Go();
            String Q = "SELECT * FROM users WHERE username=? AND password=?;";
            PreparedStatement S = K.prepareStatement(Q);
            S.setString(1, user);
            S.setString(2, pass);
            ResultSet R = S.executeQuery();
            int count = 0;
            Profile P = new Profile();
            while (R.next()) {                 
                P.setId(R.getInt("ID")); 
                P.setFullname(R.getString("fullname")); 
                P.setUsername(R.getString("username")); 
                P.setPassword(R.getString("Password")); 
                P.setLevel(R.getString("level")); 
                count++;
            }
            
            if(count > 0){
                JOptionPane.showMessageDialog(this, "Sukses Login");
                switch (P.getLevel()) {
                    case "admin" ->                         {
                            AdminPage O = new AdminPage(P);
                            O.setExtendedState(Frame.MAXIMIZED_BOTH);
                            this.setVisible(false);
                            O.setVisible(true);
                        }
//                    case "KASIR" ->                         {
//                            kasir_page O = new kasir_page(P);
//                            O.setExtendedState(Frame.MAXIMIZED_BOTH);
//                            this.setVisible(false);
//                            O.setVisible(true); 
//                        }
//                    case "owner" ->                         {
//                            owner O = new owner(P);
//                            O.setExtendedState(Frame.MAXIMIZED_BOTH);
//                            this.setVisible(false);
//                            O.setVisible(true);
//                        }
                    default -> {
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "Invalid username/password");
                txtUsername.requestFocus();
            }
            
        } catch (HeadlessException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnLoginActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
