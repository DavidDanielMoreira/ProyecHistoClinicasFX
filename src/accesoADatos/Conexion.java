
package accesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Conexion {
    //atributos estaticoa
    private static String URL = "jdbc:mysql://localhost/bd_hclinicas";
    private static String USER = "root";
    private static String PASS = "";
    private static Connection conexion = null;
    //constructor privado para no instanciar ningun objecto de tipo Conexion
    private Conexion(){}
    
    //metodo estatico y de tipo Connection para establecer la conexion a la base de datos
    public static Connection getConectar(){
        if(conexion==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USER, PASS);
                //JOptionPane.showMessageDialog(null, "Conexión exitosa a la base de datos...");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers..." + ex.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al seleccionar la base de datos..." + ex.getMessage());
            }
        }
        return conexion;
    }
}
