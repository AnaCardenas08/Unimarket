package co.edu.uniquindio.proyecto.servicios.Interfaz;

import co.edu.uniquindio.proyecto.dto.EmailDTO;

public interface EmailServicio
{
    void enviarEmail( EmailDTO emailDTO ) throws Exception;

}
