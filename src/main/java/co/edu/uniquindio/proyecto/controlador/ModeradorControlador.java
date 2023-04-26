package co.edu.uniquindio.proyecto.controlador;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/moderador")
@AllArgsConstructor
public class ModeradorControlador
{

    @Autowired
    private final ModeradorServicio moderadorServicio;

    @PutMapping("aprobar/{codigo}")
    public ResponseEntity<MensajeDTO> aprobar (@PathVariable int codigo)throws Exception
    {
        moderadorServicio.aprobar(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, " Aprobado correctamente"));

    }

    @PutMapping("rechazar/{codigo}")
    public ResponseEntity<MensajeDTO> rechazar (@PathVariable int codigo)throws Exception
    {
        moderadorServicio.rechazar(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Rechazado correctamente"));

    }


}