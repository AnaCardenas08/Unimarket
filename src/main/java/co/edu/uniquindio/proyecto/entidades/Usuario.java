package co.edu.uniquindio.proyecto.entidades;



import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario extends Persona implements Serializable
{

    private String telefono;
    private String direccion;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Producto> producto;

    @ToString.Exclude
    @OneToMany(mappedBy ="usuario")
    private List<Foro> foro;


    @ManyToMany
    private List<Producto> productoFavorito;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentario;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;



}
