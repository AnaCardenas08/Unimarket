package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ForoDTO;
import co.edu.uniquindio.proyecto.dto.ForoGetDTO;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ForoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Pablo Andres Sanchez
@SpringBootTest
@Transactional
public class ForoTest
{
    //Pablo Andres Sanchez
    @Autowired
    private ForoServicio foroServicio;

    //Pablo Andres Sanchez
    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentarioForoTest()
    {

        try {

            ForoDTO comentario = new ForoDTO("que rico el helado", 5,5);
            foroServicio.crearComentarioForo(comentario);

            System.out.println("comentario = " + comentario.getComentario());

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    //Pablo Andres Sanchez
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosForoTest() throws Exception
    {

        List<ForoGetDTO> lista = foroServicio.listarComentariosForo(1);
        Assertions.assertEquals(2,lista.size());
        System.out.println("lista = " + lista);

    }

}