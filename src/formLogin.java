
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mayuri
 */
public class formLogin extends javax.swing.JFrame {
    //Cái này để tí xài
    public static String nameLogin = "";
    //Gắn ps, rs về null
    PreparedStatement ps = null;
    ResultSet rs = null;
    //Hàm thực thi việc đăng nhập
    public void login()
    {
        //set biến 
        String s = "";
        String user = txtUser.getText();
        String pass = txtPass.getText();
        if (user.equals(s) || pass.equals(s))
        {
            JOptionPane.showMessageDialog(null, "Please enter your username and password");
            
        }
        if (user.equals(s) || pass.equals(s)){
            JOptionPane.showMessageDialog(null, "Username and password must be 8 characters or more");
        }
        else if (Connect.open())
        {
            try
            {
                //boolean blean = true;
                //Câu query lấy thông tin ben database lưu vào biến ps
                ps = Connect.cnn.prepareStatement("Select usernames, passwords from accounts");
                //rs là biến ResultSet gọi executeQuery
                rs = ps.executeQuery();
                System.out.println(""+rs);
                //Con trỏ rs đứng ở dòng đầu tiên tiến hành chạy đến dòng kế tiếp
                while (rs.next())
                {
                    //2 biến username và password dươc gán 
                    String username = "" + rs.getString("usernames");
                    String password = "" + rs.getString("passwords");
                    //kiểm tra điều kiện đăng nhập
                    if (!user.equals(username) || !pass.equals(password))
                    {
                        JOptionPane.showMessageDialog(null, "Wrong login information", "Message", JOptionPane.ERROR_MESSAGE);
                        txtUser.selectAll();
                        txtPass.setText("");                       
                    }
                    //Nhảy đến form Home khi dk đúng
                    else
                    {
                        nameLogin = username;
                        formHome fH=new formHome();
                        fH.setVisible(true);
                        fH.setLocationRelativeTo(null);
                        dispose();
                    }
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(formLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public formLogin() {
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

        lbImage1 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lbUsername = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 255));

        lbImage1.setForeground(new java.awt.Color(255, 255, 255));
        lbImage1.setIcon(new javax.swing.ImageIcon("D:\\Image\\iLogin.png")); // NOI18N

        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPassKeyReleased(evt);
            }
        });

        lbUsername.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbUsername.setText("Username:");

        lbPassword.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbPassword.setText("Password:");

        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserKeyReleased(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lbLogin.setForeground(new java.awt.Color(255, 0, 0));
        lbLogin.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(lbImage1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPassword)
                            .addComponent(lbUsername))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(173, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnLogin)
                        .addGap(151, 151, 151)
                        .addComponent(btnClear)
                        .addGap(152, 152, 152)
                        .addComponent(btnCancel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbLogin)
                        .addGap(371, 371, 371))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lbImage1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lbLogin)
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbUsername)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPassword)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLogin)
                            .addComponent(btnClear)
                            .addComponent(btnCancel))))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //event đang nhập
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();   
    }//GEN-LAST:event_btnLoginActionPerformed
    //event xóa 
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtUser.setText("");
        txtPass.setText("");
    }//GEN-LAST:event_btnClearActionPerformed
    //event thoát
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    //void keyReleased(KeyEvent e): Được thực thi khi một key đã được nhả ra. nó để ấn enter thay vì rê con chuột
    private void txtUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            txtPass.requestFocus();
        }
    }//GEN-LAST:event_txtUserKeyReleased
    //tương tự
    private void txtPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            login();
        }
    }//GEN-LAST:event_txtPassKeyReleased
    
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
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /* Create and display the form */
        formLogin fL = new formLogin();
        //Hiển thị Frame
        fL.setVisible(true);
        //Ngăn hông cho ấn nút phóng to thu nhỏ
        fL.setResizable(false);
        //Cài đặt size cửa sổ
        fL.setBounds(1200,600,1200,600);
        //Cài đặt hiển thị vị trí của Frame ở giữa
        fL.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lbImage1;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
