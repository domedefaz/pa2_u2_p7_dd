package ec.edu.uce.pa.grupo.u2.pedidos.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Factura;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.FacturaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class FacturaRepositoryImpl implements FacturaRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Factura factura) {
        this.entityManager.persist(factura);
    }

    @Override
    public Optional<Factura> read(Integer id) {
        Factura factura = this.entityManager.find(Factura.class, id);
        return Optional.ofNullable(factura);
    }

    @Override
    public void update(Factura factura) {
        this.entityManager.merge(factura);
    }

    @Override
    public void delete(Integer id) {
        Optional<Factura> factura = this.read(id);
        factura.ifPresent(this.entityManager::remove);
    }

    @Override
    public Optional<Factura> readByNumero(String numero) {
        TypedQuery<Factura> query = this.entityManager.createQuery(
                "SELECT f FROM Factura f WHERE f.numero = :numeroVariable", Factura.class);
        query.setParameter("numeroVariable", numero);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Factura> readAll(Integer id) {
        return null;
    }
}