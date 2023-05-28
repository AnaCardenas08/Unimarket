package co.edu.uniquindio.proyecto.controlador;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.entidades.Calificacion;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ComentarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Diego Alejandro Lopez
@RestController
@AllArgsConstructor
@RequestMapping("/api/comentarios")
public class ComentarioControlador
{
    //Diego Alejandro Lopez
    private final ComentarioServicio comentarioServicio;

    //Diego Alejandro Lopez
    @PostMapping("/crearComentario")
    public ResponseEntity<MensajeDTO> crearComentario(@Valid @RequestBody ComentarioDTO comentario) throws Exception
    {

        comentarioServicio.crearComentario(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
                false, "Comentario publicado con exito"));

    }

    //Diego Alejandro Lopez
    @GetMapping("/listarComentarios/{codigoProducto}")
    public List<ComentarioGetDTO> listarComentarios(@PathVariable int codigoProducto)
    {

        return  comentarioServicio.listarComentarios(codigoProducto);
    }

    //Diego Alejandro Lopez
    @PutMapping("/actualizarCalificacion/{codigoComentario}/{calificacion}")
    public ResponseEntity<MensajeDTO> actualizarCalificacion( @PathVariable int codigoComentario, @PathVariable Calificacion calificacion) throws Exception
    {

        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.actualizarCalificacion(codigoComentario,calificacion)));
    }


    //Diego Alejandro Lopez
    @GetMapping("/obtenerComentario/{codigoComentario}")
    public ResponseEntity<MensajeDTO> obtenerComentario( @PathVariable int codigoComentario)  throws Exception
    {

        return  ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.obtenerComentario(codigoComentario)));
    }


}
