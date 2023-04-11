package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.servicios.Interfaz.EmailServicio;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
@AllArgsConstructor
public class EmailServicioImpl implements EmailServicio
{

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean enviarEmail (String asunto, String contenido, String destinatario)
    {

        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);


        try {
            helper.setSubject(asunto);
            helper.setText(contenido, true);
            helper.setTo(destinatario);
            helper.setFrom("no_reply@unicine.com");

            javaMailSender.send(mensaje);

            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

}
