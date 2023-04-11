package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import java.io.Serializable;

@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Persona implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 100) //que el campo sea obligatorio y limitando su tamaño a 100 (solo funciona para strings)
    private String nombre;

    @Email //valida que sea un correo
    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, unique = true, length = 100)
    private String password;

}
