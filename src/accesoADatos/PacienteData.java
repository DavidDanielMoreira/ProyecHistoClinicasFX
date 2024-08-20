package accesoADatos;

import entidades.*;
import accesoADatos.*;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class PacienteData {

    //atributos
    private Connection con;

    //constructor
    public PacienteData() {
        this.con = Conexion.getConectar();
    }

    //metodo insertar paciente como parametro un objecto
    public void insertarPaciente(Paciente paciente) {
        String sql = "Insert into pacientes (fecAltaPaci,apellidoPaci,nombresPaci,domicilioPaci,dniPaci,telefonoPaci,correoPaci,sexoPaci,estadoPaci) values (?,?,?,?,?,?,?,?,1)";
        try {
            //Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(paciente.getFecAltaPaci()));
            ps.setString(2, paciente.getApellidoPaci());
            ps.setString(3, paciente.getNombresPaci());
            ps.setString(4, paciente.getDomicilioPaci());
            ps.setString(5, paciente.getDniPaci());
            ps.setString(6, paciente.getTelefonoPaci());
            ps.setString(7, paciente.getCorreoPaci());
            ps.setString(8, paciente.getSexoPaci());
            ps.executeUpdate(); //Ejecuto la consulta
            ps.close(); //cierro la conexion
            JOptionPane.showMessageDialog(null, "Paciente cargado con éxito...");
        } catch (SQLException ex) {
            //Logger.getLogger(PacienteData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al cargar el paciente..." + ex.getMessage());
        }
    }

    //metodo editar paciente como parametro un objecto
    public void editarPaciente(Paciente paciente) {
        String sql = "Update pacientes set apellidoPaci=?,nombresPaci=?,domicilioPaci=?,dniPaci=?,telefonoPaci=?,correoPaci=?,sexoPaci=? where idPaci=?";
        try {
            //Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getApellidoPaci());
            ps.setString(2, paciente.getNombresPaci());
            ps.setString(3, paciente.getDomicilioPaci());
            ps.setString(4, paciente.getDniPaci());
            ps.setString(5, paciente.getTelefonoPaci());
            ps.setString(6, paciente.getCorreoPaci());
            ps.setString(7, paciente.getSexoPaci());
            ps.setInt(8, paciente.getIdPaci());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Paciente editado con éxito...");
        } catch (SQLException ex) {
            //Logger.getLogger(PacienteData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar el paciente..." + ex.getMessage());
        }
    }

    //metodo listar pacientes activos
    public List<Paciente> listarPaci() {
        Paciente paciente = null;
        ObservableList<Paciente> listPaci = FXCollections.observableArrayList();
        String sql = "Select * from pacientes where estadoPaci=1";
        try {
            //Preparoi la consulta
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaci(rs.getInt("idPaci"));
                paciente.setFecAltaPaci(rs.getDate("fecAltaPaci").toLocalDate());
                paciente.setApellidoPaci(rs.getString("apellidoPaci"));
                paciente.setNombresPaci(rs.getString("nombresPaci"));
                paciente.setDomicilioPaci(rs.getString("domicilioPaci"));
                paciente.setDniPaci(rs.getString("dniPaci"));
                paciente.setTelefonoPaci(rs.getString("TelefonoPaci"));
                paciente.setCorreoPaci(rs.getString("correoPaci"));
                paciente.setSexoPaci(rs.getString("sexoPaci"));
                listPaci.add(paciente);
            }
            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(PacienteData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al listar los pacientes..." + ex.getMessage());
        }
        return listPaci;
    }

    //metodo buscar por id
    public Paciente buscarPorId(int vId) {
        Paciente p = null;
        String sql = "Select * from pacientes where estadoPaci=1 and idPaci=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, vId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Paciente();
                p.setIdPaci(rs.getInt("idPaci"));
                p.setFecAltaPaci(rs.getDate("fecAltaPaci").toLocalDate());
                p.setApellidoPaci(rs.getString("apellidoPaci"));
                p.setNombresPaci(rs.getString("nombresPaci"));
                p.setDomicilioPaci(rs.getString("domicilioPaci"));
                p.setDniPaci(rs.getString("dniPaci"));
                p.setTelefonoPaci(rs.getString("telefonoPaci"));
                p.setCorreoPaci(rs.getString("correoPaci"));
                p.setSexoPaci(rs.getString("sexoPaci"));
                p.isEstadoPaci();
            }
            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(HistoriaClinicaData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al buscar Paciente por id..." + ex.getMessage());
        }
        return p;
    }

}
