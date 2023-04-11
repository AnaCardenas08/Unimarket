package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Imagen;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO
{

    @NotBlank
    @NotNull
    @Length(max = 150, message = "El nombre debe tener máximo 150 caracteres")
    private String nombre;

    @NotBlank
    @NotNull
    @Length(max = 300, message = "La descripcion debe tener máximo 300 caracteres")
    private String descripcion;

    @PositiveOrZero
    private int unidades;

    @PositiveOrZero
    private float precio;

    @Positive
    private int codigoUsuario;

    private List<Imagen> imagenes;

    private List<Categoria> categorias;
}
