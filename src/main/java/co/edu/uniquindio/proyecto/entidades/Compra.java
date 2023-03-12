package co.edu.uniquindio.proyecto.entidades;


import jakarta.persistence.*;
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
public class Compra implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private LocalDate fechaCompra;
    private Double totalPago;

    @ManyToMany
    private List<Producto> producto;

    @ElementCollection
    private List<MetodoPago> metodoPago; //Pregunta, al ser enum la relacion con compra de ManyToOne??


}
