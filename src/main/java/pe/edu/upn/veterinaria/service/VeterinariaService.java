/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upn.veterinaria.service;
import pe.edu.upn.veterinaria.dto.ClienteDTO;
import pe.edu.upn.veterinaria.dto.EmpleadoDTO;
import pe.edu.upn.veterinaria.dto.MascotaDTO;
import pe.edu.upn.veterinaria.util.AccesoDB;
import pe.edu.upn.veterinaria.util.HashUtil;
import pe.edu.upn.veterinaria.dto.ColorDTO;
import pe.edu.upn.veterinaria.dto.EspecieDTO;
import pe.edu.upn.veterinaria.dto.RazaDTO;
import pe.edu.upn.veterinaria.dto.SexoDTO;
import pe.edu.upn.veterinaria.dto.UbicacionDTO;
import pe.edu.upn.veterinaria.dto.ClienteConsultaDTO;
import pe.edu.upn.veterinaria.dto.MascotaConsultaDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upn.veterinaria.dto.BusquedaDTO;
import pe.edu.upn.veterinaria.dto.CitaConsultaDTO;
import pe.edu.upn.veterinaria.dto.VacunaDTO;
import pe.edu.upn.veterinaria.dto.VacunacionConsultaDTO;
/**
 *
 * @author leo_j
 */
