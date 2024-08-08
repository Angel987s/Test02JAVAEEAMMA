package org.esfe.Test02JAVAEEAMMA.repositorios;

import org.esfe.Test02JAVAEEAMMA.modelos.ProductoAMMA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoAMMARepository extends JpaRepository<ProductoAMMA, Long> {
}