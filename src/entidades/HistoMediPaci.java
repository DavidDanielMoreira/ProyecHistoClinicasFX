/*
 Es una clase que contiene datos de las tres clases: Paciente,Medico,HistoriaClinica 
 que se utiliza para mostrar los datos en un tableView
 */
package entidades;

import java.time.LocalDate;


public class HistoMediPaci {
    private int idHisto;            //clase HistoriaClinica
    private LocalDate fecAltaHisto; //clase HistoriaClinica
    private String historiaClinica; //es el DNI del paciente
    private int idPaci;             //clase Paciente
    private String apellidoPaci;    //clase Paciente
    private String nombresPaci;     //clase Paciente
    private int idMedi;             //clase Medico;
    private String tratHisto;      //clase HistoriaClinica
    private LocalDate fecUlt;       //clase HistoriaClinica
    //constructor
    public HistoMediPaci(){}

    public HistoMediPaci(int idHisto, LocalDate fecAltaHisto, String historiaClinica, int idPaci, String apellidoPaci, String nombresPaci, int idMedi, String tratHisto, LocalDate fecUlt) {
        this.idHisto = idHisto;
        this.fecAltaHisto = fecAltaHisto;
        this.historiaClinica = historiaClinica;
        this.idPaci = idPaci;
        this.apellidoPaci = apellidoPaci;
        this.nombresPaci = nombresPaci;
        this.idMedi = idMedi;
        this.tratHisto = tratHisto;
        this.fecUlt = fecUlt;
    }
    //metodos getter y setter

    public int getIdHisto() {
        return idHisto;
    }

    public void setIdHisto(int idHisto) {
        this.idHisto = idHisto;
    }

    public LocalDate getFecAltaHisto() {
        return fecAltaHisto;
    }

    public void setFecAltaHisto(LocalDate fecAltaHisto) {
        this.fecAltaHisto = fecAltaHisto;
    }

    public String getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(String historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public int getIdPaci() {
        return idPaci;
    }

    public void setIdPaci(int idPaci) {
        this.idPaci = idPaci;
    }

    public String getApellidoPaci() {
        return apellidoPaci;
    }

    public void setApellidoPaci(String apellidoPaci) {
        this.apellidoPaci = apellidoPaci;
    }

    public String getNombresPaci() {
        return nombresPaci;
    }

    public void setNombresPaci(String nombresPaci) {
        this.nombresPaci = nombresPaci;
    }

    public int getIdMedi() {
        return idMedi;
    }

    public void setIdMedi(int idMedi) {
        this.idMedi = idMedi;
    }

    public String getTratHisto() {
        return tratHisto;
    }

    public void setTratMhisto(String tratHisto) {
        this.tratHisto = tratHisto;
    }

    public LocalDate getFecUlt() {
        return fecUlt;
    }

    public void setFecUlt(LocalDate fecUlt) {
        this.fecUlt = fecUlt;
    }

    @Override
    public String toString() {
        return idHisto + " - " + fecAltaHisto + " - " + historiaClinica + " - " + idPaci + " - " + apellidoPaci + " - " + nombresPaci + " - " + idMedi + " - " + tratHisto + " - " + fecUlt + '}';
    }
    
    
    
}
