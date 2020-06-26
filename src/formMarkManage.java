
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mayuri
 */
public class formMarkManage extends javax.swing.JFrame {

    Connect cnn = new Connect();
    PreparedStatement ps;
    ResultSet rs;

    public formMarkManage() {
        initComponents();
        AddSubjectToComboBox();
        showData();
        btnHuy.setEnabled(false);
        btnLuu.setEnabled(false);
    }

    private void showData() {
        try {
            //clear bảng
            tMark.removeAll();
            //Đặt tên cho mấy cái cột trong bảng
            String[] arr = {"Subject", "Mark1", "Mark2", "Mark3"};
            //Mô hình bảng của JLabel truy xuất = vector
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            //Lấy data của sinh viên khi connect mở <hàm connect viết bên kia>
            if (Connect.open()) {
                int IDStudent = Integer.parseInt(formMark.txtIDS.getText());
                txtID.setText(""+IDStudent);
                ps = Connect.cnn.prepareStatement("Select subjects.subject_name, mark1, mark2, mark3 from mark,subjects where subjects.subject_id=mark.subject_id AND student_id=" + IDStudent + "");
                rs = ps.executeQuery();
                while (rs.next()) {
                    //Biến vector hoạt động khá giống 1 biến mảng
                    Vector vector = new Vector();
                    vector.add(rs.getString("subject_name"));
                    vector.add(rs.getString("mark1"));
                    vector.add(rs.getString("mark2"));
                    vector.add(rs.getString("mark3"));
                    //Chạy hàm addRow
                    model.addRow(vector);
                }
            }
            //đóng kết nối
            Connect.close(ps, rs);
            //Gắn vô bảng
            tMark.setModel(model);
        } catch (SQLException ex) {
            System.out.println("Not connect");
        }
    }
    
