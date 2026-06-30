/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upn.veterinaria.util;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author usario1
 */
public class testhash {
     public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println(cn.getMetaData().getURL());
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
//System.out.println(HashUtil.sha256("12345678"));