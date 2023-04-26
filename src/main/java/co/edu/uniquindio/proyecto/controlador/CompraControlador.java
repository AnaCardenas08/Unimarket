package co.edu.uniquindio.proyecto.controlador;


import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.Interfaz.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compra")
@AllArgsConstructor

public class CompraControlador
{
    private final CompraServicio compraServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCompra(@RequestBody CompraDTO compraDTO)  throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, compraServicio.crearCompra(compraDTO)) );
    }

    @GetMapping("/obtener/{codigoCompra}")
    public ResponseEntity<MensajeDTO> obtenerCompra(@PathVariable int codigoCompra) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, compraServicio.obtenerCompra(codigoCompra)));
    }


    @GetMapping("/listar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> listarComprasUsuario(@PathVariable int codigoUsuario) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, compraServicio.listarComprasUsuario(codigoUsuario)));
    }
}