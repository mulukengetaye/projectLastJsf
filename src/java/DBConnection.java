

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "JAVA2022";
    private static final String PASSWORD = "sys";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    Connection conn = null;

    public Connection connMethod() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if(conn!=null){
            System.out.println("connected successfully");
            }
            else{
                        System.out.println("not connected ");

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
      public static void main(String args[] ){
    DBConnection db=new DBConnection();
    db.connMethod();
    }

    
}