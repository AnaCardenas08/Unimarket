package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.servicios.Interfaz.SesionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class SesionTest
{
    @Autowired
    private SesionServicio sesionServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest() throws Exception
    {
        TokenDTO token = sesionServicio. login ( new SesionDTO("amorales@outlook.com","1234") );
        Assertions.assertNotNull(token);

    }

}
