package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Disponibilidad;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio
{
    private final ProductoRepo productoRepo;


    @Override
    public int crearProducto(ProductoDTO productoDTO)  throws Exception
    {
        return 0;
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO)  throws Exception
    {
        return 0;
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades)  throws Exception
    {
        return 0;
    }

    @Override
    public int actualizarEstado(int codigoProducto, Disponibilidad disponibilidad)  throws Exception
    {
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto)  throws Exception
    {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto)  throws Exception
    {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario)  throws Exception
    {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria)  throws Exception
    {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Disponibilidad disponibilidad)  throws Exception
    {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario)  throws Exception
    {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre)  throws Exception
    {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo)  throws Exception
    {
        return null;
    }
}
