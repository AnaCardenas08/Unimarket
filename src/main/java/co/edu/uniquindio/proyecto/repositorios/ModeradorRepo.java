package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer>
{
    @Query("select m from Moderador  m where m.email = :email and m.password=:password")
    Moderador comprobarAutenticacion(String email, String password);
    Optional<Moderador> findByEmail(String email);

}
