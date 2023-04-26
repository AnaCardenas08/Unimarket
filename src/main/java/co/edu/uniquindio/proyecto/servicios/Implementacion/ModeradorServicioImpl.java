package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.entidades.Disponibilidad;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//Pablo Andres Sanchez
@Service
@AllArgsConstructor
public class ModeradorServicioImpl  implements ModeradorServicio
{
    //Pablo Andres Sanchez
    private final ProductoServicio productoServicio;

    //Pablo Andres Sanchez
    @Override
    public void aprobar(int codigoP) throws Exception
    {
        productoServicio.actualizarEstado(codigoP, Disponibilidad.APROBADO);

    }

    //Pablo Andres Sanchez
    @Override
    public void rechazar(int codigoP) throws Exception
    {
        productoServicio.actualizarEstado(codigoP, Disponibilidad.RECHAZADO);
    }
}
