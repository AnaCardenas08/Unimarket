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
    @Column(nullable = false, length = 30)
    private String nombre;
    @Column(nullable = false)
    @PositiveOrZero
    private Double precio;

    private Disponibilidad disponibilidad;

    @Column(nullable = false)
    private int unidades;

    private LocalDate fechaLimite;

    @ElementCollection
    private List<String> imagen;

    @OneToMany(mappedBy = "producto")
    private List<Foro> foro;

    @OneToMany(mappedBy = "producto")
    private List<Calificacion> calificacion;

    @ManyToMany(mappedBy = "productoFavorito")
    private List<Usuario> usuariosFavorito;

    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentario;

    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Moderador moderador;

    @ElementCollection  //Se pone para aquellas listas que no sean @Entity
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "producto")
    private List<CompraProducto> compraProducto;

}
