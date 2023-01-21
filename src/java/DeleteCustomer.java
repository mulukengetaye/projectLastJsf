
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author getay
 */
@ManagedBean
@RequestScoped
public class DeleteCustomer {
    private String username;
      public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void delete(){
    
            
            Boolean status=false;
            String query = "delete from MYUSERTABLE where NAME='"+username+"'";
            DBConnection connection1 = new DBConnection();
            Connection connection = connection1.connMethod();
            Statement statement = null;
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try{
                status=statement.execute(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    
}
