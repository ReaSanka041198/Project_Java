
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

                ps = Connect.cnn.prepareStatement("Select * from subjects, mark where subjects.subject_id = mark.subject_id and mark.student_id=" + formMark.txtIDS.getText() + " ");
                rs = ps.executeQuery();
                while (rs.next()) {
                    return false;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
        return true;
    }

    public void check_input() {
        if (txtMark1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mark 1 must enter");
            txtMark1.requestFocus();
            return;
        } else if (Integer.parseInt(txtMark1.getText()) > 10 || Integer.parseInt(txtMark1.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Mark 1 must between 0 and 10");
            txtMark1.requestFocus();
            return;
        } else if (txtMark2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mark 2 must enter");
            txtMark2.requestFocus();
            return;
        } else if (Integer.parseInt(txtMark2.getText()) > 10 || Integer.parseInt(txtMark2.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Mark 2 must between 0 and 10");
            txtMark1.requestFocus();
            return;
        } else if (txtMark3.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mark 3 must enter");
            txtMark3.requestFocus();
            return;
        } else if (Integer.parseInt(txtMark3.getText()) > 10 || Integer.parseInt(txtMark3.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Mark 3 must between 0 and 10");
            txtMark1.requestFocus();
            return;
        }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Subject");

        jLabel2.setText("Mark1");

        txtMark1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMark1KeyTyped(evt);
            }
        });

        jLabel3.setText("Mark2");

        txtMark2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMark2KeyTyped(evt);
            }
        });

        jLabel4.setText("Mark3");

        txtMark3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMark3KeyTyped(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.setToolTipText("");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(cbbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtMark1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtMark2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txtMark3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(191, 191, 191)
                            .addComponent(btnThem)
                            .addGap(56, 56, 56)
                            .addComponent(btnSua)
                            .addGap(54, 54, 54)
                            .addComponent(btnXoa)
                            .addGap(63, 63, 63)
                            .addComponent(btnLuu)
                            .addGap(58, 58, 58)
                            .addComponent(btnHuy)
                            .addGap(50, 50, 50)
                            .addComponent(btnThoat))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtMark1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMark3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtMark2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLuu)
                    .addComponent(btnHuy)
                    .addComponent(btnThoat))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
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
        if (tMark.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Phải chọn một dòng để xóa!");
            return;
        }
        if (Connect.open()) {
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
            JOptionPane.showMessageDialog(this, ex);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMark;
    private javax.swing.JTextField txtMark1;
    private javax.swing.JTextField txtMark2;
    private javax.swing.JTextField txtMark3;
    // End of variables declaration//GEN-END:variables
}
