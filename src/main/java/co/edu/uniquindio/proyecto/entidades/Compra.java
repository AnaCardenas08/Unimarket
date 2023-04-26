package co.edu.uniquindio.proyecto.entidades;


import jakarta.persistence.*;
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
public class Compra implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private LocalDateTime fechaCompra;
    private Double totalPago;

    @ManyToOne
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    @ToString.Exclude
    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> compraProducto;



}
