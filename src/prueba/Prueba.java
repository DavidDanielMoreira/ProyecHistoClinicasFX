/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import entidades.*;
import accesoADatos.*;
import java.sql.*;
import java.time.LocalDate;
public class Prueba {
    private static Connection con;
    private PacienteData pData = new PacienteData();
    private HistoMediPaciData hmpData = new HistoMediPaciData();
    public static void main(String[] args){
        LocalDate vFecha = LocalDate.now();
        //con = Conexion.getConectar();
        Prueba prueba = new Prueba();
        //creo el objecto
        //Paciente paciente = new Paciente(1,"Moreira","David","Salta 528","25724439","3400658999","cccc@gggg","M",true);
        prueba.getPrueba();
    }
    
    //creo el metodo para hacer pruebas
    public void getPrueba(){
        //pData.insertarPaciente(p);
        //pData.editarPaciente(p);
        //System.out.println( pData.listarPaci());
        //System.out.println(pData.buscarPorId(vId));
        System.out.println(hmpData.listarHistoClinicas());
                
    }
}
