package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ComentarioServicioImpl implements ComentarioServicio
{

    private final ComentarioRepo comentarioRepo;


    @Override
    public int crearComentario(ComentarioDTO comentarioDTO)
    {
        return 0;
    }

    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto)
    {
        return null;
    }

}

