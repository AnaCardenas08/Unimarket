package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Foro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Pablo Andres Sanchez
@Repository
public interface ForoRepo extends JpaRepository<Foro, Integer>
{
    //Pablo Andres Sanchez
    @Query("select f from Foro f where f.usuario.codigo = :codigoUsuario")
    List<Foro> listarComentarios(int codigoUsuario);



}
