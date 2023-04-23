package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.Interfaz.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UsuarioTest
{
    @Autowired

    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearUsuarioTest()
    {

        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO("Pepito 1", "pepe1@email.com", "1234", "Calle 123", "343");

            int codigo = usuarioServicio.crearUsuario(usuarioDTO);


        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarUsuarioTest()
    {
        try {
            usuarioServicio.eliminiarUsuario(1);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuarioTest()
    {
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO("Pepito Perez", "pepe1@email.com", "1234", "Calle 123", "2782");
            usuarioServicio.actualizarUsuario(1, usuarioDTO);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerUsuarioTest()
    {
        try {
            UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario(1);

            System.out.println(usuarioGetDTO);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarPasswordTest()
    {
        try {
            UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario(1);
            usuarioServicio.cambiarPassword("juanperez@gmail.com", "100");

            System.out.println(usuarioGetDTO);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }


}
