package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.servicios.Interfaz.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Pablo Andres Sanchez
@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio
{
    //Pablo Andres Sanchez
    private final CompraRepo compraRepo;
    private final UsuarioServicio usuarioServicio;

    //Pablo Andres Sanchez
    @Override
    public int crearCompra(CompraDTO compraDTO)  throws Exception
    {
        Compra compra = new Compra();

        compra.setUsuario( usuarioServicio.obtener( compraDTO.getCodigoUsuario()));
        compra.setMetodoPago( compraDTO.getMetodoPago());
        compra.setTotalPago(compraDTO.getTotalPago());

        return compraRepo.save( compra ).getCodigo();
    }

//    @Override
//    public int crearCompra(CompraDTO compraDTO) throws Exception
//    {
//
//        Compra buscado = compraRepo.buscarCompra(compraDTO.getCodigoCompra());
//
//        if(buscado!=null)
//        {
//            throw new Exception("El codigo "+compraDTO.getCodigoCompra()+" ya está en uso");
//        }
//
//        Compra usuario = convertir(compraDTO);
//        return compraRepo.save( usuario ).getCodigo();
//    }

    //Pablo Andres Sanchez
    @Override
    public List<CompraGetDTO> listarComprasUsuario(int codigoUsuario)
    {

        List<Compra> listaCompra = compraRepo.listarComprasUsuario(codigoUsuario);
        List<CompraGetDTO> respuesta = new ArrayList<>();

        for (Compra c : listaCompra){
            respuesta.add(convertir(c));
        }

        return respuesta;

    }



    // ------------ OBTENER COMPRA VERSION PABLO ------

//    @Override
//    public Compra obtenerCompra(int codigoCompra) throws Exception {
//
//        Compra compra = compraRepo.buscarCompra(codigoCompra);
//
//        if(compra == null) throw new Exception("La compra no existe");
//
//          return compra;
//
//
//    }

    //Pablo Andres Sanchez
    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) throws Exception
    {
        return convertir( obtener (codigoCompra) );
    }

    public Compra obtener(int codigoCompra) throws Exception
    {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);

        if(compra.isEmpty() )
        {

            throw new Exception("El código "+codigoCompra+" no está asociado a ninguna compra");
        }

        return compra.get();
    }


    //Pablo Andres Sanchez
    private CompraGetDTO convertir (Compra compra)
    {

        CompraGetDTO compraDTO = new CompraGetDTO(
                compra.getCodigo(),
                compra.getFechaCompra(),
                compra.getTotalPago(),
                compra.getUsuario().getCodigo(),
                compra.getMetodoPago()
                //dudas sobre detalleProducto
        );

        return compraDTO;
    }

    //---- MOSTRAR AL USUARIO

    //Pablo Andres Sanchez

    private Compra convertir (CompraDTO compraDTO) throws Exception
    {

        Compra compra = new Compra();

        compra.setUsuario(usuarioServicio.obtener(compraDTO.getCodigoUsuario()));
        compra.setMetodoPago(compraDTO.getMetodoPago());

        return compra;
    }

}
