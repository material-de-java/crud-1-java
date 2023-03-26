/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author manu
 */
public class Connect {
    
    Connection cn=null;    
    protected static final String PING_MARKER = "/* ping */";
    
    public Connection conexion() throws Exception{

        // con el driver de mariadb no hace el delete
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","user","user");

        Statement stmt = cn.createStatement();
        stmt.executeQuery(PING_MARKER);

        System.out.println("Connected");

        if(cn==null){
            throw new Exception("*** ERROR REALIZANDO CONEXIÓN ***");
        }
        
        return cn;
    }
    
}
