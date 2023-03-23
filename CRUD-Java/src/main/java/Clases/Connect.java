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
    String host = "jdbc:mysql://localhost/db1";
    String user = "user";
    
    public Connection conexion(){
        try {
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection(host,user,"");
                
                System.out.println("Connected");
                
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return cn;
    }
    
}
