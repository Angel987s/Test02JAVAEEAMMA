package org.esfe.Test02JAVAEEAMMA.servicios.implementaciones;

import org.esfe.Test02JAVAEEAMMA.modelos.ProductoAMMA;
import org.esfe.Test02JAVAEEAMMA.repositorios.IProductoAMMARepository;
import org.esfe.Test02JAVAEEAMMA.servicios.interfaces.IProductoAMMAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoAMMAService implements IProductoAMMAService {

    @Autowired
    private IProductoAMMARepository productoRepository;

    @Override
    public Page<ProductoAMMA> buscarTodosPaginados(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    public List<ProductoAMMA> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoAMMA buscarPorId(Long id) {
        Optional<ProductoAMMA> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            return productoOptional.get();
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id); // O lanzar una excepción personalizada
        }
    }

    @Override
    public ProductoAMMA crearOEditar(ProductoAMMA productoAMMA) {
        return productoRepository.save(productoAMMA);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id); // O lanzar una excepción personalizada
        }
    }
}
