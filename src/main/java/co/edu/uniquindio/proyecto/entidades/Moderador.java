package co.edu.uniquindio.proyecto.entidades;


import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Moderador extends Persona implements Serializable
{

    @ToString.Exclude
    @OneToMany(mappedBy = "moderador")
    private List<Producto> producto;


}
