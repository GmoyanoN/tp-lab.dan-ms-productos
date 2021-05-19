package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(scope= Material.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stockActual;
    private Integer stockMinimo;
    @OneToOne
    private Unidad unidad;

    public Material(Integer id, String nombre, String descripcion, Double precio, Integer stockActual, Integer stockMinimo, Unidad unidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.unidad = unidad;
    }

    public Material (){}

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
