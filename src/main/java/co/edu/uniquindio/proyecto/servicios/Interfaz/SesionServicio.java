package co.edu.uniquindio.proyecto.servicios.Interfaz;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;

public interface SesionServicio
{

    TokenDTO login(SesionDTO sesionDTO);


}
