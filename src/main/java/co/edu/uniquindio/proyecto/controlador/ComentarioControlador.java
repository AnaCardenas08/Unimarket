package co.edu.uniquindio.proyecto.controlador;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Calificacion;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ComentarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comentarios")
public class ComentarioControlador
{

    private final ComentarioServicio comentarioServicio;

    @PostMapping("/crearComentario")
    public int crearComentario( @Valid @RequestBody ComentarioDTO comentarioDTO) throws Exception
    {

        return comentarioServicio.crearComentario(comentarioDTO);
    }

    @GetMapping("/listarComentarios/{codigoProducto}")
    public List<ComentarioGetDTO> listarComentarios(@PathVariable int codigoProducto)
    {

        return  comentarioServicio.listarComentarios(codigoProducto);
    }

    @PutMapping("/actualizarCalificacion/{codigoComentario}")
    public int actualizarCalificacion( @PathVariable int codigoComentario, @Valid @RequestBody Calificacion calificacion) throws Exception
    {

        return comentarioServicio.actualizarCalificacion(codigoComentario,calificacion);
    }

    @GetMapping("/obtener/{codigo}")
    public Comentario obtener(@PathVariable int codigo) throws Exception
    {

        return comentarioServicio.obtener(codigo);
    }

    @PutMapping("/convertir")
    public ComentarioGetDTO convertir(  @Valid @RequestBody Comentario comentario)
    {

        return comentarioServicio.convertir(comentario);
    }

    @GetMapping("/obtenerComentario/{codigoComentario}\"")
    public ComentarioGetDTO obtenerComentario( @PathVariable int codigoComentario)  throws Exception
    {

        return comentarioServicio.obtenerComentario(codigoComentario);
    }

}