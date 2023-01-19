
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@ManagedBean
@Named("logAdmin")
@RequestScoped
public class LogAdmin implements Serializable {  
public static String username;
public static String userpassword;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        LogAdmin.username = username;
    }

  

    public static String getUserpassword() {
        return userpassword;
    }

    public static void setUserpassword(String userpassword) {
        LogAdmin.userpassword = userpassword;
    }



    public static boolean check(String username, String userpassword) {
    
    boolean status=false;
        try {
           
           Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java2021", "1616");
            //CallableStatement callobj=con.prepareCall("{call SsELECTUSe(?)}");
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select * from AdminTable where USERNAME=? and PASSWORD=?");
            ps.setString(1, username);
            ps.setString(2, userpassword);
            ResultSet rs = ps.executeQuery();
            status = rs.next();  
            
        } catch (Exception e) {
            e.printStackTrace();
        }

return status;
    }   
}
