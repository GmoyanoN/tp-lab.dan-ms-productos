package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model;

import java.io.Serializable;
import java.util.List;

public class Wrapper implements Serializable {
    private List<DetallePedido> detallePedido;

    public Wrapper() {
    }

    public Wrapper(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }
}
