package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Disponibilidad;
import co.edu.uniquindio.proyecto.entidades.Imagen;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ProductoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class ProductoTest
{
    @Autowired
    private ProductoServicio productoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearProductoTest()
    {
        try
        {
            List<Categoria> listaCategoria = new ArrayList<>();

            ProductoDTO productoDTO = new ProductoDTO("Sombras", "Color Nude", 10, 15000, 1, listaCategoria, Disponibilidad.INACTIVO);

            productoServicio.crearProducto(productoDTO);

            Assertions.assertNotNull(productoDTO);

            System.out.println(productoDTO.getNombre());

        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProductoTest() throws Exception
    {
        ProductoGetDTO productoGuardado = productoServicio.obtenerProducto(1);
        productoGuardado.setNombre("Smart Watch");

        int productoActualizado = productoServicio.actualizarProducto(1, productoGuardado );

        ProductoGetDTO nuevoProducto = productoServicio.obtenerProducto(1);

        Assertions.assertEquals("Smart Watch", nuevoProducto.getNombre());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUnidadesTest() throws Exception
    {
        int productoActualizadoUni = productoServicio.actualizarUnidades(2, 50);

        ProductoGetDTO nuevoProducto = productoServicio.obtenerProducto(2);

        Assertions.assertEquals(50, nuevoProducto.getUnidades());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEstadoTest()
    {
        try
        {
            int productoActualizadoDisp = productoServicio.actualizarEstado(3, Disponibilidad.RECHAZADO);

            ProductoGetDTO nuevoProducto = productoServicio.obtenerProducto(3);

            Assertions.assertEquals(Disponibilidad.RECHAZADO, nuevoProducto.getDisponibilidad());

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProductoTest() throws Exception
    {
            productoServicio.eliminarProducto(4);

            Assertions.assertThrows( Exception.class, () -> productoServicio.obtener(4));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearFavoritoTest() //No pasa el test
    {
        try
        {
            productoServicio.crearFavorito(1,6);

            List<ProductoGetDTO> lista = productoServicio.listarProductosFavoritos(1);

            boolean existe = false;

            for(ProductoGetDTO pro : lista)
            {
                if(pro.getCodigo() == 6)
                {
                    existe = true;
                }
            }

            Assertions.assertTrue(existe);

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarFavoritoTest()
    {
        try
        {
            productoServicio.eliminarFavorito(1, 6);


        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosUsuarioTest()throws Exception
    {
            List<ProductoGetDTO> productosUsuario = productoServicio.listarProductosUsuario(1);

            Assertions.assertEquals(2, productosUsuario.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosCategoriaTest() throws Exception
    {
        List<ProductoGetDTO> productosCategoria = productoServicio.listarProductosCategoria(Categoria.DEPORTE);

        Assertions.assertEquals(1, productosCategoria.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosEstadoTest() throws Exception
    {
        List<ProductoGetDTO> productosEstado = productoServicio.listarProductosPorEstado(Disponibilidad.APROBADO);

        Assertions.assertEquals(2, productosEstado.size());
   }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosFavoritoTest() throws Exception //No pasa el test
    {
        List<ProductoGetDTO> productosFavorito = productoServicio.listarProductosFavoritos(1);
        Assertions.assertEquals(1, productosFavorito.size());
    }

    @Test
   @Sql("classpath:dataset.sql")
    public void listarProductosNombreTest() throws Exception
    {
        List<ProductoGetDTO> productosNombre = productoServicio.listarProductosNombre("Camisa de Vestir");
        Assertions.assertEquals(1, productosNombre.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosPrecioTest() throws Exception
    {
        List<ProductoGetDTO> productosPrecio = productoServicio.listarProductosPrecio(50000, 100000);
        Assertions.assertEquals( 0,productosPrecio.size());
    }

}
