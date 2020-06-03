
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
public class Connect {
    //Mấy cái biến linh tinh xài trong connect với JDBC
    public static String url = "jdbc:mysql://localhost:3306/db_qlsv?useTimezone=true&serverTimezone=UTC";
    public static String user = "root";
    public static String pass = "";
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static Connection cnn;
    //Hàm tiến hành kết nối mysql
    public static boolean open()
    {
        try
        {
            //Mấy cái chữ xanh lá chuối đã được khai báo ở trên
            if (cnn == null || cnn.isClosed())
            {
                Class.forName(driver);
                cnn = DriverManager.getConnection(url, user, pass);
                System.out.println("Success");
            }
            return true;
        }
        catch (SQLException ex)
        {
            System.out.println("Don't fine database");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Driver error");
        }
        return false;
    }
    //Hàm đóng kết nối database
    public static void close()
    {
        try
        {
            //Mấy cái chữ xanh lá chuối đã được khai báo ở trên
            if (cnn != null)
                cnn.close();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    //Hàm đóng kết nối database, sẵn tiện tắt luôn PreparedStatement(Nó được sử dụng để thực hiện truy vấn tham số.)
    public static void close(PreparedStatement ps)
    {
        try
        {
            if (ps != null)
                ps.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    //Tương tự ở trên(Đối tượng của ResultSet duy trì một con trỏ trỏ đến một hàng của một bảng. Ban đầu, con trỏ trỏ đến hàng đầu tiên.)
    public static void close(PreparedStatement ps, ResultSet rs)
    {
        try
        {
            if (rs !=null)
                rs.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        close(ps);
    }
    public static void main(String[] args) {
        Connect.open();
    }
}
