/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author manu
 */
public class Connect {
    
    Connection cn;    
    
    public Connection conexion(){
        
        System.out.println("Clase connect");
        try {
                cn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/db1","user","user");
                
                System.out.println("Connected");
                
        } catch (Exception e) {
            
            System.err.println("ERROR EN LA CONEXIÓN! - "+e);
        }
        
        return cn;
    }
    
}
