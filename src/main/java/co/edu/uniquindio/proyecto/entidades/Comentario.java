package co.edu.uniquindio.proyecto.entidades;


import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Comentario implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 150)
    private String descripcion;
    private LocalDate fecha;

    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Usuario usuario;

}
