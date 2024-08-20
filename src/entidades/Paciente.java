package entidades;

import java.time.LocalDate;

public class Paciente {

    //atributos
    private int idPaci;             //campo principal y autoincrementable
    private LocalDate fecAltaPaci;  //toma la fecha en que se carga al sistema
    private String apellidoPaci;
    private String nombresPaci;
    private String domicilioPaci;
    private String dniPaci;
    private String telefonoPaci;
    private String correoPaci;
    private String sexoPaci;
    private boolean estadoPaci;

    //constructor
    public Paciente() {
    }

    public Paciente(int idPaci, LocalDate fecAltaPaci, String apellidoPaci, String nombresPaci, String domicilioPaci, String dniPaci, String telefonoPaci, String correoPaci, String sexoPaci, boolean estadoPaci) {
        this.idPaci = idPaci;
        this.fecAltaPaci = fecAltaPaci;
        this.apellidoPaci = apellidoPaci;
        this.nombresPaci = nombresPaci;
        this.domicilioPaci = domicilioPaci;
        this.dniPaci = dniPaci;
        this.telefonoPaci = telefonoPaci;
        this.correoPaci = correoPaci;
        this.sexoPaci = sexoPaci;
        this.estadoPaci = estadoPaci;
    }

    
    //constructor para la edicion de paciente la fecha de alta del paciente no se modifica
    public Paciente(int idPaci,String apellidoPaci, String nombresPaci, String domicilioPaci, String dniPaci, String telefonoPaci, String correoPaci, String sexoPaci, boolean estadoPaci) {
        this.idPaci = idPaci;
        //this.fecAltaPaci = fecAltaPaci;
        this.apellidoPaci = apellidoPaci;
        this.nombresPaci = nombresPaci;
        this.domicilioPaci = domicilioPaci;
        this.dniPaci = dniPaci;
        this.telefonoPaci = telefonoPaci;
        this.correoPaci = correoPaci;
        this.sexoPaci = sexoPaci;
        this.estadoPaci = estadoPaci;
    }

    //constructor para el alta de paciente
    public Paciente(LocalDate fecAltaPaci,String apellidoPaci, String nombresPaci, String domicilioPaci, String dniPaci, String telefonoPaci, String correoPaci, String sexoPaci, boolean estadoPaci) {
        this.fecAltaPaci = fecAltaPaci;
        this.apellidoPaci = apellidoPaci;
        this.nombresPaci = nombresPaci;
        this.domicilioPaci = domicilioPaci;
        this.dniPaci = dniPaci;
        this.telefonoPaci = telefonoPaci;
        this.correoPaci = correoPaci;
        this.sexoPaci = sexoPaci;
        this.estadoPaci = estadoPaci;
    }
    
    

    public int getIdPaci() {
        return idPaci;
    }

    public void setIdPaci(int idPaci) {
        this.idPaci = idPaci;
    }

    public LocalDate getFecAltaPaci() {
        return fecAltaPaci;
    }

    public void setFecAltaPaci(LocalDate fecAltaPaci) {
        this.fecAltaPaci = fecAltaPaci;
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

    public String getDomicilioPaci() {
        return domicilioPaci;
    }

    public void setDomicilioPaci(String domicilioPaci) {
        this.domicilioPaci = domicilioPaci;
    }

    public String getDniPaci() {
        return dniPaci;
    }

    public void setDniPaci(String dniPaci) {
        this.dniPaci = dniPaci;
    }

    public String getTelefonoPaci() {
        return telefonoPaci;
    }

    public void setTelefonoPaci(String telefonoPaci) {
        this.telefonoPaci = telefonoPaci;
    }

    public String getCorreoPaci() {
        return correoPaci;
    }

    public void setCorreoPaci(String correoPaci) {
        this.correoPaci = correoPaci;
    }

    public String getSexoPaci() {
        return sexoPaci;
    }

    public void setSexoPaci(String sexoPaci) {
        this.sexoPaci = sexoPaci;
    }

    public boolean isEstadoPaci() {
        return estadoPaci;
    }

    public void setEstadoPaci(boolean estadoPaci) {
        this.estadoPaci = estadoPaci;
    }

    @Override
    public String toString() {
        return idPaci + " - " + fecAltaPaci + " - " + apellidoPaci + " - " + nombresPaci + " - " + domicilioPaci + " - " + dniPaci + " - " + telefonoPaci + " - " + correoPaci + " - " + sexoPaci;
    }
    

}
