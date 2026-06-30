/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upn.veterinaria.prueba;
import pe.edu.upn.veterinaria.controller.VeterinariaController;
/**
 *
 * @author leo_j
 */
public class TestVeterinariaService {
    public static void main(String[] args) {

        VeterinariaController controller =
                new VeterinariaController();

        boolean ok =
                controller.login(
                        "admin",
                        "admin123");

        System.out.println(
                "Login: " + ok);

    }

}
