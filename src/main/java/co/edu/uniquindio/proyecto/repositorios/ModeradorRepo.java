package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.ModeradorDTO;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> //esto es para acceder a la tabla asociada y poder realizar las peticiones haciendo uso de los datos en BD
{
//     @Query("select m from Moderador m where m.email =:email")
//     Moderador buscarModerador(String email);

    @Query("select m from Moderador  m where m.email = :email and m.password=:password")
    Moderador comprobarAutenticacion(String email, String password);


}
