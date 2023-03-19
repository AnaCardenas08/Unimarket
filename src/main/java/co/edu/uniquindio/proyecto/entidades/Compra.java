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

    @ManyToOne
    private Usuario usuario;

    private MetodoPago metodoPago;

    @ToString.Exclude
    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> compraProducto;



}
