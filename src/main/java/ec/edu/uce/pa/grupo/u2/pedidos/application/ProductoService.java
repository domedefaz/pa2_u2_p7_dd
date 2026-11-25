package ec.edu.uce.pa.grupo.u2.pedidos.application;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Producto;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.ProductoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProductoService {

    @Inject
    private ProductoRepository productoRepository;

    public void guardar(Producto producto) {
        this.productoRepository.create(producto);
    }

    public Optional<Producto> buscarPorID(Integer id) {
        return this.productoRepository.read(id);
    }

    public Optional<Producto> buscarPorCodigo(String codigo) {
        return this.productoRepository.readByCodigo(codigo);
    }

    public void actualizar(Producto producto) {
        this.productoRepository.update(producto);
    }

    public void eliminar(Integer id) {
        this.productoRepository.delete(id);
    }
}