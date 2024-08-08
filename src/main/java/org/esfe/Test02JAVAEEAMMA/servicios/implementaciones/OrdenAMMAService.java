package org.esfe.Test02JAVAEEAMMA.servicios.implementaciones;

import org.esfe.Test02JAVAEEAMMA.modelos.OrdenAMMA;
import org.esfe.Test02JAVAEEAMMA.repositorios.IOrdenAMMARepository;
import org.esfe.Test02JAVAEEAMMA.servicios.interfaces.IOrdenAMMAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenAMMAService implements IOrdenAMMAService {

    @Autowired
    private IOrdenAMMARepository ordenRepository;

    @Override
    public Page<OrdenAMMA> buscarTodosPaginados(Pageable pageable) {
        return ordenRepository.findAll(pageable);
    }

    @Override
    public List<OrdenAMMA> obtenerTodos() {
        return ordenRepository.findAll();
    }

    @Override
    public OrdenAMMA buscarPorId(Long id) {
        Optional<OrdenAMMA> ordenOptional = ordenRepository.findById(id);
        if (ordenOptional.isPresent()) {
            return ordenOptional.get();
        } else {
            throw new RuntimeException("Orden no encontrada con ID: " + id); // O lanzar una excepción personalizada
        }
    }

    @Override
    public OrdenAMMA crearOEditar(OrdenAMMA ordenAMMA) {
        return ordenRepository.save(ordenAMMA);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (ordenRepository.existsById(id)) {
            ordenRepository.deleteById(id);
        } else {
            throw new RuntimeException("Orden no encontrada con ID: " + id); // O lanzar una excepción personalizada
        }
    }
}
