package utn.frsf.isi.dan.grupotp.tplab.danmsproductos.servicie.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.model.*;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.repositories.MovimientosStockRepository;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.repositories.ProductoRepository;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.repositories.ProvisionRepository;
import utn.frsf.isi.dan.grupotp.tplab.danmsproductos.servicie.ProductoService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImplementation implements ProductoService {
    private final ProductoRepository productoRepository;
    private final MovimientosStockRepository movimientosStockRepository;
    private final ProvisionRepository provisionRepository;
    private final JmsTemplate jms;
    @Autowired
    public ProductoServiceImplementation(ProductoRepository productoRepository, JmsTemplate jms, MovimientosStockRepository movimientosStockRepository, ProvisionRepository provisionRepository){
        this.productoRepository = productoRepository;
        this.jms = jms;
        this.movimientosStockRepository = movimientosStockRepository;
        this.provisionRepository = provisionRepository;
    }

    /*@JmsListener(destination = "COLA_PEDIDOS")
    public void handle(ObjectMessage objectMessage){
        try{
            //System.out.println(objectMessage.getObject());
            List<DetallePedidoDTO> detallePedido = (List<DetallePedidoDTO>) objectMessage.getObject();
        }catch(Exception e){
            e.printStackTrace();
        }

    }*/

    public List<Producto> buscarTodos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarProductoPorId(Integer id){
        return productoRepository.findById(id);
    }

    public  Optional<List<Producto>> buscarProductos(String nombre, Integer stock, Double precio){
        return productoRepository.buscarProducto(nombre, stock, precio);
    }

    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public String crearMovimientosStock(List<DetallePedido> detallePedidos){
        detallePedidos.forEach(dp->{
            MovimientosStock movimientosStock = new MovimientosStock();
            movimientosStock.setFecha(LocalDateTime.now());
            movimientosStock.setCantidadEntrada(0);
            movimientosStock.setCantidadSalida(dp.getCantidad());
            movimientosStock.setDetallePedidoId(dp.getId());
            movimientosStock.setProducto(productoRepository.findById(dp.getProductoId()).orElse(null));
            movimientosStock = movimientosStockRepository.save(movimientosStock);
            actualizarStock(movimientosStock);
        });
        return "Exito";
    }

    public Optional<Producto> actualizarProducto(Producto producto, Integer id){
        if(productoRepository.existsById(id)){
            producto.setId(id);
            return Optional.of(productoRepository.save(producto));
        }
        return Optional.empty();
    }

    private void actualizarStock(MovimientosStock movimientosStock){
        Producto p = movimientosStock.getProducto();
        p.setStockActual(p.getStockActual()+movimientosStock.getCantidadEntrada()-movimientosStock.getCantidadSalida());
        if(p.getStockActual()<=p.getStockMinimo()){
            //TODO tener en cuenta tiempo de aprovisionamiento
            Provision provision = new Provision();
            provision.setFechaProvision(LocalDateTime.now());
            ProvisionDetalle provisionDetalle = new ProvisionDetalle();
            provisionDetalle.setCantidad(p.getStockMinimo()*3);
            provision = provisionRepository.save(provision);

            MovimientosStock movimientosStock1 = new MovimientosStock();
            movimientosStock1.setProducto(p);
            movimientosStock1.setProvisionDetalle(provision.getProvisionDetalle().get(0));
            movimientosStock1.setFecha(LocalDateTime.now());
            movimientosStock1.setCantidadSalida(0);
            movimientosStock1.setCantidadEntrada(movimientosStock1.getProvisionDetalle().getCantidad());
            movimientosStock1 = movimientosStockRepository.save(movimientosStock1);

            p.setStockActual(p.getStockActual()+movimientosStock1.getCantidadEntrada());
        }
        productoRepository.save(p);
    }

}
