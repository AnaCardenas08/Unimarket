package co.edu.uniquindio.proyecto.servicios.Interfaz;

import co.edu.uniquindio.proyecto.dto.EmailDTO;

public interface EmailServicio
{
    boolean enviarEmail(String asunto, String contenido, String destinatario) throws Exception;

}
