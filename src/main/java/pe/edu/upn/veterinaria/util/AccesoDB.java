
package pe.edu.upn.veterinaria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leo_j
 */
public class AccesoDB {
     private static final String URL = "jdbc:sqlserver://DESKTOP-6PRVRJV:1433;databaseName=PETYLAB;encrypt=true;trustServerCertificate=true;user=petyuser;password=12345678;";

    private AccesoDB() {
    }

    public static Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(URL);
            System.out.println("¡CONEXIÓN EXITOSA A PETYLAB!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error Driver: " + e.getMessage(), e);
        } catch (SQLException e) {
            throw new RuntimeException("Error en SQL Server: " + e.getMessage(), e);
        }
        return cn;
    }
    
}
