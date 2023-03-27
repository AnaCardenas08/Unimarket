package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ComentarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class ComentarioTest {
    @Autowired
    private ComentarioServicio comentarioServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentarioTest() {
        try {
            ComentarioDTO comentarioDTO = new ComentarioDTO("No me gusto el producto", 1, 3);
            comentarioServicio.crearComentario(comentarioDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
