package ec.edu.uce.pa.grupo.u2;

import java.util.Optional;

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
 
    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }
 
    @Override
    public int run(String... args) throws Exception {
        System.out.println("Hello World");
 
        //Read(buscar)
        Optional<Pedido> pedido = this.pedidoService.buscarPorID(100);
        if (pedido.isPresent()) {
            System.out.println("Pedido encontrado: " + pedido.get());
        } else {
            System.out.println("Pedido no encontrado");
        }
 
        //READ By Number
        Optional<Pedido> pedidoByNumber = this.pedidoService.buscarPorNumero("PED-0001");
        if (pedidoByNumber.isPresent()) {
            System.out.println("Pedido encontrado por número: " + pedidoByNumber.get());
        } else {
            System.out.println("Pedido no encontrado por número");
        }

        return 0;
    }
 
}