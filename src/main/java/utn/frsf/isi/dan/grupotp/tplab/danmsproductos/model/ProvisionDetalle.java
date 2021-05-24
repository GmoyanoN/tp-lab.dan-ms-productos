package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(scope = ProvisionDetalle.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProvisionDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cantidad;
    @OneToOne
    private Provision provision;
    @OneToOne
    private Producto producto;

    public ProvisionDetalle(Integer id, Integer cantidad, Provision provision, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.provision = provision;
        this.producto = producto;
    }

    public ProvisionDetalle() {
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getCantidad() {return cantidad;}

    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
}
