
package accesoADatos;

import entidades.*;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
public class HistoMediPaciData {
    //atributos
    private Connection con;
    private PacienteData pData = new PacienteData();
    private MedicoData mData = new MedicoData();
    private Paciente pSelec;
    private Medico mSelec;
    //constructor
    public HistoMediPaciData(){
        this.con = Conexion.getConectar();
    }
    
    //metodo listar las Historia Clinicas activas
    public List<HistoMediPaci> listarHistoClinicas(){
        HistoMediPaci hmp = null;
        ObservableList<HistoMediPaci> listHisto = FXCollections.observableArrayList();
        String sql = "Select hc.idHisto,hc.fecAltaHisto,hc.historiaClinica,p.idPaci,p.apellidoPaci,p.nombresPaci,m.idMedi,hc.tratHisto,hc.fecUlt from h_clinicas hc inner join pacientes p on hc.idPaci=p.idPaci inner join medicos m on hc.idMedi=m.idMedi where hc.estadoHisto=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                hmp = new HistoMediPaci();
                hmp.setIdHisto(rs.getInt("idHisto"));
                hmp.setFecAltaHisto(rs.getDate("fecAltaHisto").toLocalDate());
                hmp.setHistoriaClinica(rs.getString("historiaClinica"));
                //busco los datos del paciente
                pSelec = pData.buscarPorId(rs.getInt("idPaci"));
                hmp.setIdPaci(pSelec.getIdPaci());
                hmp.setApellidoPaci(pSelec.getApellidoPaci());
                hmp.setNombresPaci(pSelec.getNombresPaci());
                //busco datos del medico
                mSelec = mData.buscarPorId(rs.getInt("idMedi"));
                hmp.setIdMedi(mSelec.getIdMedi());
                hmp.setTratMhisto(rs.getString("tratHisto"));
                hmp.setFecUlt(rs.getDate("fecUlt").toLocalDate());
                listHisto.add(hmp);
            }
            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(HistoMediPaciData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al listar las historia clinicas..." +ex.getMessage());
        }
        return listHisto;
    }
}
