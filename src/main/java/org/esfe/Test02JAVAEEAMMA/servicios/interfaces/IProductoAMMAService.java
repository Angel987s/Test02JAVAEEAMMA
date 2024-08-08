package org.esfe.Test02JAVAEEAMMA.servicios.interfaces;

import org.esfe.Test02JAVAEEAMMA.modelos.ProductoAMMA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoAMMAService {
    Page<ProductoAMMA> buscarTodosPaginados(Pageable pageable);

    List<ProductoAMMA> obtenerTodos();

    ProductoAMMA buscarPorId(Long id);

    ProductoAMMA crearOEditar(ProductoAMMA productoAMMA);

    void eliminarPorId(Long id);
}
