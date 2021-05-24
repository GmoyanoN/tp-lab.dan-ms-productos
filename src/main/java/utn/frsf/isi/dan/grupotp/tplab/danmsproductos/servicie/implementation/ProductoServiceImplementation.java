package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.servicie.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model.Producto;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.repositories.ProductoRepository;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.servicie.ProductoService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImplementation implements ProductoService {
    private final ProductoRepository productoRepository;
    @Autowired
    public ProductoServiceImplementation(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Producto> buscarTodos(){
        return productoRepository.findAll();
    }

    public  Optional<List<Producto>> buscarProductos(String nombre, Integer stock, Double precio){
        return productoRepository.buscarProducto(nombre, stock, precio);
    }

    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public Optional<Producto> actualizarProducto(Producto producto, Integer id){
        if(productoRepository.existsById(id)){
            producto.setId(id);
            return Optional.of(productoRepository.save(producto));
        }
        return Optional.empty();
    }

}
