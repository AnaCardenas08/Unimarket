package co.edu.uniquindio.proyecto.servicios.Implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.servicios.Interfaz.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.Interfaz.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        LocalDateTime fecha = LocalDateTime.now();

        compra.setUsuario( usuarioServicio.obtener( compraDTO.getCodigoUsuario()));
        compra.setMetodoPago( compraDTO.getMetodoPago());
        compra.setTotalPago(compraDTO.getTotalPago());
        compra.setFechaCompra(fecha);

        return compraRepo.save( compra ).getCodigo();
    }


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
