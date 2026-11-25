package ec.edu.uce.pa.grupo.u2.pedidos.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Cliente;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class ClienteRepositoryImpl implements ClienteRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    @Override
    public Optional<Cliente> read(Integer id) {
        Cliente cliente = this.entityManager.find(Cliente.class, id);
        return Optional.ofNullable(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    @Override
    public void delete(Integer id) {
        Optional<Cliente> cliente = this.read(id);
        cliente.ifPresent(this.entityManager::remove);
    }

    @Override
    public Optional<Cliente> readByIdentificacion(String identificacion) {
        TypedQuery<Cliente> query = this.entityManager.createQuery(
                "SELECT c FROM Cliente c WHERE c.identificacion = :identificacionVariable", Cliente.class);
        query.setParameter("identificacionVariable", identificacion);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Cliente> readAll(Integer id) {
        return null;
    }
}