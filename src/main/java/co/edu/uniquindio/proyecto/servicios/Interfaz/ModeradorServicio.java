package co.edu.uniquindio.proyecto.servicios.Interfaz;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import org.springframework.data.domain.PageRequest;

public interface ModeradorServicio {


    Moderador login (String email, String password);

    // SPRING SECURITY


    // int crearModerador(ModeradorDTO moderadorDTO)  throws Exception;
}
