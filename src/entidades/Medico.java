
package entidades;


public class Medico {
    //atributos
    private int IdMedi;         //campo principal y autoincrementable
    private String apellidoMedi;
    private String nombresMedi;
    private String domicilioMedi;
    private String dniMedi;
    private String nroMatriculaMedi;
    private String telefonoMedi;
    private String especialidadMedi;
    //constructor
    public  Medico(){}

    public Medico(int IdMedi, String apellidoMedi, String nombresMedi, String domicilioMedi, String dniMedi, String nroMatriculaMedi, String telefonoMedi, String especialidadMedi) {
        this.IdMedi = IdMedi;
        this.apellidoMedi = apellidoMedi;
        this.nombresMedi = nombresMedi;
        this.domicilioMedi = domicilioMedi;
        this.dniMedi = dniMedi;
        this.nroMatriculaMedi = nroMatriculaMedi;
        this.telefonoMedi = telefonoMedi;
        this.especialidadMedi = especialidadMedi;
    }

    public Medico(String apellidoMedi, String nombresMedi, String domicilioMedi, String dniMedi, String nroMatriculaMedi, String telefonoMedi, String especialidadMedi) {
        this.apellidoMedi = apellidoMedi;
        this.nombresMedi = nombresMedi;
        this.domicilioMedi = domicilioMedi;
        this.dniMedi = dniMedi;
        this.nroMatriculaMedi = nroMatriculaMedi;
        this.telefonoMedi = telefonoMedi;
        this.especialidadMedi = especialidadMedi;
    }
    //metodos getter y setter

    public int getIdMedi() {
        return IdMedi;
    }

    public void setIdMedi(int IdMedi) {
        this.IdMedi = IdMedi;
    }

    public String getApellidoMedi() {
        return apellidoMedi;
    }

    public void setApellidoMedi(String apellidoMedi) {
        this.apellidoMedi = apellidoMedi;
    }

    public String getNombresMedi() {
        return nombresMedi;
    }

    public void setNombresMedi(String nombresMedi) {
        this.nombresMedi = nombresMedi;
    }

    public String getDomicilioMedi() {
        return domicilioMedi;
    }

    public void setDomicilioMedi(String domicilioMedi) {
        this.domicilioMedi = domicilioMedi;
    }

    public String getDniMedi() {
        return dniMedi;
    }

    public void setDniMedi(String dniMedi) {
        this.dniMedi = dniMedi;
    }

    public String getNroMatriculaMedi() {
        return nroMatriculaMedi;
    }

    public void setNroMatriculaMedi(String nroMatriculaMedi) {
        this.nroMatriculaMedi = nroMatriculaMedi;
    }

    public String getTelefonoMedi() {
        return telefonoMedi;
    }

    public void setTelefonoMedi(String telefonoMedi) {
        this.telefonoMedi = telefonoMedi;
    }

    public String getEspecialidadMedi() {
        return especialidadMedi;
    }

    public void setEspecialidadMedi(String especialidadMedi) {
        this.especialidadMedi = especialidadMedi;
    }

    @Override
    public String toString() {
        return IdMedi + " - " + apellidoMedi + " - " + nombresMedi + " - " + domicilioMedi + " - " + dniMedi + " - " + nroMatriculaMedi + " - " + telefonoMedi + " - " + especialidadMedi;
    }
    
    
}
