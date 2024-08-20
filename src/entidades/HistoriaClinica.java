
package entidades;

import java.time.LocalDate;


public class HistoriaClinica {
    //atributos
    private int idHisto;                //campo principay y autoincrementable
    private LocalDate fecAltaHisto;   //fecha en se carga por primera vez los datos del paciente
    private String historiaClinica;     //el dni del paciente
    private Paciente paciente;           // clase Paciente
    private Medico medico;               //clase Medico
    private String tratHisto;     
    private LocalDate fecUlt;           //fecha ultima visita del paciente
    private boolean estadoHisto;
    //constructor
    public HistoriaClinica(){}

    public HistoriaClinica(int idHisto,LocalDate fecAltaHisto, String historiaClinica, Paciente paciente, Medico medico, String tratHisto, LocalDate fecUlt, boolean estadoHisto) {
        this.idHisto = idHisto;
        this.fecAltaHisto = fecAltaHisto;
        this.historiaClinica = historiaClinica;
        this.paciente = paciente;
        this.medico = medico;
        this.tratHisto = tratHisto;
        this.fecUlt = fecUlt;
        this.estadoHisto = estadoHisto;
    }

    public HistoriaClinica(LocalDate fecAltaHisto, String historiaClinica, Paciente paciente, Medico medico, String tratHisto, LocalDate fecUlt, boolean estadoHisto) {
        this.fecAltaHisto = fecAltaHisto;
        this.historiaClinica = historiaClinica;
        this.paciente = paciente;
        this.medico = medico;
        this.tratHisto = tratHisto;
        this.fecUlt = fecUlt;
        this.estadoHisto = estadoHisto;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getTratHisto() {
        return tratHisto;
    }

    public void setTratHisto(String tratHisto) {
        this.tratHisto = tratHisto;
    }

    public LocalDate getFecUlt() {
        return fecUlt;
    }

    public void setFecUlt(LocalDate fecUlt) {
        this.fecUlt = fecUlt;
    }

    public boolean isEstadoHisto() {
        return estadoHisto;
    }

    public void setEstadoHisto(boolean estadoHisto) {
        this.estadoHisto = estadoHisto;
    }

    @Override
    public String toString() {
        return idHisto + " - " + fecAltaHisto + " - " + historiaClinica + " - " + paciente + " - " + medico + " - " + tratHisto + " - " + fecUlt;
    }
    
   
    
}
