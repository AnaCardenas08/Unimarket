package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Disponibilidad;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer>
{
    @Query("select p from Producto p where p.codigo =:codigo")
    Producto buscarProducto(Integer codigo);

    @Query("select p from Producto p where p.usuario.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from Producto p where :categoria member of p.categorias")
    List<Producto> listarProductosCategoria(Categoria categoria);

    @Query("select p from Producto p where p.disponibilidad = :disponibilidad")
    List<Producto> listarProductosEstado(Disponibilidad disponibilidad);

    @Query("select p from Producto p join p.usuariosFavorito u where u.codigo = :codigoUsuario")
    List<Producto> listarProductosFavoritos(int codigoUsuario);

    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' )")
    List<Producto> listarProductosNombre(String nombre);

    @Query("select p from Producto p where p.precio > :precioMinimo and p.precio < :precioMaximo")
    List<Producto> listarProductosPrecio(float precioMinimo, float precioMaximo);


}
