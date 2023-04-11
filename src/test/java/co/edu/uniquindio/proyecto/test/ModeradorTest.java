package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ModeradorServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.junit.jupiter.api.Assertions;

import java.util.List;

@SpringBootTest
@Transactional
public class ModeradorTest {
    @Autowired
    private ModeradorServicio moderadorServicio; // Se declara una variable de tipo interface MOderadorServcio para poder utilizar el método .login



    @Test
    @Sql("classpath:dataset.sql")
    public void login(){
        try {

            Moderador moderador = moderadorServicio.login("alejandro.gutierrez@gmail.com","01");
            Assertions.assertNotNull(moderador);
            // se hace uso de la clase Assertions para validar que no esta vacio, es como una afirmación
       }catch (Exception e){
            throw new RuntimeException(e);
        }
    }




    // preguntarle al profesor como convierto, para pode utilizar la clase DTO
    //No converter found capable of converting from type [co.edu.uniquindio.proyecto.entidades.Moderador] to type [co.edu.uniquindio.proyecto.dto.ModeradorDTO]



//    @Test
//    @Sql("classpath:dataset.sql")
//    public void listarProductosDisponibilidad() {
//        Genero genero = Genero.ACCION;
//        List<Pelicula> lista = administradorPlataformaServicio.listarPeliculasPorGenero(genero);
//        lista.forEach(System.out::println);
//    }





//    @Test
//    @Sql("classpath:dataset.sql")
//    public void registrarModeradorTest() {
//
//        try {
//            ModeradorDTO usuarioDTO = new ModeradorDTO("Pepito 1", "pepe1@email.com", "1234");
//            moderadorServicio.crearModerador(usuarioDTO);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    // CTRL + MAYUSQ + /
}
