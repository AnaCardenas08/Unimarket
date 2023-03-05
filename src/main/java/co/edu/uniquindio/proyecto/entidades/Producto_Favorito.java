package co.edu.uniquindio.proyecto.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Producto_Favorito implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

}
