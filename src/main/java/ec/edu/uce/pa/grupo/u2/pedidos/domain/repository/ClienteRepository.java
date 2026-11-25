package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Cliente;

public interface ClienteRepository {

    // Create
    public void create(Cliente cliente);

    // Read por id
    public Optional<Cliente> read(Integer id);

    public Optional<Cliente> readByIdentificacion(String identificacion);

    public List<Cliente> readAll(Integer id);

    // Update
    public void update(Cliente cliente);

    // Delete
    public void delete(Integer id);
}