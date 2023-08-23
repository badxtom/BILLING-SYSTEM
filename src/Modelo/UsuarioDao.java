/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Luz
 */
public class UsuarioDao {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
         public List ListarUsuario(){
       List<Usuario> ListaUs = new ArrayList();
       String sql = "SELECT * FROM usuarios";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Usuario us = new Usuario();
               us.setId(rs.getInt("id"));
               us.setNombre(rs.getString("nombre"));
               us.setCorreo(rs.getString("correo"));
               us.setPass(rs.getString("pass"));
               us.setRol(rs.getString("rol"));
               ListaUs.add(us);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaUs;
   }
             public boolean EliminarUsuario(int id){
       String sql = "DELETE FROM usuarios WHERE id = ?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println(ex.toString());
           }
       }
   }
}
