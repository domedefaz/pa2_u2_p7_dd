package ec.edu.uce.pa.grupo.u2.pedidos.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Producto;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.ProductoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class ProductoRepositoryImpl implements ProductoRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Producto producto) {
        this.entityManager.persist(producto);
    }

    @Override
    public Optional<Producto> read(Integer id) {
        Producto producto = this.entityManager.find(Producto.class, id);
        return Optional.ofNullable(producto);
    }

    @Override
    public void update(Producto producto) {
        this.entityManager.merge(producto);
    }

    @Override
    public void delete(Integer id) {
        Optional<Producto> producto = this.read(id);
        producto.ifPresent(this.entityManager::remove);
    }

    @Override
    public Optional<Producto> readByCodigo(String codigo) {
        TypedQuery<Producto> query = this.entityManager.createQuery(
                "SELECT p FROM Producto p WHERE p.codigo = :codigoVariable", Producto.class);
        query.setParameter("codigoVariable", codigo);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Producto> readAll(Integer id) {
        return null;
    }
}