package co.edu.uniquindio.proyecto.servicios.Interfaz;

import co.edu.uniquindio.proyecto.dto.ForoDTO;
import co.edu.uniquindio.proyecto.dto.ForoGetDTO;
import java.util.List;

//Pablo Andres Sanchez
public interface ForoServicio
{
    //Pablo Andres Sanchez
    List<ForoGetDTO> listarComentariosForo(int codigoUsuario);

    //Pablo Andres Sanchez
    int crearComentarioForo(ForoDTO foroDTO) throws Exception;

}
