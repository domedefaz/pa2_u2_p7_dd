package ec.edu.uce.pa.grupo.u2.pedidos.application;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Cliente;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    public void guardar(Cliente cliente) {
        this.clienteRepository.create(cliente);
    }

    public Optional<Cliente> buscarPorID(Integer id) {
        return this.clienteRepository.read(id);
    }

    public Optional<Cliente> buscarPorIdentificacion(String identificacion) {
        return this.clienteRepository.readByIdentificacion(identificacion);
    }

    public void actualizar(Cliente cliente) {
        this.clienteRepository.update(cliente);
    }

    public void eliminar(Integer id) {
        this.clienteRepository.delete(id);
    }
}