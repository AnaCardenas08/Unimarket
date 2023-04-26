package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Pablo Andres Sanchez
@AllArgsConstructor
@Getter
@Setter
public class CompraDTO
{
    private int codigoUsuario;

    private MetodoPago metodoPago;

    private double totalPago;


}
