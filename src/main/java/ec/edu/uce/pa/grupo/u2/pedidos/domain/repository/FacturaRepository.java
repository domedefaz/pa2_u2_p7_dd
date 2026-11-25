package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Factura;

public interface FacturaRepository {

    // Create
    public void create(Factura factura);

    // Read por id
    public Optional<Factura> read(Integer id);

    public Optional<Factura> readByNumero(String numero);

    public List<Factura> readAll(Integer id);

    // Update
    public void update(Factura factura);

    // Delete
    public void delete(Integer id);
}