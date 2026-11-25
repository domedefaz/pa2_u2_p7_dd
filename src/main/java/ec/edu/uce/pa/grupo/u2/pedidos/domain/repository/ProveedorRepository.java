package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Proveedor;

public interface ProveedorRepository {

    public void create(Proveedor proveedor);

    public Optional<Proveedor> read(Integer id);

    public Optional<Proveedor> readByRazonSocial(String razonSocial);

    public List<Proveedor> readAll(Integer id);

    public void update(Proveedor proveedor);

    public void delete(Integer id);
}