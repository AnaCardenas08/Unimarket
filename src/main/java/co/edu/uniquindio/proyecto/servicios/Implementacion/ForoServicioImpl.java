package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.dto.ForoDTO;
import co.edu.uniquindio.proyecto.dto.ForoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Foro;
import co.edu.uniquindio.proyecto.repositorios.ForoRepo;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ForoServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
//Pablo Andres Sanchez
@Service
@AllArgsConstructor
public class ForoServicioImpl implements ForoServicio
{
    //Pablo Andres Sanchez
    private final ForoRepo foroRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;


    //Pablo Andres Sanchez
    @Override
    public List<ForoGetDTO> listarComentariosForo(int codigoUsuario)
    {

        List<Foro> listaComentarios = foroRepo.listarComentarios(codigoUsuario);
        List<ForoGetDTO> respuesta = new ArrayList<>();

        for (Foro c : listaComentarios){
            respuesta.add(convertir(c));
        }

        return respuesta;

    }


    // -------  CONVERTIR PARA LISTAR -----

    //Pablo Andres Sanchez
    private ForoGetDTO convertir (Foro foro)
    {

        ForoGetDTO foroGetDTO = new ForoGetDTO(
                foro.getCodigo(),
                foro.getComentarios(),
                foro.getProducto().getCodigo(),
                foro.getUsuario().getCodigo()
        );

        return foroGetDTO;
    }

// --------- CONVERTIR PARA CREAR -----

    //Pablo Andres Sanchez
    private Foro convertir (ForoDTO foroDTO) throws Exception
    {

        Foro foro = new Foro();

        foro.setComentarios(foroDTO.getComentario());

        foro.setUsuario(usuarioServicio.obtener(foroDTO.getCodigoUsuario()));

        foro.setProducto(productoServicio.obtener(foroDTO.getCodigoProducto()));


        return foro;
    }

    //Pablo Andres Sanchez
    @Override
    public int crearComentarioForo (ForoDTO foroDTO)  throws Exception
    {
        Foro compra = new Foro();

        compra.setComentarios( foroDTO.getComentario());
        compra.setProducto(productoServicio.obtener(foroDTO.getCodigoProducto()));
        compra.setUsuario(usuarioServicio.obtener(foroDTO.getCodigoUsuario()));



        return foroRepo.save( compra ).getCodigo();
    }



}
