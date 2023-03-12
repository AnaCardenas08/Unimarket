package co.edu.uniquindio.proyecto.entidades;



import jakarta.persistence.Entity;
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

    @OneToMany(mappedBy = "usuario")
    private List<Producto> producto;

    @OneToMany(mappedBy ="usuario")
    private List<Foro> foro;

    @OneToMany(mappedBy = "usuario")
    private List<Calificacion> calificacion;

    @OneToMany(mappedBy = "usuario")
    private List<ProductoFavorito> productoFavorito;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentario;




}
