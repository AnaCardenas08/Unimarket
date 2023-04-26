package co.edu.uniquindio.proyecto.controlador;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Disponibilidad;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ProductoServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@AllArgsConstructor
public class ProductoControlador
{

    private final ProductoServicio productoServicio;

    @PostMapping("/crearProducto")
    public ResponseEntity<MensajeDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO)  throws Exception
    {

        productoServicio.crearProducto(productoDTO);

        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, " Creado correctamente"));

    }

    @PutMapping("/actualizarProducto/{codigoProducto}")
    public ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int codigoProducto, @Valid @RequestBody ProductoGetDTO productoGetDTO) throws Exception
    {
        productoServicio.actualizarProducto(codigoProducto, productoGetDTO);

        return  ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarProducto(codigoProducto, productoGetDTO)));
    }

    @PutMapping("/actualizarProductoUni/{codigoProducto}/{unidades}")
    public ResponseEntity<MensajeDTO> actualizarUnidades(@PathVariable int codigoProducto, @PathVariable int unidades) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarUnidades(codigoProducto,unidades)));

    }

    @PutMapping("/actualizarProductoDis/{codigoProducto}")
    public ResponseEntity<MensajeDTO> actualizarEstado(@PathVariable int codigoProducto, @Valid @RequestBody Disponibilidad disponibilidad) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarEstado(codigoProducto,disponibilidad)));
    }

    @DeleteMapping("/eliminarProducto/{codigoProducto}")
    public ResponseEntity<MensajeDTO> eliminarProducto(@PathVariable  int codigoProducto) throws Exception
    {
        productoServicio.eliminarProducto(codigoProducto);

        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, " Eliminado correctamente"));

    }
    @PostMapping("/crearProductoFav/{codigoUsuario}/{codigoProducto}")
    public ResponseEntity<MensajeDTO> crearFavorito(@PathVariable  int codigoUsuario, @PathVariable  int codigoProducto)throws Exception
    {
        productoServicio.crearFavorito(codigoUsuario, codigoProducto);

        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, " Creado Favorito Correctamente"));
    }

    @DeleteMapping("/eliminarProductoFav/{codigoUsuario}/{codigoProducto}")
    public ResponseEntity<MensajeDTO> eliminarFavorito(@PathVariable  int codigoUsuario, @PathVariable  int codigoProducto)throws Exception
    {
        productoServicio.eliminarFavorito(codigoUsuario,codigoProducto);

        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, " Eliminado correctamente"));
    }

    @GetMapping("/obtenerProductosUsuario/{codigoUsuario}")
    List<ProductoGetDTO> listarProductosUsuario( @PathVariable int codigoUsuario)
    {
        return productoServicio.listarProductosUsuario(codigoUsuario);
    }

    @GetMapping("/obtenerProductosCategoria/")
    List<ProductoGetDTO> listarProductosCategoria( @Valid @RequestBody Categoria categoria)
    {
        return productoServicio.listarProductosCategoria(categoria);
    }

    @GetMapping("/obtenerProductosEstado/{disponibilidad}")
    List<ProductoGetDTO> listarProductosPorEstado( @PathVariable Disponibilidad disponibilidad)
    {
        return productoServicio.listarProductosPorEstado(disponibilidad);
    }

    @GetMapping("/obtenerProductosFavorito/{codigoUsuario}")
    List<ProductoGetDTO> listarProductosFavoritos( @PathVariable int codigoUsuario)
    {
        return productoServicio.listarProductosFavoritos(codigoUsuario);
    }

    @GetMapping("/obtenerProductosNombre/{nombre}")
    List<ProductoGetDTO> listarProductosNombre( @PathVariable  String nombre)
    {
        return productoServicio.listarProductosNombre(nombre);
    }

    @GetMapping("/obtenerProductosPrecio/{precioMinimo}/{precioMaximo}")
    List<ProductoGetDTO> listarProductosPrecio( @PathVariable float precioMinimo, @PathVariable  float precioMaximo)
    {
        return productoServicio.listarProductosPrecio(precioMinimo,precioMaximo);
    }

}
