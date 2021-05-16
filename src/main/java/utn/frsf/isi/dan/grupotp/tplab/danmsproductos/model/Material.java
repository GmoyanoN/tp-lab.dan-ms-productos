package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model;

import com.fasterxml.jackson.annotation.*;

//import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Material {
   /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) */
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stockActual;
    private Integer stockMinimo;

    //TODO relaciones con las otras clases


    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre;}

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion; }

    public Double getPrecio() {return precio;}

    public void setPrecio(Double precio) { this.precio = precio;}

    public Integer getStockActual() {return stockActual; }

    public void setStockActual(Integer stockActual) {this.stockActual = stockActual;}

    public Integer getStockMinimo() { return stockMinimo; }

    public void setStockMinimo(Integer stockMinimo) { this.stockMinimo = stockMinimo; }
}
