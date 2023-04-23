package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.servicios.Interfaz.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class EmailTest
{
    @Autowired
    private EmailServicio emailServicio;
    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void enviarEmail() throws Exception
    {
        EmailDTO emailDTO = new EmailDTO("Prueba", "Esta es una prueba", "anam.cardenasr2@uqvirtual.edu.co");
        emailServicio.enviarEmail(emailDTO);


    }

}
