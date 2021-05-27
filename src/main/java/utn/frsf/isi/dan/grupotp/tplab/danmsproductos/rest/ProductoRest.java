package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model.DetallePedido;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model.MovimientosStock;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model.Producto;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model.Wrapper;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.servicie.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoRest {
    private final ProductoService productoService;
    @Autowired
    public ProductoRest(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> buscarTodos(){
        return ResponseEntity.ok(productoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Integer id){
        return ResponseEntity.of(productoService.buscarProductoPorId(id));
    }

    @GetMapping("/producto")
    public ResponseEntity<List<Producto>> buscarProdcuto(@RequestParam(required = false) String nombre, @RequestParam(required = false) Integer stock, @RequestParam(required = false) Double precio){
        return ResponseEntity.of(productoService.buscarProductos(nombre, stock, precio));
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }

    @PostMapping("/mvms-stock")
    public ResponseEntity<String> crearMovimientoStock(@RequestBody Wrapper wrapper){
        return ResponseEntity.ok(productoService.crearMovimientosStock(wrapper.getDetallePedido()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto){
        return ResponseEntity.of(productoService.actualizarProducto(producto, id));
    }
}
