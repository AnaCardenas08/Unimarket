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

    @OneToMany(mappedBy = "producto")
    private List<Foro> foro;

    @OneToMany(mappedBy = "producto")
    private List<Calificacion> calificacion;

    @OneToMany(mappedBy = "producto")
    private List<ProductoFavorito> productoFavorito;

    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentario;

    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Moderador moderador;

    @ManyToMany(mappedBy = "producto")
    private List<CarritoCompra> carritoCompra;

    @ManyToMany(mappedBy = "producto")
    private List<Compra> compra;

    @ElementCollection  //Se pone para aquellas listas que no sean @Entity
    private List<Categoria> categorias; //Pregunta, al ser enum la relacion de ManyToMany???



}
