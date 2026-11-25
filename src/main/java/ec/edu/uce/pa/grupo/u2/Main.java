package ec.edu.uce.pa.grupo.u2;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.application.ClienteService;
import ec.edu.uce.pa.grupo.u2.pedidos.application.FacturaService;
import ec.edu.uce.pa.grupo.u2.pedidos.application.PedidoService;
import ec.edu.uce.pa.grupo.u2.pedidos.application.ProductoService;
import ec.edu.uce.pa.grupo.u2.pedidos.application.ProveedorService;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Cliente;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Factura;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Producto;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Proveedor;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private PedidoService pedidoService;

    @Inject
    private ClienteService clienteService;

    @Inject
    private FacturaService facturaService;

    @Inject
    private ProductoService productoService;

    @Inject
    private ProveedorService proveedorService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Hello World");

        // --- PEDIDO ---
        Optional<Pedido> pedido = this.pedidoService.buscarPorID(100);
        if (pedido.isPresent()) {
            System.out.println("Pedido encontrado: " + pedido.get());
        } else {
            System.out.println("Pedido no encontrado");
        }

        Optional<Pedido> pedidoByNumber = this.pedidoService.buscarPorNumero("PED-0001");
        if (pedidoByNumber.isPresent()) {
            System.out.println("Pedido encontrado por número: " + pedidoByNumber.get());
        } else {
            System.out.println("Pedido no encontrado por número");
        }

        // --- CLIENTE ---
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.setIdentificacion("1723456789");
        clienteNuevo.setNombre("Carlos Perez");
        clienteNuevo.setCorreo("carlos@correo.com");
        this.clienteService.guardar(clienteNuevo);

        Optional<Cliente> clienteBuscado = this.clienteService.buscarPorIdentificacion("1723456789");
        System.out.println("Cliente encontrado: " + clienteBuscado.isPresent());

        // --- FACTURA ---
        Factura facturaNueva = new Factura();
        facturaNueva.setNumero("FAC-0001");
        facturaNueva.setRuc("1790012345001");
        facturaNueva.setSubtotal(100.0);
        facturaNueva.setTotal(115.0);
        this.facturaService.guardar(facturaNueva);

        Optional<Factura> facturaBuscada = this.facturaService.buscarPorNumero("FAC-0001");
        System.out.println("Factura encontrada: " + facturaBuscada.isPresent());

        // --- PRODUCTO ---
        Producto productoNuevo = new Producto();
        productoNuevo.setCodigo("PROD-001");
        productoNuevo.setNombre("Mouse");
        productoNuevo.setPrecio(15.0);
        productoNuevo.setStock(20);
        this.productoService.guardar(productoNuevo);

        Optional<Producto> productoBuscado = this.productoService.buscarPorCodigo("PROD-001");
        System.out.println("Producto encontrado: " + productoBuscado.isPresent());

        // --- PROVEEDOR ---
        Proveedor proveedorNuevo = new Proveedor();
        proveedorNuevo.setRazonSocial("Distribuidora Andes");
        proveedorNuevo.setTelefono("022345678");
        proveedorNuevo.setDireccion("Av. Amazonas");
        proveedorNuevo.setCiudad("Quito");
        this.proveedorService.guardar(proveedorNuevo);

        Optional<Proveedor> proveedorBuscado = this.proveedorService.buscarPorRazonSocial("Distribuidora Andes");
        System.out.println("Proveedor encontrado: " + proveedorBuscado.isPresent());

        return 0;
    }
}