public class VeterinariaService {
    public EmpleadoDTO validarLogin(
        String usuario,
        String clave) {

    EmpleadoDTO empleado = null;

    String sql =
            "SELECT * FROM EMPLEADO " +
            "WHERE usuario = ? AND clave = ?";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql)) {

        ps.setString(1, usuario);

        ps.setString(
                2,
                clave);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            empleado = new EmpleadoDTO();

            empleado.setIdEmpleado(
                    rs.getInt("id_empleado"));

            empleado.setNombre(
                    rs.getString("nombre"));

            empleado.setApellido(
                    rs.getString("apellido"));

            empleado.setCargo(
                    rs.getString("cargo"));

            empleado.setUsuario(
                    rs.getString("usuario"));

        }

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error en login: "
                        + e.getMessage());

    }

    return empleado;
}
    public void registrarCliente(
        String dni,
        String apellidoPaterno,
        String apellidoMaterno,
        String nombre,
        String telefono,
        String direccion,
        java.util.Date fechaRegistro) {

    String sql =
            "INSERT INTO CLIENTE(" +
            "dni," +
            "apellido_paterno," +
            "apellido_materno," +
            "nombre," +
            "telefono," +
            "direccion," +
            "fecha_registro)" +
            " VALUES(?,?,?,?,?,?,?)";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql)) {

        ps.setString(1, dni);
        ps.setString(2, apellidoPaterno);
        ps.setString(3, apellidoMaterno);
        ps.setString(4, nombre);
        ps.setString(5, telefono);
        ps.setString(6, direccion);

        ps.setDate(
                7,
                new java.sql.Date(
                        fechaRegistro.getTime()));

        ps.executeUpdate();

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al registrar cliente: "
                        + e.getMessage());
    }
}
    public List<ClienteDTO> listarClientes() {

    List<ClienteDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT * FROM CLIENTE " +
            "ORDER BY nombre";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            ClienteDTO c =
                    new ClienteDTO();

            c.setIdCliente(
                    rs.getInt("id_cliente"));

            c.setDni(
                    rs.getString("dni"));

            c.setApellidoPaterno(
                    rs.getString(
                            "apellido_paterno"));

            c.setApellidoMaterno(
                    rs.getString(
                            "apellido_materno"));

            c.setNombre(
                    rs.getString("nombre"));

            c.setTelefono(
                    rs.getString("telefono"));

            c.setDireccion(
                    rs.getString("direccion"));

            c.setFechaRegistro(
                    rs.getDate(
                            "fecha_registro"));

            lista.add(c);
        }

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al listar clientes: "
                        + e.getMessage());
    }

    return lista;
}
    public void registrarMascota(
        String nombre,
        java.util.Date fechaNacimiento,
        int idCliente,
        int idRaza,
        int idSexo,
        int idColor,
        int idUbicacion) {

    String sql =
            "INSERT INTO MASCOTA(" +
            "nombre," +
            "fecha_nacimiento," +
            "id_cliente," +
            "id_raza," +
            "id_sexo," +
            "id_color," +
            "id_ubicacion)" +
            " VALUES(?,?,?,?,?,?,?)";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql)) {

        ps.setString(1, nombre);

        ps.setDate(
                2,
                new java.sql.Date(
                        fechaNacimiento.getTime()));

        ps.setInt(3, idCliente);
        ps.setInt(4, idRaza);
        ps.setInt(5, idSexo);
        ps.setInt(6, idColor);
        ps.setInt(7, idUbicacion);

        ps.executeUpdate();

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al registrar mascota: "
                        + e.getMessage());
    }
}
    public List<MascotaDTO> listarMascotas() {

    List<MascotaDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT * FROM MASCOTA " +
            "ORDER BY nombre";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            MascotaDTO m =
                    new MascotaDTO();

            m.setIdMascota(
                    rs.getInt("id_mascota"));

            m.setNombre(
                    rs.getString("nombre"));

            m.setFechaNacimiento(
                    rs.getDate(
                            "fecha_nacimiento"));

            m.setIdCliente(
                    rs.getInt("id_cliente"));

            m.setIdRaza(
                    rs.getInt("id_raza"));

            m.setIdSexo(
                    rs.getInt("id_sexo"));

            m.setIdColor(
                    rs.getInt("id_color"));

            m.setIdUbicacion(
                    rs.getInt("id_ubicacion"));

            lista.add(m);
        }

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al listar mascotas: "
                        + e.getMessage());
    }

    return lista;
}
public List<EspecieDTO> listarEspecies() {

    List<EspecieDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT * FROM ESPECIE " +
            "ORDER BY nombre_especie";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            EspecieDTO e =
                    new EspecieDTO();

            e.setIdEspecie(
                    rs.getInt("id_especie"));

            e.setNombreEspecie(
                    rs.getString("nombre_especie"));

            lista.add(e);
        }

    } catch (SQLException ex) {

        throw new RuntimeException(
                "Error al listar especies: "
                        + ex.getMessage());
    }

    return lista;
}
public List<RazaDTO> listarRazas() {

    List<RazaDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT * FROM RAZA " +
            "ORDER BY nombre_raza";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            RazaDTO r =
                    new RazaDTO();

            r.setIdRaza(
                    rs.getInt("id_raza"));

            r.setNombreRaza(
                    rs.getString("nombre_raza"));

            r.setIdEspecie(
                    rs.getInt("id_especie"));

            lista.add(r);
        }

    } catch (SQLException ex) {

        throw new RuntimeException(
                "Error al listar razas: "
                        + ex.getMessage());
    }

    return lista;
}
public List<SexoDTO> listarSexos() {

    List<SexoDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT * FROM SEXO";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            SexoDTO s =
                    new SexoDTO();

            s.setIdSexo(
                    rs.getInt("id_sexo"));

            s.setDescripcion(
                    rs.getString("descripcion"));

            lista.add(s);
        }

    } catch (SQLException ex) {

        throw new RuntimeException(
                "Error al listar sexos: "
                        + ex.getMessage());
    }

    return lista;
}
public List<ColorDTO> listarColores() {

    List<ColorDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT * FROM COLOR";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            ColorDTO c =
                    new ColorDTO();

            c.setIdColor(
                    rs.getInt("id_color"));

            c.setDescripcion(
                    rs.getString("descripcion"));

            lista.add(c);
        }

    } catch (SQLException ex) {

        throw new RuntimeException(
                "Error al listar colores: "
                        + ex.getMessage());
    }

    return lista;
}
public List<UbicacionDTO> listarUbicaciones() {

    List<UbicacionDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT * FROM UBICACION " +
            "ORDER BY departamento";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            UbicacionDTO u =
                    new UbicacionDTO();

            u.setIdUbicacion(
                    rs.getInt("id_ubicacion"));

            u.setDepartamento(
                    rs.getString("departamento"));

            u.setProvincia(
                    rs.getString("provincia"));

            u.setDistrito(
                    rs.getString("distrito"));

            u.setUbigeo(
                    rs.getString("ubigeo"));

            lista.add(u);
        }

    } catch (SQLException ex) {

        throw new RuntimeException(
                "Error al listar ubicaciones: "
                        + ex.getMessage());
    }

    return lista;
}
public List<ClienteConsultaDTO> consultarClientes() {

    List<ClienteConsultaDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT " +
            "id_cliente, " +
            "dni, " +
            "apellido_paterno + ' ' + " +
            "apellido_materno + ', ' + nombre AS cliente, " +
            "telefono " +
            "FROM CLIENTE " +
            "ORDER BY apellido_paterno, apellido_materno";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            ClienteConsultaDTO c =
                    new ClienteConsultaDTO();

            c.setIdCliente(
                    rs.getInt("id_cliente"));

            c.setDni(
                    rs.getString("dni"));

            c.setCliente(
                    rs.getString("cliente"));

            c.setTelefono(
                    rs.getString("telefono"));

            lista.add(c);
        }

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al consultar clientes: "
                        + e.getMessage());
    }

    return lista;
}
public List<MascotaConsultaDTO> consultarMascotas() {

    List<MascotaConsultaDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT " +
            "m.id_mascota, " +
            "m.nombre, " +
            "m.fecha_nacimiento, " +
            "c.nombre + ' ' + c.apellido_paterno AS cliente, " +
            "r.nombre_raza AS raza, " +
            "s.descripcion AS sexo, " +
            "co.descripcion AS color, " +
            "u.departamento AS ubicacion " +
            "FROM MASCOTA m " +
            "INNER JOIN CLIENTE c " +
            "ON m.id_cliente = c.id_cliente " +
            "INNER JOIN RAZA r " +
            "ON m.id_raza = r.id_raza " +
            "INNER JOIN SEXO s " +
            "ON m.id_sexo = s.id_sexo " +
            "INNER JOIN COLOR co " +
            "ON m.id_color = co.id_color " +
            "INNER JOIN UBICACION u " +
            "ON m.id_ubicacion = u.id_ubicacion " +
            "ORDER BY m.nombre";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            MascotaConsultaDTO m =
                    new MascotaConsultaDTO();

            m.setIdMascota(
                    rs.getInt("id_mascota"));

            m.setNombreMascota(
                    rs.getString("nombre"));

            m.setFechaNacimiento(
                    rs.getDate("fecha_nacimiento"));

            m.setCliente(
                    rs.getString("cliente"));

            m.setRaza(
                    rs.getString("raza"));

            m.setSexo(
                    rs.getString("sexo"));

            m.setColor(
                    rs.getString("color"));
            m.setUbicacion(
                    rs.getString("ubicacion"));
            lista.add(m);
        }

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al consultar mascotas: "
                        + e.getMessage());
    }

    return lista;
}
public void registrarCita(
        java.util.Date fechaCita,
        java.sql.Time horaCita,
        String motivo,
        String estado,
        int idMascota,
        int idEmpleado) {

    String sql =
            "INSERT INTO CITA(" +
            "fecha_cita," +
            "hora_cita," +
            "motivo," +
            "estado," +
            "id_mascota," +
            "id_empleado)" +
            " VALUES(?,?,?,?,?,?)";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql)) {

        ps.setDate(
                1,
                new java.sql.Date(
                        fechaCita.getTime()));

        ps.setTime(
                2,
                horaCita);

        ps.setString(
                3,
                motivo);

        ps.setString(
                4,
                estado);

        ps.setInt(
                5,
                idMascota);

        ps.setInt(
                6,
                idEmpleado);

        ps.executeUpdate();

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al registrar cita: "
                        + e.getMessage());
    }
}
public List<CitaConsultaDTO> consultarCitas() {

    List<CitaConsultaDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT " +
            "c.id_cita, " +
            "c.fecha_cita, " +
            "c.hora_cita, " +
            "m.nombre AS mascota, " +
            "e.nombre + ' ' + e.apellido AS empleado, " +
            "c.motivo, " +
            "c.estado " +
            "FROM CITA c " +
            "INNER JOIN MASCOTA m " +
            "ON c.id_mascota = m.id_mascota " +
            "INNER JOIN EMPLEADO e " +
            "ON c.id_empleado = e.id_empleado " +
            "ORDER BY c.fecha_cita DESC";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            CitaConsultaDTO c =
                    new CitaConsultaDTO();

            c.setIdCita(
                    rs.getInt("id_cita"));

            c.setFechaCita(
                    rs.getDate("fecha_cita"));

            c.setHoraCita(
                    rs.getTime("hora_cita"));

            c.setMascota(
                    rs.getString("mascota"));

            c.setEmpleado(
                    rs.getString("empleado"));

            c.setMotivo(
                    rs.getString("motivo"));

            c.setEstado(
                    rs.getString("estado"));

            lista.add(c);
        }

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al consultar citas: "
                        + e.getMessage());
    }

    return lista;
}
public List<MascotaDTO> obtenerMascotas() {

    return listarMascotas();

}
public List<VacunaDTO> listarVacunas() {

    List<VacunaDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT * FROM VACUNA " +
            "ORDER BY nombre";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            VacunaDTO v =
                    new VacunaDTO();

            v.setIdVacuna(
                    rs.getInt("id_vacuna"));

            v.setNombre(
                    rs.getString("nombre"));

            v.setDescripcion(
                    rs.getString("descripcion"));

            lista.add(v);

        }

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al listar vacunas: "
                        + e.getMessage());

    }

    return lista;
}
public void registrarVacunacion(
        java.util.Date fechaAplicacion,
        int idMascota,
        int idVacuna) {

    String sql =
            "INSERT INTO VACUNACION(" +
            "fecha_aplicacion," +
            "id_mascota," +
            "id_vacuna)" +
            " VALUES(?,?,?)";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql)) {

        ps.setDate(
                1,
                new java.sql.Date(
                        fechaAplicacion.getTime()));

        ps.setInt(
                2,
                idMascota);

        ps.setInt(
                3,
                idVacuna);

        ps.executeUpdate();

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al registrar vacunación: "
                        + e.getMessage());

    }
}
public List<VacunacionConsultaDTO>
consultarVacunaciones() {

    List<VacunacionConsultaDTO> lista =
            new ArrayList<>();

    String sql =
            "SELECT " +
            "v.id_vacunacion, " +
            "v.fecha_aplicacion, " +
            "m.nombre AS mascota, " +
            "va.nombre AS vacuna " +
            "FROM VACUNACION v " +
            "INNER JOIN MASCOTA m " +
            "ON v.id_mascota = m.id_mascota " +
            "INNER JOIN VACUNA va " +
            "ON v.id_vacuna = va.id_vacuna " +
            "ORDER BY v.fecha_aplicacion DESC";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            VacunacionConsultaDTO vc =
                    new VacunacionConsultaDTO();

            vc.setIdVacunacion(
                    rs.getInt("id_vacunacion"));

            vc.setFechaAplicacion(
                    rs.getDate(
                            "fecha_aplicacion"));

            vc.setMascota(
                    rs.getString("mascota"));

            vc.setVacuna(
                    rs.getString("vacuna"));

            lista.add(vc);

        }

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error al consultar vacunaciones: "
                        + e.getMessage());

    }

    return lista;
}
public List<Object[]> reporteMascotas() {

    List<Object[]> lista =
            new ArrayList<>();

    String sql =
            "SELECT " +
            "m.id_mascota, " +
            "m.nombre, " +
            "r.nombre_raza, " +
            "c.nombre + ' ' + c.apellido_paterno " +
            "FROM MASCOTA m " +
            "INNER JOIN RAZA r " +
            "ON m.id_raza = r.id_raza " +
            "INNER JOIN CLIENTE c " +
            "ON m.id_cliente = c.id_cliente";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            lista.add(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            });

        }

    } catch (SQLException e) {

        throw new RuntimeException(
                e.getMessage());

    }

    return lista;
}
public List<Object[]> reporteCitas() {

    List<Object[]> lista =
            new ArrayList<>();

    String sql =
            "SELECT " +
            "c.id_cita, " +
            "c.fecha_cita, " +
            "m.nombre, " +
            "c.estado " +
            "FROM CITA c " +
            "INNER JOIN MASCOTA m " +
            "ON c.id_mascota = m.id_mascota";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            lista.add(new Object[]{
                    rs.getInt(1),
                    rs.getDate(2),
                    rs.getString(3),
                    rs.getString(4)
            });

        }

    } catch (SQLException e) {

        throw new RuntimeException(
                e.getMessage());

    }

    return lista;
}
public List<Object[]> reporteVacunas() {

    List<Object[]> lista =
            new ArrayList<>();

    String sql =
            "SELECT " +
            "v.id_vacunacion, " +
            "m.nombre, " +
            "va.nombre, " +
            "v.fecha_aplicacion " +
            "FROM VACUNACION v " +
            "INNER JOIN MASCOTA m " +
            "ON v.id_mascota = m.id_mascota " +
            "INNER JOIN VACUNA va " +
            "ON v.id_vacuna = va.id_vacuna";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            lista.add(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4)
            });

        }

    } catch (SQLException e) {

        throw new RuntimeException(
                e.getMessage());

    }

    return lista;
}
public List<Object[]> reporteMascotasPorEspecie() {

    List<Object[]> lista =
            new ArrayList<>();

    String sql =
            "SELECT " +
            "e.nombre_especie, " +
            "COUNT(*) " +
            "FROM MASCOTA m " +
            "INNER JOIN RAZA r " +
            "ON m.id_raza = r.id_raza " +
            "INNER JOIN ESPECIE e " +
            "ON r.id_especie = e.id_especie " +
            "GROUP BY e.nombre_especie";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery()) {

        while (rs.next()) {

            lista.add(new Object[]{
                    rs.getString(1),
                    rs.getInt(2)
            });

        }

    } catch (SQLException e) {

        throw new RuntimeException(
                e.getMessage());

    }

    return lista;
}
public List<BusquedaDTO> buscarGlobal(
        String texto) {

    List<BusquedaDTO> lista =
            new ArrayList<>();

    String sql =

            "SELECT " +
            "'CLIENTE' AS tipo, " +
            "nombre, " +
            "dni + ' - ' + telefono AS detalle " +
            "FROM CLIENTE " +
            "WHERE nombre LIKE ? " +

            "UNION ALL " +

            "SELECT " +
            "'MASCOTA' AS tipo, " +
            "m.nombre, " +
            "r.nombre_raza + ' - ' + c.nombre " +
            "FROM MASCOTA m " +
            "INNER JOIN RAZA r " +
            "ON m.id_raza = r.id_raza " +
            "INNER JOIN CLIENTE c " +
            "ON m.id_cliente = c.id_cliente " +
            "WHERE m.nombre LIKE ?";

    try (Connection con =
                 AccesoDB.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql)) {

        String filtro =
                "%" + texto + "%";

        ps.setString(1, filtro);
        ps.setString(2, filtro);

        ResultSet rs =
                ps.executeQuery();

        while (rs.next()) {

            BusquedaDTO b =
                    new BusquedaDTO();

            b.setTipo(
                    rs.getString("tipo"));

            b.setNombre(
                    rs.getString("nombre"));

            b.setDetalle(
                    rs.getString("detalle"));

            lista.add(b);

        }

    } catch (SQLException e) {

        throw new RuntimeException(
                "Error en búsqueda: "
                        + e.getMessage());

    }

    return lista;
}
}
