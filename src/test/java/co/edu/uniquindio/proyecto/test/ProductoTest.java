package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Imagen;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ProductoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

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
        try {
            List<Imagen> listaImagenes = new ArrayList<>();
            List<Categoria> listaCategoria = new ArrayList<>();

            ProductoDTO productoDTO = new ProductoDTO("Sombras", "Color Nude", 10, 15000, 1, listaImagenes, listaCategoria);

            productoServicio.crearProducto(productoDTO);

            Assertions.assertNotNull(productoDTO);

            System.out.println(productoDTO.getNombre());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }





}
