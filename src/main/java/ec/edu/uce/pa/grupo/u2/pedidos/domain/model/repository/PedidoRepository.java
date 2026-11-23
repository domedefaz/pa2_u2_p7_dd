package ec.edu.uce.pa.grupo.u2.pedidos.domain.model.repository;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;

public interface PedidoRepository {
    //Create
    public void create(Pedido pedido);
    //Read por id
    public Pedido read(Integer id);
    //Update
    public void update(Pedido pedido);
    //Delete
    public void delete(Integer id);
}
 