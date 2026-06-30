/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pe.edu.upn.veterinaria;

import java.sql.Connection;
import pe.edu.upn.veterinaria.util.AccesoDB;

public class Veterinaria {

    public static void main(String[] args) {
        try {

            Connection cn = AccesoDB.getConnection();

            if (cn != null) {
                System.out.println("CONECTADO A PETYLAB CORRECTAMENTE");
            } else {
                System.out.println("NO CONECTO");
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
