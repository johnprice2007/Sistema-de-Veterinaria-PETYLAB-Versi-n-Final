/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upn.veterinaria.dto;
import java.util.Date;
/**
 *
 * @author leo_j
 */
public class VacunacionConsultaDTO {
    private int idVacunacion;
    private Date fechaAplicacion;
    private String mascota;
    private String vacuna;

    public VacunacionConsultaDTO() {
    }

    public int getIdVacunacion() {
        return idVacunacion;
    }

    public void setIdVacunacion(int idVacunacion) {
        this.idVacunacion = idVacunacion;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }
}
