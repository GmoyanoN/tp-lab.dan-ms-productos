package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findAll();
    @Query("SELECT p FROM Producto p WHERE (:nombre is null or p.nombre like %:nombre%) and (:stock is null or p.stockActual >= :stock) and (:precio is null or p.precio = :precio)")
    Optional<List<Producto>> buscarProducto(String nombre, Integer stock, Double precio);
    //lo ideal sería que nos pasen 2 valores de precio y buscar en ese rango
}
