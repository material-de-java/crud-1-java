package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    private queryMIO() throws Exception{
            con = new Connect();
            cn = con.conexion();
    }
    
    // uso del patron Singlenton
    public static queryMIO getInstance() throws Exception{
        if (instance==null){
            instance = new queryMIO();
        }
        
        return instance;
    }
    
    public ResultSet executeQuery(String var) throws SQLException{
        
        ResultSet rs=null;

        PreparedStatement ps = null;
        String consulta="CALL SelectEmpleados(?)";
        //System.out.println("SQl: "+consulta);
        
        ps = cn.prepareCall(consulta);
        ps.setString(1,var);
        rs = ps.executeQuery();            

        return rs;
    }

    public PreparedStatement prepareCall(String var1, String var2, String var3, String var4) {
        
        //String consulta = "INSERT INTO empleados (nombre,apellido,direccion,telefono) VALUES (?,?,?,?)";
        String consulta = "CALL InsertEmpleados(?,?,?,?)";
        PreparedStatement ps = null;
        
        try  {
            
            ps = cn.prepareCall(consulta);
            
            ps.setString(1,var1);
            ps.setString(2, var2);
            ps.setString(3, var3);
            ps.setString(4, var4);
            
            ps.executeUpdate();
        
        } catch (SQLException ex) {
            
            System.err.println("Error al guardar!..."+ex);
        }
        
        return ps;
    }

    public int prepareCall(String var1, String var2, String var3, String var4, String idin) {
        
        //String consulta = "UPDATE empleados SET nombre=?,apellido=?,direccion=?,telefono=? WHERE id=?";
        String consulta = "CALL UpdateEmpleados(?,?,?,?,?)";
        PreparedStatement ps = null;
        int result = 0;
        
        try  {
            
            ps = cn.prepareCall(consulta);
            
            ps.setString(1,var1);
            ps.setString(2, var2);
            ps.setString(3, var3);
            ps.setString(4, var4);
            ps.setString(5, idin);
            
            result = ps.executeUpdate();
        
        } catch (SQLException ex) {
            
            System.err.println("Error al guardar!..."+ex);
        }
        
        return result;
    }    

    public int prepareCall(String var1) {
        
        //String consulta = "DELETE FROM empleados WHERE id=?";
        String consulta = "CALL DeleteEmpleados(?);";
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
