
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userBean")
@SessionScoped
public class TableBean {

    public List< CustomTable> getUserList() {
        List< CustomTable> list = new ArrayList< CustomTable>();
        try {
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from USERTBL");
            while (rs.next()) {
                 CustomTable usr = new  CustomTable();
                usr.setUser(rs.getString("USERNAME"));
                usr.setPass(rs.getString("PASSWORD"));
                usr.setUserType(rs.getString("USERTYPE"));;
                list.add(usr);
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
