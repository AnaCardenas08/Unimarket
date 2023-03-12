package co.edu.uniquindio.proyecto.entidades;


import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductoFavorito implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;


    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Usuario usuario;
}
