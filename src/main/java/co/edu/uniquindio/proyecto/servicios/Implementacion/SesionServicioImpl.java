package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.servicios.Interfaz.SesionServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SesionServicioImpl implements SesionServicio
{

    @Override
    public TokenDTO login(SesionDTO sesionDTO)

    {
        return null;
    }

    @Override
    public void logout(int codigoUsuario)
    {

    }
}
