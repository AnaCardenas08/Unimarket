package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Pablo Andres Sanchez
@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer>
{
    //Pablo Andres Sanchez
    Optional<Moderador> findByEmail(String email);

}
