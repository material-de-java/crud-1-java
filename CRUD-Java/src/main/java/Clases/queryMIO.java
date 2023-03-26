package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manu
 */
public final class queryMIO {
    
    private static queryMIO instance;
    public String consulta;
    public Connect con;
    public Connection cn;
    
    private queryMIO(){
            con = new Connect();
            cn = con.conexion();
    }
    
    public static queryMIO getInstance(){
        if (instance==null){
            instance = new queryMIO();
        }
        
        return instance;
    }
    
    public Statement createStatement() {
        Statement st=null;
        
        try {
            st = cn.createStatement();
        } catch (SQLException ex) {
            System.err.println("Error al mostrar los datos!"+ex);
        }
        
        return st;
    }

    public PreparedStatement prepareCall(String consulta, String var1, String var2, String var3, String var4) {
        
        PreparedStatement ps = null;
        
        try  {
            
            ps = cn.prepareCall(consulta);
            
            ps.setString(1,var1 );
            ps.setString(2, var2);
            ps.setString(3, var3);
            ps.setString(4, var4);
            
            ps.executeUpdate();
        
        } catch (SQLException ex) {
            
            System.err.println("Error al guardar!..."+ex);
        }
        
        return ps;
    }

    public int prepareCall(String consulta, String var1, String var2, String var3, String var4, String var5) {
        
        PreparedStatement ps = null;
        int result = 0;
        
        try  {
            
            ps = cn.prepareCall(consulta);
            
            ps.setString(1,var1);
            ps.setString(2, var2);
            ps.setString(3, var3);
            ps.setString(4, var4);
            ps.setString(5, var5);
            
            result = ps.executeUpdate();
        
        } catch (SQLException ex) {
            
            System.err.println("Error al guardar!..."+ex);
        }
        
        return result;
    }    

    public int prepareCall(String consulta, String var1) {
                PreparedStatement ps = null;
        int result = 0;
        
        try  {
            
            ps = cn.prepareCall(consulta);
            
            ps.setString(1,var1);
            
            result = ps.executeUpdate();
        
        } catch (SQLException ex) {
            
            System.err.println("Error al guardar!..."+ex);
        }
        
        return result;
    }
    
    
}
