package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Disponibilidad;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio
{
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;

    @Override
    public int crearProducto(ProductoDTO productoDTO)  throws Exception
    {
        Producto producto = new Producto();

        producto.setNombre( productoDTO.getNombre() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setUsuario( usuarioServicio.obtener( productoDTO.getCodigoUsuario() ) );
        producto.setImagen( productoDTO.getImagenes() );
        producto.setCategorias( productoDTO.getCategorias() );

        return productoRepo.save( producto ).getCodigo();
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO)  throws Exception
    {
        Producto buscado = productoRepo.buscarProducto(productoDTO.getCodigoUsuario());

        if(buscado!=null)
        {
            throw new Exception("El usuario "+productoDTO.getCodigoUsuario()+" ya tiene creado este producto ");
        }

        validarExiste(codigoProducto);

        Producto producto = convertir(productoDTO);
        producto.setCodigo(codigoProducto);


        return productoRepo.save( producto ).getCodigo();
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades)  throws Exception
    {
        validarExiste(codigoProducto);

        if (unidades<0)
        {
            throw new Exception("Las unidades no pueden ser menores a 0");
        }

        Producto producto = obtener(codigoProducto);
        producto.setUnidades(unidades);

        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int actualizarEstado(int codigoProducto, Disponibilidad disponibilidad)  throws Exception
    {
        validarExiste(codigoProducto);

        if (disponibilidad==null)
        {
            throw new Exception("La disponibilidad no puede ser nula");
        }

        Producto producto = obtener(codigoProducto);
        producto.setDisponibilidad(disponibilidad);

        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int eliminarProducto(int codigoProducto)  throws Exception
    {
        validarExiste(codigoProducto);

        productoRepo.deleteById(codigoProducto);

        return codigoProducto;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto)  throws Exception
    {
        return convertir( obtener(codigoProducto) );
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario)  throws Exception
    {
        List<Producto> lista = productoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria)  throws Exception
    {
        //usar member of para lista de element collections (son varios)
        List<Producto> lista = productoRepo.listarProductosCategoria(categoria);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Disponibilidad disponibilidad)  throws Exception
    {
        // este es una lista de enum pero estamos mirando por uno solo no todos los datos de la lista (uno solo)
        List<Producto> lista = productoRepo.listarProductosEstado(disponibilidad);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario)  throws Exception
    {
        List<Producto> lista = productoRepo.listarProductosFavoritos(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre, Categoria categoria)  throws Exception
    {
        List<Producto> lista = productoRepo.listarProductosNombre(nombre, categoria);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo)  throws Exception
    {
        List<Producto> lista = productoRepo.listarProductosPrecio(precioMinimo, precioMaximo);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public void crearFavorito(int codigoUsuario, int codigoProducto) throws Exception
    {
        Usuario usuario = usuarioServicio.obtener(codigoUsuario);
        Producto producto = obtener(codigoProducto);

        usuario.getProductoFavorito().add(producto);

    }

    @Override
    public void eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception
    {
        Usuario usuario = usuarioServicio.obtener(codigoUsuario);
        Producto producto = obtener(codigoProducto);

        usuario.getProductoFavorito().remove(producto);

    }

    private void validarExiste(int codigoProducto) throws Exception
    {
        boolean existe = productoRepo.existsById(codigoProducto);

        if( !existe )
        {
            throw new Exception("El código "+codigoProducto+" no está asociado a ningún producto");
        }

    }

    private Producto convertir(ProductoDTO productoDTO)
    {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setCodigo( productoDTO.getCodigoUsuario() );
        producto.setImagen( productoDTO.getImagenes() );
        producto.setCategorias( productoDTO.getCategorias());

        return producto;
    }

    private ProductoGetDTO convertir(Producto producto)
    {

        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                producto.getDisponibilidad(),
                producto.getFechaLimite(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getUsuario().getCodigo(),
                producto.getImagen(),
                producto.getCategorias()
        );

        return productoGetDTO;
    }

    @Override
    public Producto obtener(int codigoProducto) throws Exception
    {
        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if(producto.isEmpty() )
        {

            throw new Exception("El código "+codigoProducto+" no está asociado a ningún producto");
        }

        return producto.get();
    }




}