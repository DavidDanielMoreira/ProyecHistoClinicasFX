package accesoADatos;

import entidades.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class HistoriaClinicaData {

    //atributos
    private Connection con;

    //constructor
    public HistoriaClinicaData() {
        this.con = Conexion.getConectar();
    }

    //metodo insetar HistoriaClinica a traves de parametro objecto
    public void insertarHistoClinica(HistoriaClinica hClinica) {
        String sql = "Insert into h_clinicas (fecAltaHisto,historiaClinica,idPaci,idMedi,tratHisto,fecUlt,estadoHisto) values (?,?,?,?,?,?,1)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(hClinica.getFecAltaHisto()));
            ps.setString(2, hClinica.getHistoriaClinica());
            ps.setInt(3, hClinica.getPaciente().getIdPaci());
            ps.setInt(4, hClinica.getMedico().getIdMedi());
            ps.setString(5, hClinica.getTratHisto());
            ps.setDate(6, Date.valueOf(hClinica.getFecUlt()));
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro cargado con exito...");
        } catch (SQLException ex) {
            //Logger.getLogger(HistoriaClinicaData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al concretar el alta de historia clinica..." + ex.getMessage());
        }

    }
    
    //metodo editar Historia clinica a traves de objecto
    public void editarHistoClinica(HistoriaClinica hClinica){
        String sql = "Update h_clinicas set fecAltaHisto=?,historiaClinica=?,idPaci=?,idMedi=?,tratHisto=?,fecUlt=? where idHisto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(hClinica.getFecAltaHisto()));
            ps.setString(2, hClinica.getHistoriaClinica());
            ps.setInt(3, hClinica.getPaciente().getIdPaci());
            ps.setInt(4, hClinica.getMedico().getIdMedi());
            ps.setString(5, hClinica.getTratHisto());
            ps.setDate(6, Date.valueOf(hClinica.getFecUlt()));
            ps.setInt(7, hClinica.getIdHisto());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro editado con exito...");
        } catch (SQLException ex) {
            //Logger.getLogger(HistoriaClinicaData.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Error al concretar la edición de la  historia clinica..." + ex.getMessage());
        }
    }
    
    //metodo listar las Historia Clinicas activas
    

}
