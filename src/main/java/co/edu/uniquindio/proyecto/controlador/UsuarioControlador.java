package co.edu.uniquindio.proyecto.controlador;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.Interfaz.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioControlador
{
    private final UsuarioServicio usuarioServicio;

    @PostMapping("/crearUsuario")
   public  int crearUsuario(@RequestBody UsuarioDTO usuarioDTO)  throws Exception
    {
        return usuarioServicio.crearUsuario(usuarioDTO);
    }

    @PutMapping("/actualizarUsuario/{codigoUsuario}")
    public int actualizarUsuario(@PathVariable int codigoUsuario, @RequestBody UsuarioDTO usuarioDTO) throws Exception
    {
        return usuarioServicio.actualizarUsuario(codigoUsuario,usuarioDTO);

    }

    @DeleteMapping("/eliminarUsuario/{codigoUsuario}")
    public int eliminiarUsuario(@PathVariable int codigoUsuario) throws Exception
    {
        return usuarioServicio.eliminiarUsuario(codigoUsuario);

    }

    @GetMapping("/obtenerUsuario/{codigoUsuario}")
    UsuarioGetDTO obtenerUsuario(@PathVariable int codigoUsuario) throws Exception
    {
        return usuarioServicio.obtenerUsuario(codigoUsuario);
    }


    @PostMapping("/cambiarPassword/{correo}") //Quedaria asi??
    public boolean cambiarPassword(@PathVariable String correo, @PathVariable String passwordNueva ) throws Exception
    {
        return usuarioServicio.cambiarPassword(correo, passwordNueva);

    }
}
