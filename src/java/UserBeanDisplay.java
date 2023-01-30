
import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import static oracle.net.aso.C05.d;
//DISPLAY DATA TO THE SCREEN
@Dependent
@ManagedBean(name="userBeanDisplay")
@SessionScoped
@RequestScoped
public class UserBeanDisplay implements Serializable {

    public List<UsersDataInsert> getuserList() {
        List<UsersDataInsert> list = new ArrayList<>();
        try {
          
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from CUSTOMER_TABLE");
            while (rs.next()) {
                UsersDataInsert userdisp = new UsersDataInsert();
                
                   userdisp.setTicket_no(rs.getFloat("TICKET_NO"));
                    userdisp.setUser_id(rs.getString("USER_ID"));
                userdisp.setUsername(rs.getString("FULL_NAME"));
                userdisp.setPhone_no(rs.getString("PHONE"));
                userdisp.setCity(rs.getString("CITY"));
                  userdisp.setSub_city(rs.getString("SUB_CITY"));
                userdisp.setStreet_no(rs.getString("STREET_NO"));
                userdisp.setHome_no(rs.getString("HOME_NO"));
                userdisp.setFood_detail(rs.getString("FOOD_NAME"));
                userdisp.setFood_price(rs.getFloat("FOOD_PRICE"));
              list.add(userdisp);
              
            }
        } catch (SQLException e) {
        }
        return list;
    }
    private float ticket_no;

    public float getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(float ticket_no) {
        this.ticket_no = ticket_no;
    }


    
    public List<UsersDataInsert> getuserSearch() {
        List<UsersDataInsert> list = new ArrayList<>();
        try {
          
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement prep=con.prepareStatement("select * from CUSTOMER_TABLE where TICKET_NO=?");
           
            prep.setFloat(1, ticket_no);
            
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                
                UsersDataInsert usr = new UsersDataInsert();
                
                   usr.setTicket_no(rs.getFloat("TICKET_NO"));
                    usr.setUser_id(rs.getString("USER_ID"));
                usr.setUsername(rs.getString("FULL_NAME"));
                usr.setPhone_no(rs.getString("PHONE"));
                usr.setCity(rs.getString("CITY"));
                  usr.setSub_city(rs.getString("SUB_CITY"));
                usr.setStreet_no(rs.getString("STREET_NO"));
                usr.setHome_no(rs.getString("HOME_NO"));
                usr.setFood_detail(rs.getString("FOOD_NAME"));
                usr.setFood_price(rs.getFloat("FOOD_PRICE"));
              list.add(usr);
                
              
            }
        } catch (SQLException e) {
        }
        return list;
    }
   
   
    
    
    

}
