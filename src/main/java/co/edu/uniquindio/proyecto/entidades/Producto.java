package co.edu.uniquindio.proyecto.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Producto implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Double precio;
    @PositiveOrZero
    private String disponibilidad;
    private Date fecha_limite;


}
