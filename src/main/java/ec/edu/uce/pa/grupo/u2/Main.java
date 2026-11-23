package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;
 
import ec.edu.uce.pa.grupo.u2.pedidos.application.PedidoService;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
 
@QuarkusMain
public class Main implements QuarkusApplication {
 
    @Inject
    private PedidoService pedidoService;
 
    @Override
    public int run(String... args) throws Exception {
 
        // CREATE (iNSERT)
 
        System.out.println("\nHola mundo");
        Pedido pedido = new Pedido();
        pedido.setProducto("Producto prueba 2");
        pedido.setPrecio(10.0);
        pedido.setFecha(LocalDateTime.now());
 
        this.pedidoService.guardar(pedido);
 
        // READ (buscar)
        Pedido pedido1 = this.pedidoService.buscarPorID(2);
        System.out.println("Pedido encontrado: " + pedido1);
 
        // UPDATE (actualizar)
 
        pedido.setPrecio(200.0);
        this.pedidoService.actualizar(pedido);
 
        Pedido pedido2 = this.pedidoService.buscarPorID(2);
 
        System.out.println("Pedido actualizado: " + pedido2);
 
        // DELETE (elimiinar)
 
        this.pedidoService.eliminar(2);
 
        return 0;
    }
 
    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }
 
}