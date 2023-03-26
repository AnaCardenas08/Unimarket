package co.edu.uniquindio.proyecto.servicios.Interfaz;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio
{

    int crearComentario(ComentarioDTO comentarioDTO);

    List<ComentarioGetDTO> listarComentarios(int codigoProducto);

}