    private void AddSubjectToComboBox() {
        try {
            String[] arr = {"Subject", "Mark1", "Mark2", "Mark3"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            if (Connect.open()) {
                ps = Connect.cnn.prepareStatement("SELECT subject_name FROM subjects");
                rs = ps.executeQuery();
                while (rs.next()) {
                    cbbSubject.addItem(rs.getString(1));
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Not connect");
        }
    }

    private boolean check_id() {
        if (Connect.open()) {
            try {
                String cbb = String.valueOf(cbbSubject.getSelectedItem());
                ps = Connect.cnn.prepareStatement("Select subject_name from subjects,mark where subjects.subject_id=mark.subject_id AND subjects.subject_name="+cbb);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return false;
                }
            } catch (SQLException ex) {
                System.out.println("Loi cau query");
            }
        }
        return true;
    }

    public boolean check_input() {
        if (txtMark1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mark 1 must enter");
            txtMark1.requestFocus();
            return false;
        } else if (Float.parseFloat(txtMark1.getText()) > 10 || Float.parseFloat(txtMark1.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Mark 1 must between 0 and 10");
            txtMark1.requestFocus();
            return false;
        } else if (txtMark2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mark 2 must enter");
            txtMark2.requestFocus();
            return false;
        } else if (Float.parseFloat(txtMark2.getText()) > 10 || Float.parseFloat(txtMark2.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Mark 2 must between 0 and 10");
            txtMark1.requestFocus();
            return false;
        } else if (txtMark3.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mark 3 must enter");
            txtMark3.requestFocus();
            return false;
        } else if (Float.parseFloat(txtMark3.getText()) > 10 || Float.parseFloat(txtMark3.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Mark 3 must between 0 and 10");
            txtMark1.requestFocus();
            return false;
        }
        return true;
    }

    public void clear_input() {
        txtMark1.setText("");
        txtMark2.setText("");
        txtMark3.setText("");
        cbbSubject.setSelectedIndex(0);
    }
    
    public void Sua(){
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThoat.setEnabled(false);
        cbbSubject.setEnabled(false);
        btnLuu.setEnabled(true);
        btnHuy.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMark1 = new javax.swing.JTextField();
        cbbSubject = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtMark2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMark3 = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMark = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Subject");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Mark1");

        txtMark1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMark1KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Mark2");

        txtMark2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMark2KeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Mark3");

        txtMark3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMark3KeyTyped(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnThem.setText("Add");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnSua.setText("Edit");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnXoa.setText("Delete");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLuu.setText("Save");
        btnLuu.setToolTipText("");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnHuy.setText("Cancel");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnThoat.setText("Quit");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        tMark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMarkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tMark);

        txtID.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 102));
        jLabel5.setText("Manage mark");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(btnXoa))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(btnHuy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMark3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMark2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMark1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(cbbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMark1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMark2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMark3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnLuu)
                    .addComponent(btnThoat)
                    .addComponent(btnHuy))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        formMark fM = new formMark();
        fM.setVisible(true);
        fM.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtMark1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMark1KeyTyped
        char vchar = evt.getKeyChar();
        if (Character.isLetter(vchar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMark1KeyTyped

    private void txtMark2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMark2KeyTyped
        char vchar = evt.getKeyChar();
        if (Character.isLetter(vchar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMark2KeyTyped

    private void txtMark3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMark3KeyTyped
        char vchar = evt.getKeyChar();
        if (Character.isLetter(vchar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMark3KeyTyped

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        check_input(); 
        if (tMark.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Phải chọn một dòng để xóa!");
            return;
        }        
        if(check_input()==false){
            return;
        }else if (Connect.open()) {
            try {
                int row = tMark.getSelectedRow();
                int maSV_to_up = Integer.parseInt(formMark.txtIDS.getText());
                int maSubject_to_up = cbbSubject.getSelectedIndex() + 1;
                float mark1 = Float.parseFloat(txtMark1.getText());
                float mark2 = Float.parseFloat(txtMark2.getText());
                float mark3 = Float.parseFloat(txtMark3.getText());
                float medium_mark = (Float.parseFloat(txtMark1.getText()) + Float.parseFloat(txtMark1.getText()) + Float.parseFloat(txtMark1.getText())) / 3;
                ps = Connect.cnn.prepareStatement("UPDATE mark SET mark1="+mark1+",mark2="+mark2+",mark3="+mark3+",medium_mark="+medium_mark+" WHERE subject_id="+maSubject_to_up+" AND student_id="+maSV_to_up+"");
                ps.executeUpdate();
                showData();
                clear_input();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        btnHuy.setEnabled(false);
        btnLuu.setEnabled(false);
        btnThoat.setEnabled(true);
        cbbSubject.setEnabled(true);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        check_input(); 
        if(check_input()==false){
            return;
        }else
        try {
            
            int subject_id = cbbSubject.getSelectedIndex() + 1;
            float mark1 = Float.parseFloat(txtMark1.getText());
            float mark2 = Float.parseFloat(txtMark2.getText());
            float mark3 = Float.parseFloat(txtMark3.getText());
            float medium_mark = (Float.parseFloat(txtMark1.getText()) + Float.parseFloat(txtMark1.getText()) + Float.parseFloat(txtMark1.getText())) / 3;

            Connect.open();
            ps = Connect.cnn.prepareStatement("INSERT INTO mark VALUES (" + subject_id + "," + formMark.txtIDS.getText() + "," + mark1 + "," + mark2 + "," + mark3 + "," + medium_mark + ")");
            ps.executeUpdate();
            Connect.close(ps, rs);
            showData();
        } catch (SQLException ex) {
            System.out.println("Error add mark");
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void NapItemDuocChon() {
        if (tMark.getSelectedRow() < 0) {
            return;
        }
        int row = tMark.getSelectedRow();
        txtMark1.setText(tMark.getValueAt(row, 1).toString());
        txtMark2.setText(tMark.getValueAt(row, 2).toString());
        txtMark3.setText(tMark.getValueAt(row, 3).toString());
        for (int i = 0; i < cbbSubject.getItemCount(); i++) {
            if (cbbSubject.getItemAt(i).equals((String) tMark.getValueAt(row, 0))) {
                cbbSubject.setSelectedIndex(i);
            }
        }
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tMark.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Phải chọn một dòng để xóa!");
            return;
        }
        if (Connect.open()) {
            try {
                int row = tMark.getSelectedRow();
                int maSV_to_del = Integer.parseInt(formMark.txtIDS.getText());
                int maSubject_to_del = cbbSubject.getSelectedIndex() + 1;
                ps = Connect.cnn.prepareStatement("DELETE FROM mark WHERE subject_id = " + maSubject_to_del + " AND student_id =" + maSV_to_del);
                ps.executeUpdate();
                showData();
                clear_input();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMarkMouseClicked
        NapItemDuocChon();
    }//GEN-LAST:event_tMarkMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        Sua();
    }//GEN-LAST:event_btnSuaActionPerformed

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
            java.util.logging.Logger.getLogger(formMarkManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formMarkManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formMarkManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formMarkManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formMarkManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMark;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMark1;
    private javax.swing.JTextField txtMark2;
    private javax.swing.JTextField txtMark3;
    // End of variables declaration//GEN-END:variables
}
