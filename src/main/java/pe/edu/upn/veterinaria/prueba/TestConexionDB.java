/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.upn.veterinaria.prueba;
import pe.edu.upn.veterinaria.util.AccesoDB;
/**
 *
 * @author leo_j
 */
public class TestConexionDB {

    public static void main(String[] args) {
         System.out.println("PRUEBA 1: CONEXIÓN JDBC");
        System.out.println("Conectando a SQL Server...");
        
        try {
            // Intenta levantar la conexión JDBC
            long start = System.currentTimeMillis();
            AccesoDB.getConnection();
            long end = System.currentTimeMillis();
            
            System.out.println("-> [OK] Conexión establecida correctamente.");
            System.out.println("-> Tiempo de respuesta: " + (end - start) + " ms");
            
        } catch (Exception e) {
            System.err.println("-> [ERROR] No se pudo conectar a la base de datos.");
            System.err.println("-> Detalle técnico: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("================================================");
    }
    
}
