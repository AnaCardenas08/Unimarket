package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Calificacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioDTO
{
    private String mensaje;

    private int codigoUsuario;

    private int codigoProducto;

    private Calificacion calificacion;

}
