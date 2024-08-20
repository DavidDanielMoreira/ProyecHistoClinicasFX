/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class VistaMenuPrincipalController implements Initializable {

    @FXML
    private MenuItem miPaci;
    @FXML
    private MenuItem miMedi;
    @FXML
    private MenuItem miHisto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void eventAbrirPaci(ActionEvent event) {
        abrirVistaPacientes();
    }

    @FXML
    private void eventAbrirMedi(ActionEvent event) {
         abrirVistaMedicos();
    }

    @FXML
    private void eventAbrirHisto(ActionEvent event) {
        abrirVistaHistoClinicas();
    }

   
    
    
    //metdo abrir vista Medicos
    private void abrirVistaMedicos(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/vistaMedicos.fxml"));
            Scene scene = new Scene(root);
            Stage vMedicos = new Stage();
            vMedicos.setScene(scene);
            vMedicos.show();
            vMedicos.setTitle("Formulario Médicos:");
        } catch (IOException ex) {
            //Logger.getLogger(VistaMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al cargar la vista Médicos..." +ex.getMessage());
        }
    }
    
    //metodo abrir vista Pacientes
    private void abrirVistaPacientes(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/vistaPacientes.fxml"));
            Scene scene = new Scene(root);
            Stage vPacientes = new Stage();
            vPacientes.setScene(scene);
            vPacientes.show();
            vPacientes.setTitle("Formulario Pacientes:");
        } catch (IOException ex) {
            //Logger.getLogger(VistaMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Error al cargar la vista Pacientes..." +ex.getMessage());
        }
    }
    
    //metodo abrir vista Historia Clinicas
    private void abrirVistaHistoClinicas(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/vistaHistoClinicas.fxml"));
            Scene scene = new Scene(root);
            Stage vHisto = new Stage();
            vHisto.setScene(scene);
            vHisto.show();
            vHisto.setTitle("Formulario Historia Clinicas");
        } catch (IOException ex) {
            //Logger.getLogger(VistaMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null, "Error al cargar la vista Historia Clinicas..." +ex.getMessage());
        }
    }
    
    
    
    
}
