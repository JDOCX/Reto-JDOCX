package com.example.demoreal;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;

    public Connection conexion(){
        con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.1.155:3306/jdocxdef", "root", "");

        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de Conexión");

        }
        return con;
    }

    public void closeConnection(){
        try{
            conexion().close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion.");
        }
    }
}
