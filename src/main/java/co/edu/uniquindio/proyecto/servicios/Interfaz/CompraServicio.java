package co.edu.uniquindio.proyecto.servicios.Interfaz;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.entidades.Compra;

import java.util.List;

//Pablo Andres Sanchez
public interface CompraServicio
{
    //Pablo Andres Sanchez
    int crearCompra(CompraDTO compraDTO) throws Exception;

    //Pablo Andres Sanchez
    List<CompraGetDTO> listarComprasUsuario (int codigoUsuario) throws Exception;

    //Pablo Andres Sanchez
    CompraGetDTO obtenerCompra(int codigoCompra) throws Exception;

    //Pablo Andres Sanchez
    Compra obtener(int codigoCompra) throws Exception;


}
