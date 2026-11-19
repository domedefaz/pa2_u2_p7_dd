package ec.edu.uce.pa.grupo.u2.pedidos.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity //que esta clase es administrada por Jakarta Persistence API (JPA) y se mapeará a una tabla en la base de datos
@Table (name = "pedidos") //especifica el nombre de la tabla en la base de datos a la que se mapeará esta entidad
public class Pedido {

    @Id //indica que el atributo id es la clave primaria de la entidad
    @SequenceGenerator (name = "pedido_seq", sequenceName = "pedido_seq_db", allocationSize = 1) //define un generador de secuencia para la clave primaria
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "pedido_seq") //indica que el valor del atributo id se generará automáticamente utilizando el generador de secuencia definido anteriormente
    @Column (name = "pedd_id") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeará este atributo
    private Integer id;

    @Column (name = "pedd_producto") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeará este atributo
    private String producto;

    @Column (name = "pedd_precio") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeará este atributo
    private Double precio;

    @Column (name = "pedd_fecha") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeará este atributo
    private LocalDateTime fecha;
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
