/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upn.veterinaria.util;

/**
 *
 * @author usario1
 */
import java.sql.Connection;
import pe.edu.upn.veterinaria.util.AccesoDB;
public class testconexion {
    public static void main(String[] args) {

        try (Connection con = AccesoDB.getConnection()) {
            System.out.println("✅ CONEXIÓN OK A PETYLAB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
