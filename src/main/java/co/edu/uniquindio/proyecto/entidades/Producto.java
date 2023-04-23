package co.edu.uniquindio.proyecto.entidades;


import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private float precio;

    @Enumerated(EnumType.STRING)
    private Disponibilidad disponibilidad;

    @Column(nullable = false)
    private int unidades;

    private LocalDateTime fechaLimite;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagen;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Foro> foro;


    @ManyToMany(mappedBy = "productoFavorito")
    private List<Usuario> usuariosFavorito;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentario;

    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Moderador moderador;

    @ElementCollection  //Se pone para aquellas listas que no sean @Entity
    @Enumerated(EnumType.STRING)
    private List<Categoria> categorias;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<CompraProducto> compraProducto;

}
