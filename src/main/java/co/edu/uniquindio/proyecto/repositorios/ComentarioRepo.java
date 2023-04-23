package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

//Diego Alejandro Lopez
@Repository
public interface ComentarioRepo extends JpaRepository<Comentario, Integer>
{
    //Diego Alejandro Lopez
    //Lista los comentarios
    @Query("select c from Comentario c where c.producto.codigo = :codigoProducto")
    List<Comentario> listarComentarios(int codigoProducto);
}
