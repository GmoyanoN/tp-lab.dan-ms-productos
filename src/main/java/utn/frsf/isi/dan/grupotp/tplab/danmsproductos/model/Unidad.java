package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Unidad {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String descripcion;


        public Unidad(Integer id, String descripcion) {
                this.id = id;
                this.descripcion = descripcion;
        }

        public Unidad() {}

        public Integer getId() {return id;}

        public void setId(Integer id) {this.id = id;}

        public String getDescripcion() {return descripcion;}

        public void setDescripcion(String descripcion) {this.descripcion = descripcion;
        }

}
