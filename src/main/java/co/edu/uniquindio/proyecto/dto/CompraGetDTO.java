package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

//Pablo Andres Sanchez
@AllArgsConstructor
@Getter
@Setter
public class CompraGetDTO
{
    private int codigo;

    private LocalDateTime fecha;

    private double valorTotal;

    private int codigoUsuario;

    private MetodoPago metodoPago;



}
