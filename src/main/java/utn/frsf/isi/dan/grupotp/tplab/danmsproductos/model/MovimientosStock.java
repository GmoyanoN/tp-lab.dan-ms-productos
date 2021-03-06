package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(scope = MovimientosStock.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MovimientosStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cantidadEntrada;
    private Integer cantidadSalida;
    private Instant Fecha;
    @OneToOne
    private Material material;
    @OneToOne
    private ProvisionDetalle provisionDetalle;
    @Transient
    private DetallePedido detallePedido;

    public MovimientosStock(Integer id, Integer cantidadEntrada, Integer cantidadSalida, Instant fecha, Material material, ProvisionDetalle provisionDetalle, DetallePedido detallePedido) {
        this.id = id;
        this.cantidadEntrada = cantidadEntrada;
        this.cantidadSalida = cantidadSalida;
        this.Fecha = fecha;
        this.material = material;
        this.provisionDetalle = provisionDetalle;
        this.detallePedido = detallePedido;
    }

    public MovimientosStock(){}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getCantidadEntrada() {return cantidadEntrada; }

    public void setCantidadEntrada(Integer cantidadEntrada) { this.cantidadEntrada = cantidadEntrada; }

    public Integer getCantidadSalida() {return cantidadSalida;}

    public void setCantidadSalida(Integer cantidadSalida) {this.cantidadSalida = cantidadSalida; }

    public Instant getFecha() { return Fecha; }

    public void setFecha(Instant fecha) {Fecha = fecha;}
}
