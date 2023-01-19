
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author THECREW
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    public List<UsersTest> getUserList() {
        List<UsersTest> list = new ArrayList<>();
        try {
            String[] course = null;
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from MYUSERTABLE");
            while (rs.next()) {
                UsersTest usr = new UsersTest();
                usr.setusername(rs.getString("NAME"));
                usr.setphone_no(rs.getString("PHONE"));
                usr.setcity(rs.getString("CITY"));
                  usr.setsub_city(rs.getString("SUB_CITY"));
                usr.setstreet_no(rs.getString("STREET_NO"));
                usr.sethome_no(rs.getString("HOME_NO"));
                
               
              // list.add(usr);
            }
        } catch (SQLException e) {
        }
        return list;
    }

}
