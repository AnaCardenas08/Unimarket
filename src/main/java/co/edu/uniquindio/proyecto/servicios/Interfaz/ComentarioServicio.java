package co.edu.uniquindio.proyecto.servicios.Interfaz;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Calificacion;
import co.edu.uniquindio.proyecto.entidades.Comentario;

import java.util.List;

//Diego Alejandro Lopez

public interface ComentarioServicio
{
    //Diego Alejandro Lopez
    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    //Diego Alejandro Lopez
    List<ComentarioGetDTO> listarComentarios(int codigoProducto);

    //Diego Alejandro Lopez
    int actualizarCalificacion(int codigoComentario, Calificacion calificacion) throws Exception;

    //Diego Alejandro Lopez
    Comentario obtener(int codigo) throws Exception;

    //Diego Alejandro Lopez
    ComentarioGetDTO convertir(Comentario comentario);

    //Diego Alejandro Lopez
    ComentarioGetDTO obtenerComentario(int codigoComentario)  throws Exception;


}

