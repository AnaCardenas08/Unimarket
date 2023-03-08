package co.edu.uniquindio.proyecto.entidades;


import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    @PositiveOrZero
    private Double precio;
    private String disponibilidad;
    private LocalDate fechaLimite;

    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagen;

    @ElementCollection
    private List<Categoria> categorias;



}
