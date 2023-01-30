

import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

//insert data to the database 

@ManagedBean
@Named("usersDataInsert")
@RequestScoped
public class UsersDataInsert implements Serializable{
     private float ticket_no;
     private String user_id;
     private String username;
 private String phone_no;
  private String city;
   private String sub_city;
   private String street_no;
    private String home_no;
   
    private float food_price;
    private String food_detail;

    public float getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(float ticket_no) {
        this.ticket_no = ticket_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

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

    public float getFood_price() {
        return food_price;
    }

    public void setFood_price(float food_price) {
        this.food_price = food_price;
    }

    
  

    public String getFood_detail() {
        return food_detail;
    }

    public void setFood_detail(String food_detail) {
        this.food_detail = food_detail;
    }

   
    
    public UsersDataInsert() {
        
    }
    
 

 public void  insertData() throws SQLException{
     try{
    // UsersTest obj = new UsersTest();
 DBConnection connect=new DBConnection();
 Connection conn=connect.connMethod();
 String query="insert into CUSTOMER_TABLE(TICKET_NO,USER_ID,FULL_NAME,PHONE,CITY,SUB_CITY,STREET_NO,HOME_NO,FOOD_PRICE,FOOD_NAME) values(?,?,?,?,?,?,?,?,?,?)";
 PreparedStatement prep=conn.prepareStatement(query);
prep.setFloat(1,ticket_no);
prep.setString(2,user_id);
 prep.setString(3,username);
  prep.setString(4,phone_no);
   prep.setString(5,city);
    prep.setString(6,sub_city);
     prep.setString(7,street_no);
     prep.setString(8,home_no);
     prep.setFloat(9,food_price);
      prep.setString(10,food_detail);
     prep.executeUpdate();
  System.err.println("success");
     }catch(SQLException e){}  
        
 }
 
private String ticket;
private String id;
private String name;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
  public void  updateData() throws SQLException{
     try{
 DBConnection connect=new DBConnection();
 Connection conn=connect.connMethod();
 String query="update CUSTOMER_TABLE set USER_ID=?, FULL_NAME=? where TICKET_NO=? ";
 PreparedStatement prep=conn.prepareStatement(query);
  
 prep.setString(1,id);
 prep.setString(2,name);
prep.setString(3,ticket);
     prep.executeUpdate();
     }catch(SQLException e){}  
        
 }
  
 
}
