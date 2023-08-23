/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Luz
 */
public class Conexion {
    Connection con;
    public Connection getConnection(){
   try {
      String access = "jdbc:ucanaccess://C:/Users//Helios/Desktop/BILLING SYSTEM/ventas.accdb"; 
   //    String access = "jdbc:ucanaccess://D:/ventas.accdb";
  // String myBD = "jdbc:mysql://localhost:3306/sistemaventa?serverTimezone=UTC";
    con = DriverManager.getConnection(access);
    return con;
}
   catch (SQLException e){
       System.out.println(e.toString());
   }
   return null;
    }
  
    
}
