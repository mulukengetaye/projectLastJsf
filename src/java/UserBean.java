
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Dependent
@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {

    public List<UsersTest> getuserList() {
        List<UsersTest> list = new ArrayList<>();
        try {
          
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from MYUSERTABLE");
            while (rs.next()) {
                UsersTest usr = new UsersTest();
                usr.setUsername(rs.getString("NAME"));
                usr.setPhone_no(rs.getString("PHONE"));
                usr.setCity(rs.getString("CITY"));
                  usr.setSub_city(rs.getString("SUB_CITY"));
                usr.setStreet_no(rs.getString("STREET_NO"));
                usr.setHome_no(rs.getString("HOME_NO"));
              list.add(usr);
              
            }
        } catch (SQLException e) {
        }
        return list;
    }

}
