package ec.edu.uce.pa.grupo.u2.pedidos.application;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Proveedor;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.ProveedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProveedorService {

    @Inject
    private ProveedorRepository proveedorRepository;

    public void guardar(Proveedor proveedor) {
        this.proveedorRepository.create(proveedor);
    }

    public Optional<Proveedor> buscarPorID(Integer id) {
        return this.proveedorRepository.read(id);
    }

    public Optional<Proveedor> buscarPorRazonSocial(String razonSocial) {
        return this.proveedorRepository.readByRazonSocial(razonSocial);
    }

    public void actualizar(Proveedor proveedor) {
        this.proveedorRepository.update(proveedor);
    }

    public void eliminar(Integer id) {
        this.proveedorRepository.delete(id);
    }
}