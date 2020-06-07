
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
public class formStudent extends javax.swing.JFrame {

    /**
     * Creates new form formStudent
     */
    Connect cnn = new Connect();
    PreparedStatement ps;
    ResultSet rs;
    public formStudent() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tStudent = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtAD = new javax.swing.JTextField();
        txtLN = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbCN = new javax.swing.JComboBox<>();
        cbGD = new javax.swing.JComboBox<>();
        dtBD = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtFN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 153, 153));

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setForeground(new java.awt.Color(255, 204, 204));

        tStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FirstName", "LastName", "Birthday", "Gender", "Address", "ClassID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tStudent);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Manage Student");

        jLabel8.setText("ID");

        jLabel9.setText("FirstName");

        jLabel10.setText("LastName");

        txtID.setBackground(new java.awt.Color(204, 255, 255));

        txtAD.setBackground(new java.awt.Color(204, 255, 255));

        txtLN.setBackground(new java.awt.Color(204, 255, 255));

        jLabel11.setText("Gender");

        jLabel12.setText("Address");

        jLabel13.setText("ClassName");

        cbCN.setBackground(new java.awt.Color(204, 255, 255));

        cbGD.setBackground(new java.awt.Color(204, 255, 255));
        cbGD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "BD" }));

        dtBD.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("Birthday");

        txtFN.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/isd.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(19, 19, 19)
                                .addComponent(txtLN, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(55, 55, 55)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtFN, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(180, 180, 180)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbGD, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCN, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAD, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(btnAdd)
                        .addGap(197, 197, 197)
                        .addComponent(btnEdit)
                        .addGap(187, 187, 187)
                        .addComponent(btnDelete)))
                .addContainerGap(224, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(dtBD, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addGap(326, 326, 326)
                        .addComponent(jLabel7)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cbGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtFN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtLN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cbCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Hàm lấy data đưa vào table tStudent
    private void showData(){
        try {
            //clear bảng
            tStudent.removeAll();
            //Đặt tên cho mấy cái cột trong bảng
            String[] arr = {"ID","FirstName","LastName","Birthday","Gender","Address","ClassName"};
            //Mô hình bảng của JLabel truy xuất = vector
            DefaultTableModel model = new DefaultTableModel(arr, 0);  
            //Lấy data của sinh viên khi connect mở <hàm connect viết bên kia>
            if(Connect.open()){
                ps = Connect.cnn.prepareStatement("Select * from students");
            
            rs = ps.executeQuery();
                while (rs.next()) {
                    //Biến vector hoạt động khá giống 1 biến mảng
                    Vector vector = new Vector();
                    vector.add(rs.getString("student_id"));
                    vector.add(rs.getString("first_name"));
                    vector.add(rs.getString("last_name"));
                    vector.add(rs.getString("birthday"));
                    vector.add(rs.getString("gender"));
                    vector.add(rs.getString("address"));
                    vector.add(rs.getString("class_name"));
                    //Chạy hàm addRow
                    model.addRow(vector);
                }
            }
            //đóng kết nối
            Connect.close(ps, rs);
            //Gắn vô bảng
            tStudent.setModel(model);
        } catch (SQLException ex) {
            System.out.println("Not connect");
        }
    }
    //Kiểm tra sự tồn tại của sinh viên
    private boolean check_id(){
        if(Connect.open()){
            try {
                ps = Connect.cnn.prepareStatement("Select * from students where student_id = ?");
                ps.setString(1, txtID.getText());
                rs = ps.executeQuery();
                while (rs.next()) {
                    return false;                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(formStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        return true;
    }
    
    public void check_input(){
        if(txtID.getText().equals("")){
            JOptionPane.showMessageDialog(this, "please import studentID");
            txtID.requestFocus();
            return;
        }
        else if(txtFN.getText().equals("")){
            JOptionPane.showMessageDialog(this, "please import first name");
            txtFN.requestFocus();
            return;
        }
        else if(txtLN.getText().equals("")){
            JOptionPane.showMessageDialog(this, "please import last name");
            txtLN.requestFocus();
            return;
        }
        else if(txtAD.getText().equals("")){
            JOptionPane.showMessageDialog(this, "please import address");
            txtAD.requestFocus();
            return;
        }
        else if(cbGD.equals("")){
            JOptionPane.showMessageDialog(this, "please choose gender");
            cbGD.requestFocus();
            return;
        }
        else if(cbCN.equals("")){
            JOptionPane.showMessageDialog(this, "please choose class name");
            cbCN.requestFocus();
            return;
        }
        else if(dtBD.equals("")){
            JOptionPane.showMessageDialog(this, "please choose Birthday");
            dtBD.requestFocus();
            return;
        }
        String id= txtID.getText();
        if(id.length()>10){
            JOptionPane.showMessageDialog(this, "ID must 10 character");
            txtID.requestFocus();
            return;
        }
        String fn=txtFN.getText();
        if(fn.length()>7)
        {
            JOptionPane.showMessageDialog(this, "First name < 7 character");
            txtFN.requestFocus();
            return;
        }
        String ln=txtLN.getText();
        if(ln.length()>7)
        {
            JOptionPane.showMessageDialog(this, "First name < 7 character");
            txtLN.requestFocus();
            return;
        }
        String ad=txtAD.getText();
        if(ad.length()>70)
        {
            JOptionPane.showMessageDialog(this, "Please check address < 70 character");
            txtAD.requestFocus();
            return;
        }
    }
    
    public void showCB(){
        if(Connect.open()){
            try {
                ps = Connect.cnn.prepareStatement("Select classes.class_name from classes");
                rs = ps.executeQuery();
                while (rs.next()) {                    
                    cbCN.addItem(rs.getString(1));
                }
 
            } catch (SQLException ex) {
                System.out.println("Error Query");;
            }
        }
    }
    
    private void tStudent(java.awt.event.MouseEvent evt){
        DefaultTableModel model = null;
        int id = tStudent.getSelectedRow();
        txtID.setText((String)(model.getValueAt(id, 0)));
    }
    
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        showData();
        showCB();
    }//GEN-LAST:event_formComponentShown

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int id = tStudent.getSelectedRow();
        String data=tStudent.getModel().getValueAt(id, 0).toString();
        if(Connect.open()){
                try {
                    //Mấy dấu ? đại diện cho 1 bột
                    ps = Connect.cnn.prepareStatement("DELETE FROM students WHERE student_id=?");
                    ps.setString(1, data);                    
                    //excuteUpdate xài cho delete
                    ps.executeUpdate();    
                    //cập nhật lại db
                    showData();
                    Connect.close(ps);                   
                } catch (SQLException ex) {
                    System.out.println("Error");
                }
            }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        //Mấy hàm check data nhập vào có đúng định dạng k
        check_input();
        if(check_id()==false){
            JOptionPane.showMessageDialog(this, "student id exist");
            txtID.requestFocus();
            return;
        }else{
            if(Connect.open()){
                try {
                    //Mấy dấu ? đại diện cho 1 bột
                    ps = Connect.cnn.prepareStatement("INSERT INTO students (student_id, first_name, last_name, birthday, gender, address, class_name)"+"VALUES(?,?,?,?,?,?,?)");
                    ps.setString(1, txtID.getText());
                    ps.setString(2, txtFN.getText());
                    ps.setString(3, txtLN.getText());
                    //ép kiểu dtBD nhưng đang lỗi và giờ đã hết lỗi haha
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String dl = format.format(new Date());
                    ps.setString(4, dl);
                    //ép kiểu combobox
                    String gd = String.valueOf(cbGD.getSelectedItem());
                    ps.setString(5, gd);
                    ps.setString(6, txtAD.getText());
                    String cn = String.valueOf(cbCN.getSelectedItem());
                    ps.setString(7, cn);
                    //excuteUpdate xài cho insert
                    ps.executeUpdate();  
                    //cập nhật lại db
                    showData();
                    Connect.close(ps);                   
                } catch (SQLException ex) {
                    System.out.println("Error");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int id = tStudent.getSelectedRow();
        String data=tStudent.getModel().getValueAt(id, 0).toString();
        if(Connect.open()){
                try {
                    //Mấy dấu ? đại diện cho 1 bột
                    ps = Connect.cnn.prepareStatement("UPDATE students SET first_name=?, last_name=?, birthday=?, gender=?, address=?, class_name=? WHERE student_id="+data);                   
                    //ps.setString(1, txtID.getText());
                    ps.setString(1, txtFN.getText());
                    ps.setString(2, txtLN.getText());
                    //ép kiểu dtBD nhưng đang lỗi và giờ đã hết lỗi haha
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String dl = format.format(new Date());
                    ps.setString(3, dl);
                    //ép kiểu combobox
                    String gd = String.valueOf(cbGD.getSelectedItem());
                    ps.setString(4, gd);
                    ps.setString(5, txtAD.getText());
                    String cn = String.valueOf(cbCN.getSelectedItem());
                    ps.setString(6, cn);
                    //excuteUpdate xài cho insert
                    ps.executeUpdate();  
                    //cập nhật lại db
                    showData();
                    Connect.close(ps);                   
                } catch (SQLException ex) {
                    System.out.println("Error--");
                }
            }
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(formStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        formStudent fS=new formStudent();
        //Hiển thị Frame
        fS.setVisible(true);
        //Ngăn hông cho ấn nút phóng to thu nhỏ
        fS.setResizable(false);
        //Cài đặt size cửa sổ
        fS.setBounds(1200,600,1200,600);
        //Cài đặt hiển thị vị trí của Frame ở giữa
        fS.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbCN;
    private javax.swing.JComboBox<String> cbGD;
    private com.toedter.calendar.JDateChooser dtBD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tStudent;
    private javax.swing.JTextField txtAD;
    private javax.swing.JTextField txtFN;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLN;
    // End of variables declaration//GEN-END:variables
}
