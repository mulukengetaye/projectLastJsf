
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
     private static final long serialVersionUID = 1094801825228386363L;
    private String userType;
    private String password;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    
    public String adminChecker()throws SQLException, ClassNotFoundException{
     
        boolean acheck=LogAdmin.check(userType,password);
        if(acheck){
        DBConnection connect=new DBConnection();
        Connection conn=connect.connMethod();
        PreparedStatement pre=conn.prepareStatement("select USERTYPE from USERTBL where USERNAME=?");
         pre.setString(1, userType);       
            ResultSet rs = pre.executeQuery();
            rs.next();
            String userType =rs.getString(1);
         
            if ("Admin".equals(userType)) {
                return "Manager";
            } else {
                return "index";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "User";
        }
        }
    
    
    
    }
   
    
    
    
        
    
    

