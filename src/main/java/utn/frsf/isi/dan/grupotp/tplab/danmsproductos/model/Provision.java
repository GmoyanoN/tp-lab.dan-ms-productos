package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Provision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fechaProvision;
    @OneToOne
    private ProvisionDetalle provisionDetalle;

    public Provision(Integer id, LocalDate fechaProvision) {
        this.id = id;
        this.fechaProvision = fechaProvision;
    }

    public Provision() {
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public LocalDate getFechaProvision() {return fechaProvision;}

    public void setFechaProvision(LocalDate fechaProvision) {this.fechaProvision = fechaProvision;}
}
