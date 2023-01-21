

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


@ManagedBean
@Named("usersTest")
@RequestScoped
public class UsersTest implements Serializable{
     private String username;
 private String phone_no;
  private String city;
   private String sub_city;
   private String street_no;
    private String home_no;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSub_city() {
        return sub_city;
    }

    public void setSub_city(String sub_city) {
        this.sub_city = sub_city;
    }

   

    public String getStreet_no() {
        return street_no;
    }

    public void setStreet_no(String street_no) {
        this.street_no = street_no;
    }

    public String getHome_no() {
        return home_no;
    }

    public void setHome_no(String home_no) {
        this.home_no = home_no;
    }

    public UsersTest() {
        
    }
    
 

 public void  insertData() throws SQLException{
     try{
    // UsersTest obj = new UsersTest();
 DBConnection connect=new DBConnection();
 Connection conn=connect.connMethod();
 String query="insert into MYUSERTABLE(NAME,PHONE,CITY,SUB_CITY,STREET_NO,HOME_NO) values(?,?,?,?,?,?)";
 PreparedStatement prep=conn.prepareStatement(query);
// PreparedStatement prep=conn.prepareStatement(query);
 prep.setString(1,username);
  prep.setString(2,phone_no);
   prep.setString(3,city);
    prep.setString(4,sub_city);
     prep.setString(5,street_no);
     prep.setString(6,home_no);
     prep.executeUpdate();
  System.err.println("success");
     }catch(Exception e){}  
        
 }


}
