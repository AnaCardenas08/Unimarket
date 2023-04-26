package co.edu.uniquindio.proyecto.controlador;

import co.edu.uniquindio.proyecto.dto.ForoDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.entidades.Foro;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ForoServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/foro")
@AllArgsConstructor
public class ForoControlador
{
    @Autowired
    private final ForoServicio foroServicio;

    @PostMapping("/crearForo")
    public ResponseEntity<MensajeDTO> crearForo(@RequestBody ForoDTO foroDTO)  throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, foroServicio.crearComentarioForo(foroDTO) ));
    }


    @GetMapping("/listarComentarioForo/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> listarComentariosForo(@PathVariable int codigoUsuario) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, foroServicio.listarComentariosForo(codigoUsuario)));
    }

}
