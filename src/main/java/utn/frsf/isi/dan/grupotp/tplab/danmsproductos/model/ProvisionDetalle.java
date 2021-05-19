package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    private Material material;

    public ProvisionDetalle(Integer id, Integer cantidad, Provision provision, Material material) {
        this.id = id;
        this.cantidad = cantidad;
        this.provision = provision;
        this.material = material;
    }

    public ProvisionDetalle() {
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getCantidad() {return cantidad;}

    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
}
