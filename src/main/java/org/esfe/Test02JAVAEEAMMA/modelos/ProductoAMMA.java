package org.esfe.Test02JAVAEEAMMA.modelos;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "ProductoAMMA")
public class ProductoAMMA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    private String nombreAMMA;

    @OneToMany(mappedBy = "productoAMMA", cascade = CascadeType.ALL)
    private List<DetalleOrdenAMMA> detallesOrdenAMMA;

    
    public Long getId() {
        return id;
    }

    public String getNombreAMMA() {
        return nombreAMMA;
    }

    public List<DetalleOrdenAMMA> getDetallesOrdenAMMA() {
        return detallesOrdenAMMA;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreAMMA(String nombreAMMA) {
        this.nombreAMMA = nombreAMMA;
    }

    public void setDetallesOrdenAMMA(List<DetalleOrdenAMMA> detallesOrdenAMMA) {
        this.detallesOrdenAMMA = detallesOrdenAMMA;
    }
}
