package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import entidades.*;
import accesoADatos.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import entidades.*;
import accesoADatos.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class VistaHistoClinicasController implements Initializable {

    private MedicoData mData = new MedicoData();
    private Medico mSelec;
    private PacienteData pData = new PacienteData();
    private Paciente pSelec;
    private HistoriaClinicaData hcData = new HistoriaClinicaData();
    private HistoMediPaciData hmpData = new HistoMediPaciData();
    private ObservableList<HistoMediPaci> vListarHisto;
    private ObservableList<HistoMediPaci> filPorNombre;
    private LocalDate vFechaAlta;       //guarda la fecha de alta de la Historia clinica seleccionada de la tabla
    private boolean altas = false;
    private LocalDate vFecha = LocalDate.now();
    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String fechForma = vFecha.format(forma);

    @FXML
    private TextField txtDniPaci;
    @FXML
    private Label lblFecha;
    @FXML
    private TextField txtIdPaci;
    @FXML
    private TextField txtApePaci;
    @FXML
    private TextField txtNomPaci;
    @FXML
    private Button btnAbrirPacientes;
    @FXML
    private TextField txtHisto;
    @FXML
    private TextField txtApeMedi;
    @FXML
    private TextField txtIdHisto;
    @FXML
    private TextField txtIdMedi;
    @FXML
    private TableView<HistoMediPaci> tblHistoClinicas;
    @FXML
    private TableColumn<HistoMediPaci, Integer> colId;
    @FXML
    private TableColumn<HistoMediPaci, LocalDate> colFechAl;
    @FXML
    private TableColumn<HistoMediPaci, String> colHisto;
    @FXML
    private TableColumn<HistoMediPaci, Integer> colIdPaci;
    @FXML
    private TableColumn<HistoMediPaci, String> colApePaci;
    @FXML
    private TableColumn<HistoMediPaci, String> colNomPaci;
    @FXML
    private TableColumn<HistoMediPaci, Integer> colIdMedi;
    @FXML
    private TableColumn<HistoMediPaci, String> colTrat;
    @FXML
    private TableColumn<HistoMediPaci, LocalDate> colFechUlt;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnBajas;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextArea txtTratHisto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        vListarHisto = FXCollections.observableArrayList();
        filPorNombre = FXCollections.observableArrayList();
        btnGuardar.setDisable(true); //boton guardar inhabilitado
        cargarTabla();
        mostMedico();
        lblFecha.setText(fechForma); //muestra en el formulario la fecha en formato dd/MM/yyyy
    }

    @FXML
    private void eventAbrirPacientes(ActionEvent event) {
        abrirVistaPacientes();
    }

    @FXML
    private void eventNuevo(ActionEvent event) {
        altas = true;
        btnGuardar.setDisable(false);
    }

    @FXML
    private void eventBajas(ActionEvent event) {
    }

    @FXML
    private void eventEditar(ActionEvent event) {
        btnGuardar.setDisable(false);
    }

    @FXML
    private void eventCancelar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    private void eventBuscar(ActionEvent event) {
    }

    @FXML
    private void eventCerrar(ActionEvent event) {
        cerrarVentana();
    }

    @FXML
    private void eventGuardar(ActionEvent event) {
        if (!txtIdPaci.getText().isEmpty() && !txtIdMedi.getText().isEmpty() && !txtTratHisto.getText().isEmpty()) {
            if (altas == true) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Altas Historia Clinicas");
                alert.setContentText("¿Confirma el alta del registro?");
                alert.setHeaderText("");
                Optional<ButtonType> opcion = alert.showAndWait();
                if (opcion.get() == ButtonType.OK) {
                    insertHistoClinica();
                    cargarTabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se concreto ningun altas de registro");
                    limpiarCampos();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Edición Historia Clinicas");
                alert.setContentText("¿Confirma la edición del registro?");
                alert.setHeaderText("");
                Optional<ButtonType> opcion = alert.showAndWait();
                if (opcion.get() == ButtonType.OK) {
                    editHistoClinica();
                    cargarTabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se concreto ningun altas de registro");
                    limpiarCampos();
                }

            }
        } else {
            //JOptionPane.showMessageDialog(null, "Faltan datos completar...");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Faltan datos");
            alert.setContentText("Faltan datos completar...");
            alert.setHeaderText("");
            alert.showAndWait();
        }
    }

    @FXML
    private void eventSelecFila(MouseEvent event) {
        selecFila();
    }

    @FXML
    private void eventBuscarPorNombre(KeyEvent event) {
        buscarPorNombre();
    }

    //metodo abrir vista Paciente
    private void abrirVistaPacientes() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/vistaPacientes.fxml"));
        try {
            Parent root = loader.load();
            //instancio VistaPacientesController
            VistaPacientesController vistaPacientesController = loader.getController();
            //le paso el el controlador de la VistaHistoClinicas al controlador Pacientes
            vistaPacientesController.setVistaHistoClinicasController(this);
            Scene scene = new Scene(root);
            Stage vPacientes = new Stage();
            vPacientes.setScene(scene);
            vPacientes.show();
        } catch (IOException ex) {
            //Logger.getLogger(VistaHistoClinicasController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al cargar la vista Pacientes..." + ex.getMessage());
        }
    }

    //metodo recibir datos del paciente como parametro objecto
    public void recibirDatosPaciente(Paciente paciente) {

        txtIdPaci.setText(String.valueOf(paciente.getIdPaci()));
        txtDniPaci.setText(paciente.getDniPaci());
        txtApePaci.setText(paciente.getApellidoPaci());
        txtNomPaci.setText(paciente.getNombresPaci());

        //coloca el DNI en la caja de texto nombre de la historia clinica
        txtHisto.setText(paciente.getDniPaci());

        /*
       txtIdPaci.setText(String.valueOf(vIdPaci));
       txtDniPaci.setText(vDniPaci);
       txtApePaci.setText(vApePaci);
       txtNomPaci.setText(vNomPaci);
         */
    }

    //metodo insertar Historia Clinica
    private void insertHistoClinica() {

        String vHisto = txtHisto.getText();
        String vTrat = txtTratHisto.getText();
        //busco el Paciente
        int vIdPaci = Integer.parseInt(txtIdPaci.getText());
        pSelec = pData.buscarPorId(vIdPaci);
        //creo el objecto 
        HistoriaClinica hClinica = new HistoriaClinica(vFecha, vHisto, pSelec, mSelec, vTrat, vFecha, true);
        hcData.insertarHistoClinica(hClinica);
    }

    //metodo editar Historia Clinica
    private void editHistoClinica() {
        int vIdHisto = Integer.parseInt(txtIdHisto.getText());

        String vHisto = txtHisto.getText();
        String vTrat = txtTratHisto.getText();
        //busco el Paciente
        int vIdPaci = Integer.parseInt(txtIdPaci.getText());
        pSelec = pData.buscarPorId(vIdPaci);
        //creo el objecto 
        HistoriaClinica hClinica = new HistoriaClinica(vIdHisto, vFechaAlta, vHisto, pSelec, mSelec, vTrat, vFecha, true);
        hcData.editarHistoClinica(hClinica);
    }

    //metodo mostrar medico 
    private void mostMedico() {
        mSelec = mData.mostrarMedi();
        if (mSelec != null) {
            txtIdMedi.setText(String.valueOf(mSelec.getIdMedi()));
            txtApeMedi.setText(mSelec.getApellidoMedi());
        }
    }

    //metodo cargar tabla
    private void cargarTabla() {
        //añado a las columnas de la tabla los atributos de la clase
        this.colId.setCellValueFactory(new PropertyValueFactory("idHisto"));
        this.colFechAl.setCellValueFactory(new PropertyValueFactory("fecAltaHisto"));
        this.colHisto.setCellValueFactory(new PropertyValueFactory("historiaClinica"));
        this.colIdPaci.setCellValueFactory(new PropertyValueFactory("idPaci"));
        this.colApePaci.setCellValueFactory(new PropertyValueFactory("ApellidoPaci"));
        this.colNomPaci.setCellValueFactory(new PropertyValueFactory("nombresPaci"));
        this.colIdMedi.setCellValueFactory(new PropertyValueFactory("idMedi"));
        this.colTrat.setCellValueFactory(new PropertyValueFactory("tratHisto"));
        this.colFechUlt.setCellValueFactory(new PropertyValueFactory("fecUlt"));

        vListarHisto = (ObservableList) hmpData.listarHistoClinicas();
        if (!vListarHisto.isEmpty()) {
            tblHistoClinicas.setItems(vListarHisto);
        }

    }

    //metodo seleccionar fila
    private void selecFila() {
        int fSelec = tblHistoClinicas.getSelectionModel().getSelectedIndex();
        if (fSelec != -1) {
            int vIdHisto = this.colId.getCellData(fSelec);
            vFechaAlta = this.colFechAl.getCellData(fSelec);
            String vNomHisto = this.colHisto.getCellData(fSelec);
            int vIdPaci = this.colIdPaci.getCellData(fSelec);
            String vDniPaci = this.colHisto.getCellData(fSelec);
            String vApePaci = this.colApePaci.getCellData(fSelec);
            String vNomPaci = this.colNomPaci.getCellData(fSelec);
            int vIdMedi = this.colIdMedi.getCellData(fSelec);
            String vTrat = this.colTrat.getCellData(fSelec);

            txtIdHisto.setText(String.valueOf(vIdHisto));
            txtHisto.setText(vNomHisto);
            txtIdPaci.setText(String.valueOf(vIdPaci));
            //txtDniPaci.setText(vTrat);
            txtApePaci.setText(vApePaci);
            txtNomPaci.setText(vNomPaci);
            txtTratHisto.setText(vTrat);
        }
    }

    //metodo buscar Historia Clinica por nombre
    private void buscarPorNombre() {
        vListarHisto = (ObservableList) hmpData.listarHistoClinicas();
        String vNomHisto = txtHisto.getText();
        if (vNomHisto.isEmpty()) {
            tblHistoClinicas.setItems(vListarHisto);
        } else {
            filPorNombre.clear();
            for (HistoMediPaci hmp : vListarHisto) {
                if (hmp.getHistoriaClinica().contains(vNomHisto)) {
                    filPorNombre.add(hmp);
                }
            }

            tblHistoClinicas.setItems(filPorNombre);
        }
    }

    //metodo limpiar campos
    private void limpiarCampos() {
        txtIdPaci.setText("");
        txtDniPaci.setText("");
        txtDniPaci.setText("");
        txtApePaci.setText("");
        txtNomPaci.setText("");
        txtHisto.setText("");
        txtTratHisto.setText("");
        cargarTabla();
    }

    //metodo cerrar ventana
    private void cerrarVentana() {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

}