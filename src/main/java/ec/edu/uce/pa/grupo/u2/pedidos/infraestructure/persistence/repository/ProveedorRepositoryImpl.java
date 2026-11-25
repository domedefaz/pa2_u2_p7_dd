package ec.edu.uce.pa.grupo.u2.pedidos.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Proveedor;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.ProveedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class ProveedorRepositoryImpl implements ProveedorRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Proveedor proveedor) {
        this.entityManager.persist(proveedor);
    }

    @Override
    public Optional<Proveedor> read(Integer id) {
        Proveedor proveedor = this.entityManager.find(Proveedor.class, id);
        return Optional.ofNullable(proveedor);
    }

    @Override
    public void update(Proveedor proveedor) {
        this.entityManager.merge(proveedor);
    }

    @Override
    public void delete(Integer id) {
        Optional<Proveedor> proveedor = this.read(id);
        proveedor.ifPresent(this.entityManager::remove);
    }

    @Override
    public Optional<Proveedor> readByRazonSocial(String razonSocial) {
        TypedQuery<Proveedor> query = this.entityManager.createQuery(
                "SELECT pr FROM Proveedor pr WHERE pr.razonSocial = :razonSocialVariable", Proveedor.class);
        query.setParameter("razonSocialVariable", razonSocial);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Proveedor> readAll(Integer id) {
        return null;
    }
}