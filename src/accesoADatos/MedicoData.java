
package accesoADatos;

import entidades.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class MedicoData {
    //atributos
    private Connection con;
    //constructor
    public MedicoData(){
        this.con = Conexion.getConectar();
    }
    
    //metodo insertar medico a traves de objectos
    public void insertarMedi(Medico medico){
        String sql = "Insert into medicos (apellidoMedi,nombresMedi,domicilioMedi,dniMedi,nroMatriculaMedi,telefonoMedi,especialidadMedi) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, medico.getApellidoMedi());
            ps.setString(2, medico.getNombresMedi());
            ps.setString(3, medico.getDomicilioMedi());
            ps.setString(4, medico.getDniMedi());
            ps.setString(5, medico.getNroMatriculaMedi());
            ps.setString(6, medico.getTelefonoMedi());
            ps.setString(7, medico.getEspecialidadMedi());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro cargado con éxito...");
        } catch (SQLException ex) {
            //Logger.getLogger(MedicoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al cargar el medico..." +ex.getMessage());
        }
    }
    
    //metodo mostrar medico a traves de un objecto
    public Medico mostrarMedi(){
        Medico medico = null;
        String sql = "Select * from medicos";
        try {
            //Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               medico = new Medico();
               medico.setIdMedi(rs.getInt("idMedi"));
               medico.setApellidoMedi(rs.getString("apellidoMedi"));
               medico.setNombresMedi(rs.getString("nombresMedi"));
               medico.setDomicilioMedi(rs.getString("nombresMedi"));
               medico.setDomicilioMedi(rs.getString("domicilioMedi"));
               medico.setDniMedi(rs.getString("dniMedi"));
               medico.setNroMatriculaMedi(rs.getString("nroMatriculaMedi"));
               medico.setTelefonoMedi(rs.getString("telefonoMedi"));
               medico.setEspecialidadMedi(rs.getString("especialidadMedi"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MedicoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al mostrar el medico..." +ex.getMessage());
        }
        return medico;
    }
    
    //metodo buscar por id 
    public Medico buscarPorId(int vId){
        Medico m = null;
        String sql = "Select * from medicos where idMedi=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, vId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                m = new Medico();
                m.setIdMedi(rs.getInt("idMedi"));
                m.setApellidoMedi(rs.getString("apellidoMedi"));
                m.setNombresMedi(rs.getString("nombresMedi"));
                m.setDomicilioMedi(rs.getString("domicilioMedi"));
                m.setDniMedi(rs.getString("dniMedi"));
                m.setNroMatriculaMedi(rs.getString("nroMatriculaMedi"));
                m.setTelefonoMedi(rs.getString("telefonoMedi"));
                m.setEspecialidadMedi(rs.getString("especialidadMedi"));
            }
              ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(MedicoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al buscar médico por id..." +ex.getMessage());
        }
        return m;
    }
}
