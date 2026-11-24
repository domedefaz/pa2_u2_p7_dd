package ec.edu.uce.pa.grupo.u2.pedidos.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity //que esta clase es administrada por Jakarta Persistence API (JPA) y se mapeara a una tabla en la base de datos
@Table(name = "facturas") //especifica el nombre de la tabla en la base de datos a la que se mapeara esta entidad
public class Factura {

    @Id //indica que el atributo id es la clave primaria de la entidad
    @SequenceGenerator(name = "factura_seq", sequenceName = "factura_seq_db", allocationSize = 1) //define un generador de secuencia para la clave primaria
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_seq") //indica que el valor del atributo id se generara automaticamente utilizando el generador de secuencia definido anteriormente
    @Column(name = "fact_id") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private Integer id;

    @Column(name = "fact_numero") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String numero;

    @Column(name = "fact_ruc") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String ruc;

    @Column(name = "fact_subtotal") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private Double subtotal;

    @Column(name = "fact_total") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private Double total;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}