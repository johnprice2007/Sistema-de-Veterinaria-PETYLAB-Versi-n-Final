/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upn.veterinaria.util;
import java.security.MessageDigest;
/**
 *
 * @author leo_j
 */
public class HashUtil {
     public static String sha256(String texto) {

        try {

            MessageDigest md =
                    MessageDigest.getInstance("SHA-256");

            byte[] hash =
                    md.digest(texto.getBytes());

            StringBuilder sb =
                    new StringBuilder();

            for (byte b : hash) {

                sb.append(
                        String.format("%02x", b));

            }

            return sb.toString();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error generando hash");

        }

    }
}
