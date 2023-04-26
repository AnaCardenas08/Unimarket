package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//Pablo Andres Sanchez
@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer>
{
    //Pablo Andres Sanchez
    @Query("select c from Compra c where c.codigo = :codigoCompra ")
    Compra buscarCompra(Integer codigoCompra);

    //Pablo Andres Sanchez
    @Query("select c from Compra c where c.usuario.codigo = :codigoUsuario")
    List<Compra> listarComprasUsuario(int codigoUsuario);

}
