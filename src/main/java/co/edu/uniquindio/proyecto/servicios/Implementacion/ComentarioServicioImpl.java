package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Calificacion;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Diego Alejandro Lopez
@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio
{

    private final ComentarioRepo comentarioRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;

    //Diego Alejandro Lopez
    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception
    {
        Comentario comentario = new Comentario();

        comentario.setDescripcion(comentarioDTO.getMensaje());
        comentario.setUsuario( usuarioServicio.obtener( comentarioDTO.getCodigoUsuario()) );
        comentario.setProducto(productoServicio.obtener(comentarioDTO.getCodigoProducto()));
        comentario.setCalificacion(comentarioDTO.getCalificacion());

        return comentarioRepo.save( comentario ).getCodigo();
    }

    //Diego Alejandro Lopez
    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto)
    {
        List<Comentario> lista = comentarioRepo.listarComentarios(codigoProducto);
        List<ComentarioGetDTO> respuesta = new ArrayList<>();

        for(Comentario c : lista )
        {
            respuesta.add( convertir(c) );
        }
        return respuesta;
    }

    //Diego Alejandro Lopez
    public ComentarioGetDTO convertir(Comentario comentario)
    {

        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                comentario.getCodigo(),
                comentario.getFecha(),
                comentario.getDescripcion(),
                comentario.getUsuario().getCodigo(),
                comentario.getProducto().getCodigo(),
                comentario.getCalificacion()
        );

        return comentarioGetDTO;
    }

    //Diego Alejandro Lopez
    @Override
    public int actualizarCalificacion(int codigoComentario, Calificacion calificacion) throws Exception
    {

        validarExiste(codigoComentario);

        if (calificacion==null)
        {
            throw new Exception("Tiene que calificar el producto");
        }

        Comentario comentario = obtener(codigoComentario);
        comentario.setCalificacion(calificacion);

        return comentarioRepo.save(comentario).getCodigo();

    }

    //Diego Alejandro Lopez
    private void validarExiste(int codigoComentario) throws Exception
    {
        boolean existe = comentarioRepo.existsById(codigoComentario);

        if( !existe )
        {
            throw new Exception("El código "+codigoComentario+" no está asociado a ningún comentario");
        }

    }

    //Diego Alejandro Lopez
    public Comentario obtener(int codigoComentario) throws Exception
    {
        Optional<Comentario> comentario = comentarioRepo.findById(codigoComentario);

        if(comentario.isEmpty() )
        {

            throw new Exception("El código "+codigoComentario+" no está asociado a ninguna calificacion");
        }

        return comentario.get();
    }

    //Diego Alejandro Lopez
    public ComentarioGetDTO obtenerComentario(int codigoComentario)  throws Exception
    {
        return convertir( obtener(codigoComentario) );
    }

}