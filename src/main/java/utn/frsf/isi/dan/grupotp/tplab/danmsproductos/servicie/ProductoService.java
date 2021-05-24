package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.servicie;

import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> buscarTodos();
    Producto crearProducto(Producto producto);
    Optional<Producto> actualizarProducto(Producto producto, Integer id);
    Optional<List<Producto>> buscarProductos(String nombre, Integer stock, Double precio);
}
