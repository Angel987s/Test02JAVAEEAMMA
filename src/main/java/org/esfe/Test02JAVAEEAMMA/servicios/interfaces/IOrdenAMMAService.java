package org.esfe.Test02JAVAEEAMMA.servicios.interfaces;

import org.esfe.Test02JAVAEEAMMA.modelos.OrdenAMMA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrdenAMMAService {
    Page<OrdenAMMA> buscarTodosPaginados(Pageable pageable);

    List<OrdenAMMA> obtenerTodos();

    OrdenAMMA buscarPorId(Long id);

    OrdenAMMA crearOEditar(OrdenAMMA ordenAMMA);

    void eliminarPorId(Long id);
}
