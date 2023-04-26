package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ProductoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

//Pablo Andres Sanchez
@SpringBootTest
@Transactional
public class ModeradorTest
{
    @Autowired
    private ModeradorServicio moderadorServicio; // Se declara una variable de tipo interface MOderadorServcio para poder utilizar el método .login


    @Test
    @Sql("classpath:dataset.sql")
    public void aprobar()
    {
        try
        {
            moderadorServicio.aprobar(1);


        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void rechazar ()
    {
        try
        {
            moderadorServicio.rechazar(1);


        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

}
