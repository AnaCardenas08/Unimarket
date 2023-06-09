package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.Interfaz.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio
{
    private final UsuarioRepo usuarioRepo;
    private EmailServicio emailServicio;
    private final PasswordEncoder passwordEncoder;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception
    {

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());

        if(buscado!=null)
        {
            throw new Exception("El correo "+usuarioDTO.getEmail()+" ya está en uso");
        }

        Usuario usuario = convertir(usuarioDTO);
        return usuarioRepo.save( usuario ).getCodigo();
    }

    @Override
    public int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception
    {

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());

        if(buscado!=null)
        {
            throw new Exception("El correo "+usuarioDTO.getEmail()+" ya está en uso");
        }

        validarExiste(codigoUsuario);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCodigo(codigoUsuario);

        return usuarioRepo.save(usuario).getCodigo();
    }

    @Override
    public int eliminiarUsuario(int codigoUsuario) throws Exception
    {
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception
    {
        return convertir( obtener(codigoUsuario) );
    }

    public Usuario obtener(int codigoUsuario) throws Exception
    {
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if(usuario.isEmpty() )
        {

            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

        return usuario.get();
    }

//    public void enviarLinkRecuperacion(String correo) throws Exception
//    {
//        emailServicio.enviarEmail(new EmailDTO("Recuperacion password", "Para recupear la contraseña ingrese a: []", correo) );
//    }

    @Override

    public boolean cambiarPassword(String correo, String passwordNueva ) throws Exception
    {

        Usuario usuario = usuarioRepo.findByEmail(correo).orElse(null);

        if(usuario==null)
        {
            throw new Exception("El cliente no se encontro con el correo ingresado");
        }

        usuario.setPassword( passwordEncoder.encode(passwordNueva) );
        usuarioRepo.save(usuario);

        return true;
    }


    private void validarExiste(int codigoUsuario) throws Exception
    {
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if( !existe )
        {
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

    }

    private UsuarioGetDTO convertir(Usuario usuario)
    {

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCodigo(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getTelefono());

        return usuarioDTO;
    }
    private Usuario convertir(UsuarioDTO usuarioDTO)
    {

        Usuario usuario = new Usuario();
        usuario.setNombre( usuarioDTO.getNombre() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setDireccion( usuarioDTO.getDireccion() );
        usuario.setTelefono( usuarioDTO.getTelefono() );
        usuario.setPassword( passwordEncoder.encode( usuarioDTO.getPassword() ));

        return usuario;
    }

}
 