package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;

public interface UsuarioServicio
{
    int crearUsuario(UsuarioDTO usuarioDTO);

    int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO);

    int eliminiarUsuario(int codigoUsuario);

    UsuarioDTO obtenerUsuario(int codigoUsuario);

}
