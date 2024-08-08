package org.esfe.Test02JAVAEEAMMA.servicios.interfaces;

import org.esfe.Test02JAVAEEAMMA.modelos.DetalleOrdenAMMA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDetalleOrdenAMMAService {
    Page<DetalleOrdenAMMA> buscarTodosPaginados(Pageable pageable);

    List<DetalleOrdenAMMA> obtenerTodos();

    DetalleOrdenAMMA buscarPorId(Long id);

    DetalleOrdenAMMA crearOEditar(DetalleOrdenAMMA detalleOrdenAMMA);

    void eliminarPorId(Long id);
}
