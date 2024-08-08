package org.esfe.Test02JAVAEEAMMA.modelos;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "OrdenAMMA")
public class OrdenAMMA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAMMA;

    @OneToMany(mappedBy = "ordenAMMA", cascade = CascadeType.ALL)
    private List<DetalleOrdenAMMA> detallesOrdenAMMA;

     
    public Long getId() {
        return id;
    }

    public LocalDate getFechaAMMA() {
        return fechaAMMA;
    }

    public List<DetalleOrdenAMMA> getDetallesOrdenAMMA() {
        return detallesOrdenAMMA;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaAMMA(LocalDate fechaAMMA) {
        this.fechaAMMA = fechaAMMA;
    }

    public void setDetallesOrdenAMMA(List<DetalleOrdenAMMA> detallesOrdenAMMA) {
        this.detallesOrdenAMMA = detallesOrdenAMMA;
    }
}
