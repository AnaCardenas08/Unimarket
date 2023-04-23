package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Calificacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;


//Diego Alejandro Lopez
@AllArgsConstructor
@Getter
@Setter
public class ComentarioGetDTO
{

    private int codigo;

    private LocalDate fecha;

    private String mensaje;

    private int codigoUsuario;

    private int codigoProducto;

    private Calificacion calificacion;

}
