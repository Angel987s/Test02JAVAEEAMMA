package org.esfe.Test02JAVAEEAMMA.servicios.implementaciones;

import org.esfe.Test02JAVAEEAMMA.modelos.DetalleOrdenAMMA;
import org.esfe.Test02JAVAEEAMMA.repositorios.IDetalleOrdenAMMARepository;
import org.esfe.Test02JAVAEEAMMA.servicios.interfaces.IDetalleOrdenAMMAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenAMMAService implements IDetalleOrdenAMMAService {

    @Autowired
    private IDetalleOrdenAMMARepository detalleOrdenRepository;

    @Override
    public Page<DetalleOrdenAMMA> buscarTodosPaginados(Pageable pageable) {
        return detalleOrdenRepository.findAll(pageable);
    }

    @Override
    public List<DetalleOrdenAMMA> obtenerTodos() {
        return detalleOrdenRepository.findAll();
    }

    @Override
    public DetalleOrdenAMMA buscarPorId(Long id) {
        Optional<DetalleOrdenAMMA> detalleOrdenOptional = detalleOrdenRepository.findById(id);
        if (detalleOrdenOptional.isPresent()) {
            return detalleOrdenOptional.get();
        } else {
            throw new RuntimeException("Detalle de Orden no encontrado con ID: " + id); // O lanzar una excepción personalizada
        }
    }

    @Override
    public DetalleOrdenAMMA crearOEditar(DetalleOrdenAMMA detalleOrdenAMMA) {
        return detalleOrdenRepository.save(detalleOrdenAMMA);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (detalleOrdenRepository.existsById(id)) {
            detalleOrdenRepository.deleteById(id);
        } else {
            throw new RuntimeException("Detalle de Orden no encontrado con ID: " + id); // O lanzar una excepción personalizada
        }
    }
}
