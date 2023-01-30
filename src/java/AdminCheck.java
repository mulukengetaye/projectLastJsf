
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.inject.Named;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author getay
 */
@RequestScoped
@Named("adminCheck")
@ManagedBean
public class AdminCheck implements Serializable {
    
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    
    public String adminChecker()throws SQLException, ClassNotFoundException{
     
        boolean acheck=LogAdmin.check(name,password);
        if(acheck){
        DBConnection connect=new DBConnection();
        Connection conn=connect.connMethod();
        PreparedStatement pre=conn.prepareStatement("select USERNAME from ADMINTABLE where USERNAME=? and PASSWORD=?");
         pre.setString(1, name); 
         pre.setString(2,password);
            ResultSet rs = pre.executeQuery();
            rs.next();
            String u_type =rs.getString(1);
         
            if ("Admin".equals(u_type)) {
                return "AdminWorks";
          } 
      }
        return "User";
    }} 
        
    
        
    
   
    
    
    
        
    
    

