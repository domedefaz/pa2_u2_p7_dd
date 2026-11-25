package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Producto;

public interface ProductoRepository {

    // Create
    public void create(Producto producto);

    // Read por id
    public Optional<Producto> read(Integer id);

    public Optional<Producto> readByCodigo(String codigo);

    public List<Producto> readAll(Integer id);

    // Update
    public void update(Producto producto);

    // Delete
    public void delete(Integer id);
}