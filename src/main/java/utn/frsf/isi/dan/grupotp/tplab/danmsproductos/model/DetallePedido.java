package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model;

import java.io.Serializable;

public class DetallePedido implements Serializable {
    private static final long serialVersionUID= -6142650329999645598L;
    private Integer id;
    private Integer cantidad;
    private Integer productoId;

    public DetallePedido() {
    }

    public DetallePedido(Integer id, Integer cantidad, Integer productoId) {
        this.id = id;
        this.cantidad = cantidad;
        this.productoId = productoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }
}
