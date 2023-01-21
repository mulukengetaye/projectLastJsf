
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

private static String Driver="oracle.jdbc.driver.OracleDriver";
    public static boolean check(String username, String userpassword) {
    
    boolean status=false;
        try {
           
           Class.forName(Driver);
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
