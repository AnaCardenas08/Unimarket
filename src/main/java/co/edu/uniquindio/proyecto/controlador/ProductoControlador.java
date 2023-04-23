package co.edu.uniquindio.proyecto.controlador;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Disponibilidad;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@AllArgsConstructor
public class ProductoControlador
{
    private final ProductoServicio productoServicio;
    /*
    public int crearProducto(ProductoDTO productoDTO)  throws Exception;

    public int actualizarProducto(int codigoProducto, ProductoGetDTO productoGetDTO) throws Exception;

    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception;

    public int actualizarEstado(int codigoProducto, Disponibilidad disponibilidad) throws Exception;

    public int eliminarProducto(int codigoProducto) throws Exception;

    public void crearFavorito(int codigoUsuario, int codigoProducto)throws Exception;

    void eliminarFavorito(int codigoUsuario, int codigoProducto)throws Exception;

    Producto obtener(int codigo) throws Exception;

    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;

    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);

    List<ProductoGetDTO> listarProductosPorEstado(Disponibilidad disponibilidad);

    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);

    List<ProductoGetDTO> listarProductosNombre(String nombre, Categoria categoria);

    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

*/
}
