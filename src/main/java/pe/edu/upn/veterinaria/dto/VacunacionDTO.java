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
public class VacunacionDTO {
     private int idVacunacion;
    private Date fechaAplicacion;
    private int idMascota;
    private int idVacuna;

    public VacunacionDTO() {
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

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }
}
