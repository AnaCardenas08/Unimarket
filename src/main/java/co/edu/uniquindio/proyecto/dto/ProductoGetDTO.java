package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Disponibilidad;
import co.edu.uniquindio.proyecto.entidades.Imagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO
{
    private int codigo;

    private Disponibilidad disponibilidad;

    private LocalDateTime fechaLimite;

    private String nombre;

    private String descripcion;

    private int unidades;

    private double precio;

    private int codigoUsuario;

    private List<Imagen> imagenes;

    private List<Categoria> categorias;

}
