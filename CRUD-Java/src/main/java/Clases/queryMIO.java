package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manu
 */
public class queryMIO {
    
    String consulta;
    Connect con;
    Connection cn;
    
    void queryMIO(){
            con = new Connect();
            cn = con.conexion();
    }
    
    void insertToEmpleados(String nombres,String apellidos,String direccion,String telefono){
                try {
            
            consulta = "INSERT INTO empleados (nombre,apellido,direccion,telefono) VALUES (?,?,?,?)";
            PreparedStatement ps=cn.prepareCall(consulta);
            
            ps.setString(1, nombres.getText());
            ps.setString(2, apellidos.getText());
            ps.setString(3, direccion.getText());
            ps.setString(4, telefono.getText());
            
            ps.executeUpdate();
                     
            JOptionPane.showMessageDialog(null,"Datos guardados!");
        } catch (SQLException e) {
            System.err.println("Error al guardar!..."+e);
            JOptionPane.showMessageDialog(null,"Error al guardar!");
        }
    }  
    }
    
    
}
