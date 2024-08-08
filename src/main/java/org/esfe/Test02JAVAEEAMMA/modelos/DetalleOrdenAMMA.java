package org.esfe.Test02JAVAEEAMMA.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "DetalleOrdenAMMA")
public class DetalleOrdenAMMA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La cantidad es requerida")
    private Integer cantidadAMMA;

    @NotNull(message = "El precio es requerido")
    private Double precioAMMA;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoAMMA productoAMMA;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private OrdenAMMA ordenAMMA;

    public Long getId() {
        return id;
    }

    public Integer getCantidadAMMA() {
        return cantidadAMMA;
    }

    public Double getPrecioAMMA() {
        return precioAMMA;
    }

    public ProductoAMMA getProductoAMMA() {
        return productoAMMA;
    }

    public OrdenAMMA getOrdenAMMA() {
        return ordenAMMA;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCantidadAMMA(Integer cantidadAMMA) {
        this.cantidadAMMA = cantidadAMMA;
    }

    public void setPrecioAMMA(Double precioAMMA) {
        this.precioAMMA = precioAMMA;
    }

    public void setProductoAMMA(ProductoAMMA productoAMMA) {
        this.productoAMMA = productoAMMA;
    }

    public void setOrdenAMMA(OrdenAMMA ordenAMMA) {
        this.ordenAMMA = ordenAMMA;
    }
}
