package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(scope= Producto.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Producto {
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

    public Producto(Integer id, String nombre, String descripcion, Double precio, Integer stockActual, Integer stockMinimo, Unidad unidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.unidad = unidad;
    }

    public Producto(){}

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

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
