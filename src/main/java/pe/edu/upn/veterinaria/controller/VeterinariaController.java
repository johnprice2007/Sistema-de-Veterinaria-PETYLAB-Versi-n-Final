/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upn.veterinaria.controller;
import pe.edu.upn.veterinaria.dto.ClienteDTO;
import pe.edu.upn.veterinaria.dto.EmpleadoDTO;
import pe.edu.upn.veterinaria.dto.MascotaDTO;
import pe.edu.upn.veterinaria.dto.ColorDTO;
import pe.edu.upn.veterinaria.dto.EspecieDTO;
import pe.edu.upn.veterinaria.dto.RazaDTO;
import pe.edu.upn.veterinaria.dto.SexoDTO;
import pe.edu.upn.veterinaria.dto.UbicacionDTO;
import pe.edu.upn.veterinaria.service.VeterinariaService;
import pe.edu.upn.veterinaria.dto.ClienteConsultaDTO;
import pe.edu.upn.veterinaria.dto.MascotaConsultaDTO;
import pe.edu.upn.veterinaria.dto.CitaConsultaDTO;
import pe.edu.upn.veterinaria.dto.CitaDTO;
import java.util.Date;
import java.util.List;
import pe.edu.upn.veterinaria.dto.VacunaDTO;
import pe.edu.upn.veterinaria.dto.VacunacionConsultaDTO;
import pe.edu.upn.veterinaria.dto.BusquedaDTO;
/**
 *
 * @author leo_j
 */
public class VeterinariaController {
    private final VeterinariaService service;

    private EmpleadoDTO empleadoLogueado;

    public VeterinariaController() {

        service = new VeterinariaService();

    }

    public boolean login(
            String usuario,
            String clave) {

        empleadoLogueado =
                service.validarLogin(
                        usuario,
                        clave);

        return empleadoLogueado != null;

    }

    public EmpleadoDTO getEmpleadoLogueado() {

        return empleadoLogueado;

    }

    public void cerrarSesion() {

        empleadoLogueado = null;

    }

    public void registrarCliente(
            String dni,
            String apellidoPaterno,
            String apellidoMaterno,
            String nombre,
            String telefono,
            String direccion,
            Date fechaRegistro) {

        service.registrarCliente(
                dni,
                apellidoPaterno,
                apellidoMaterno,
                nombre,
                telefono,
                direccion,
                fechaRegistro);

    }

    public List<ClienteDTO> listarClientes() {

        return service.listarClientes();

    }

    public void registrarMascota(
            
            String nombre,
            Date fechaNacimiento,
            int idCliente,
            int idRaza,
            int idSexo,
            int idColor,
            int idUbicacion) {

        service.registrarMascota(
                nombre,
                fechaNacimiento,
                idCliente,
                idRaza,
                idSexo,
                idColor,
                idUbicacion);

    }

    public List<MascotaDTO> listarMascotas() {

        return service.listarMascotas();

    }
    public List<EspecieDTO> listarEspecies() {

    return service.listarEspecies();

}
    public List<RazaDTO> listarRazas() {

    return service.listarRazas();

}
    public List<SexoDTO> listarSexos() {

    return service.listarSexos();

}
    public List<ColorDTO> listarColores() {

    return service.listarColores();

}
    public List<UbicacionDTO> listarUbicaciones() {

    return service.listarUbicaciones();

}
    public List<ClienteConsultaDTO> consultarClientes() {

    return service.consultarClientes();

}
    public List<MascotaConsultaDTO> consultarMascotas() {

    return service.consultarMascotas();

}
    public void registrarCita(
        Date fechaCita,
        java.sql.Time horaCita,
        String motivo,
        String estado,
        int idMascota,
        int idEmpleado) {

    service.registrarCita(
            fechaCita,
            horaCita,
            motivo,
            estado,
            idMascota,
            idEmpleado);
}
    public List<CitaConsultaDTO> consultarCitas() {

    return service.consultarCitas();

}
    public List<MascotaDTO> obtenerMascotas() {

    return service.obtenerMascotas();

}
    public List<VacunaDTO> listarVacunas() {
    return service.listarVacunas();
}
    public void registrarVacunacion(
        Date fechaAplicacion,
        int idMascota,
        int idVacuna) {

    service.registrarVacunacion(
            fechaAplicacion,
            idMascota,
            idVacuna);
}
    public List<VacunacionConsultaDTO>
consultarVacunaciones() {

    return service.consultarVacunaciones();
}
public List<Object[]> reporteMascotas() {
    return service.reporteMascotas();
}

public List<Object[]> reporteCitas() {
    return service.reporteCitas();
}

public List<Object[]> reporteVacunas() {
    return service.reporteVacunas();
}

public List<Object[]> reporteMascotasPorEspecie() {
    return service.reporteMascotasPorEspecie();
}
public List<BusquedaDTO> buscarGlobal(
        String texto) {

    return service.buscarGlobal(
            texto);

}
}
