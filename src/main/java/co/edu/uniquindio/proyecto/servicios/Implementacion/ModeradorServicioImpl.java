package co.edu.uniquindio.proyecto.servicios.Implementacion;

//import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.entidades.Moderador;

import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.servicios.Interfaz.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio
{
    private final ModeradorRepo moderadorRepo;
    //private final ProductoGetDTO productoRepo;

    @Override
    public Moderador login(String email, String password){

        Moderador moderador = moderadorRepo.comprobarAutenticacion(email, password);

        if(moderador == null){

            return null;
        }
        System.out.println("moderador = " + moderador.getNombre());
        return moderador;

    }

//    private Moderador convertir( ModeradorDTO moderadorDTO){
//
//        Moderador m = new Moderador();
//
//        m.setEmail( moderadorDTO.getEmail() );
//        m.setPassword( moderadorDTO.getPassword() );
//
//        return m;
//    }



//    @Override
//    public int crearModerador(ModeradorDTO moderadorDTO) throws Exception
//    {
//
//        Moderador buscado = moderadorRepo.buscarModerador(moderadorDTO.getEmail());
//
//        if(buscado!=null)
//        {
//            throw new Exception("El correo "+moderadorDTO.getEmail()+" ya está en uso");
//        }
//
//        Moderador usuario = convertir(moderadorDTO);
//        return moderadorRepo.save( usuario ).getCodigo();
//    }



  /*  private ModeradorGetDTO convertir(Moderador moderador){

        ModeradorGetDTO usuarioDTO = new ModeradorGetDTO();
                moderador.getCodigo(),
                moderador.getNombre(),
                moderador.getEmail(),


        return usuarioDTO;
    }*/



}
