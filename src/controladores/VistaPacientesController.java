package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import entidades.*;
import accesoADatos.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class VistaPacientesController implements Initializable {

    private PacienteData pData = new PacienteData();
    ObservableList<Paciente> listaPaci;    //almacena los pacientes cargados 
    ObservableList<Paciente> filtroPorDni; // filtra los datos por DNI
    LocalDate vFecha = LocalDate.now();   //guarda la fecha actual 
    String vSexo;       //guarda el genero seleccionado del combo
    boolean altas = false;
    boolean editar = false;
    boolean exportar = false;
    //declaro una variable tipo VistaHistoClinicasController
    private VistaHistoClinicasController vistaHistoClinicasController;

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtApe;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtDom;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtCor;
    @FXML
    private ComboBox<String> cmbSexo;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnBajas;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnExportar;
    @FXML
    private TableView<Paciente> tblPacientes;
    @FXML
    private TableColumn<Paciente, Integer> colId;
    @FXML
    private TableColumn<Paciente, LocalDate> colFec;
    @FXML
    private TableColumn<Paciente, String> colApe;
    @FXML
    private TableColumn<Paciente, String> colNom;
    @FXML
    private TableColumn<Paciente, String> colDom;
    @FXML
    private TableColumn<Paciente, String> colDni;
    @FXML
    private TableColumn<Paciente, String> colTel;
    @FXML
    private TableColumn<Paciente, String> colCor;
    @FXML
    private TableColumn<Paciente, String> colSex;
    @FXML
    private Button btnEditar;
    @FXML
    private TextField txtSex;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listaPaci = FXCollections.observableArrayList();
        filtroPorDni = FXCollections.observableArrayList();

        cargarCombo();
        cargarTabla();
        btnGuardar.setDisable(true);  //boton guardar inhabilitado
        //btnExportar.setDisable(true); //boton exportar inhabilitado
    }

    @FXML
    private void eventSelecSexo(ActionEvent event) {
        selecSexo();
    }

    @FXML
    private void eventNuevo(ActionEvent event) {
        altas = true;
        btnGuardar.setDisable(false);
        //btnBajas.setDisable(true);
        //btnEditar.setDisable(true);
        txtApe.requestFocus();
    }

    @FXML
    private void eventBajas(ActionEvent event) {
    }

    @FXML
    private void eventEditar(ActionEvent event) {
        editar = true;
        btnGuardar.setDisable(false);
        btnNuevo.setDisable(true);
        btnBajas.setDisable(true);
        btnEditar.setDisable(false);
    }

    @FXML
    private void eventCancelar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    private void eventBuscar(ActionEvent event) {
        txtId.setDisable(true);
        txtApe.setDisable(true);
        txtNom.setDisable(true);
        txtDom.setDisable(true);
        //txtDni.setDisable(true);
        txtTel.setDisable(true);
        txtCor.setDisable(true);
    }

    @FXML
    private void eventCerrar(ActionEvent event) {
        cerrarVentana();
    }

    @FXML
    private void eventGuardar(ActionEvent event) {
        if (!txtApe.getText().isEmpty() && !txtNom.getText().isEmpty() && !txtDni.getText().isEmpty()) {
            if (altas == true) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Altas Pacientes");
                alert.setContentText("¿Confirma el alta del registro?");
                alert.setHeaderText(null);
                Optional<ButtonType> opcion = alert.showAndWait();
                if (opcion.get() == ButtonType.OK) {
                    inserPaci();
                    limpiarCampos();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "No se concreto ningun altas de registro...");
                }
            }
            if (editar == true) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Editar Pacientes");
                alert.setContentText("¿Confirma la edicion del registro?");
                alert.setHeaderText(null);
                Optional<ButtonType> opcion = alert.showAndWait();
                if (opcion.get() == ButtonType.OK) {
                    editPaci();
                    limpiarCampos();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "No se concreto ninguna edicion de registro...");
                }
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia!!!");
            alert.setContentText("Faltan datos completar...");
            alert.setHeaderText("Advertencia de alerta");
            alert.showAndWait();
        }
    }

    @FXML
    private void eventExportar(ActionEvent event) {
        if (!txtId.getText().isEmpty() && !txtApe.getText().isEmpty() && !txtNom.getText().isEmpty() && exportar==true) {
            exporDatos();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje Exportar Datos");
            alert.setContentText("No se puede concretar la exportación");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @FXML
    private void eventSelecFila(MouseEvent event) {
        selecFilaTabla();
    }

    @FXML
    private void eventBuscarPorDni(KeyEvent event) {
        buscarPorDni();
    }

    public void setVistaHistoClinicasController(VistaHistoClinicasController vistaHistoClinicasController) {
        this.vistaHistoClinicasController = vistaHistoClinicasController;
    }

    //metodo cargar combo
    private void cargarCombo() {
        cmbSexo.getItems().add("-");
        cmbSexo.getItems().add("M");
        cmbSexo.getItems().add("F");
    }

    //metodo cargar tabla
    private void cargarTabla() {
        //añado los campos de la base de datos a las columnas de la tabla
        this.colId.setCellValueFactory(new PropertyValueFactory("idPaci"));
        this.colFec.setCellValueFactory(new PropertyValueFactory("fecAltaPaci"));
        this.colApe.setCellValueFactory(new PropertyValueFactory("apellidoPaci"));
        this.colNom.setCellValueFactory(new PropertyValueFactory("nombresPaci"));
        this.colDom.setCellValueFactory(new PropertyValueFactory("domicilioPaci"));
        this.colDni.setCellValueFactory(new PropertyValueFactory("dniPaci"));
        this.colTel.setCellValueFactory(new PropertyValueFactory("telefonoPaci"));
        this.colCor.setCellValueFactory(new PropertyValueFactory("correoPaci"));
        this.colSex.setCellValueFactory(new PropertyValueFactory("sexoPaci"));

        listaPaci = (ObservableList) pData.listarPaci();
        if (!listaPaci.isEmpty()) {
            tblPacientes.setItems(listaPaci);
        }
    }

    //metodo insertar Paciente a traves de objectos
    private void inserPaci() {
        if (vSexo == null) {
            vSexo = "-";
        }
        String vApe = txtApe.getText().toString();
        String vNom = txtNom.getText().toString();
        String vDom = txtDom.getText().toString();
        String vDni = txtDni.getText().toString();
        String vTel = txtTel.getText().toString();
        String vCor = txtCor.getText().toString();
        //creo el objecto
        Paciente paciente = new Paciente(vFecha, vApe, vNom, vDom, vDni, vTel, vCor, vSexo, true);
        pData.insertarPaciente(paciente);

    }

    //metodo editar Paciente a traves de  Objecto
    private void editPaci() {
        int vId = Integer.parseInt(txtId.getText());
        String vApe = txtApe.getText().toString();
        String vNom = txtNom.getText().toString();
        String vDom = txtDom.getText().toString();
        String vDni = txtDni.getText().toString();
        String vTel = txtTel.getText().toString();
        String vCor = txtCor.getText().toString();
        //creo el objecto
        Paciente paciente = new Paciente(vId, vApe, vNom, vDom, vDni, vTel, vCor, vSexo, true);
        pData.editarPaciente(paciente);

    }

    //metodo seleccionar una fila de la tabla
    private void selecFilaTabla() {
        int fSelec = tblPacientes.getSelectionModel().getSelectedIndex();
        if (fSelec != -1) {
            txtId.setText(String.valueOf(colId.getCellData(fSelec).toString()));
            txtApe.setText(colApe.getCellData(fSelec).toString());
            txtNom.setText(colNom.getCellData(fSelec).toString());
            txtDom.setText(colDom.getCellData(fSelec).toString());
            txtDni.setText(colDni.getCellData(fSelec).toString());
            txtTel.setText(colTel.getCellData(fSelec).toString());
            txtCor.setText(colCor.getCellData(fSelec).toString());
            txtSex.setText(colSex.getCellData(fSelec).toString());

        }
    }

    //metodo buscar por DNI
    private void buscarPorDni() {
        String vDni = txtDni.getText().toString();
        if (vDni.isEmpty()) {
            this.tblPacientes.setItems(listaPaci);
        } else {
            this.filtroPorDni.clear();
            for (Paciente p : this.listaPaci) {
                if (p.getDniPaci().contains(vDni)) {
                    this.filtroPorDni.setAll(p);
                }
            }
            this.tblPacientes.setItems(filtroPorDni);
        }

    }

    //metodo seleccionar genero
    private void selecSexo() {
        vSexo = cmbSexo.getSelectionModel().getSelectedItem();
    }

    //metodo exportar datos paciente a historia clinica a traves de un objecto tipo Paciente
    private void exporDatos() {
            int vId = Integer.parseInt(txtId.getText());
            String vDni = txtDni.getText();
            String vApe = txtApe.getText();
            String vNom = txtNom.getText();
            String vDom = txtDom.getText();
            String vTel = txtTel.getText();
            String vCor = txtCor.getText();
            String vSex = txtSex.getText();
            //creo el objecto
            Paciente p = new Paciente(vId, vApe, vNom, vDom, vDni, vTel, vCor, vSex, true);
            vistaHistoClinicasController.recibirDatosPaciente(p);
            //cierro la vista pacientes
            /*
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
             */              
    }

    //metodo limpiar campos
    private void limpiarCampos() {
        txtId.setText("");
        txtApe.setText("");
        txtNom.setText("");
        txtDni.setText("");
        txtDom.setText("");
        txtTel.setText("");
        txtCor.setText("");
        txtSex.setText("");
        cmbSexo.getSelectionModel().clearSelection();
        cargarTabla();
        btnGuardar.setDisable(true);
    }

    //metodo cerrar ventana
    private void cerrarVentana() {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

}
