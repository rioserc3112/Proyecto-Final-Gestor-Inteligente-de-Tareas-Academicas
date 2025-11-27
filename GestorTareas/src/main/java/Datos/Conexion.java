
package Datos;
import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion 
{
        String url = "jdbc:mysql://localhost:3306/proyecto";
        String user="root";
        String password="12345";
       
    public Conexion() {}
       
    public Connection Conectar()
    {
     Connection con=null;
    
       try 
       {
           con = DriverManager.getConnection(url,user,password);
           return con;
           
        }
       catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage(),
                                        "ERROR",JOptionPane.ERROR_MESSAGE);
          return null;
       }
       
    }
    
    
                
}
