package ec.edu.uce.pa.grupo.u2.pedidos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity //que esta clase es administrada por Jakarta Persistence API (JPA) y se mapeara a una tabla en la base de datos
@Table(name = "productos") //especifica el nombre de la tabla en la base de datos a la que se mapeara esta entidad
public class Producto {

    @Id //indica que el atributo id es la clave primaria de la entidad
    @SequenceGenerator(name = "producto_seq", sequenceName = "producto_seq_db", allocationSize = 1) //define un generador de secuencia para la clave primaria
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_seq") //indica que el valor del atributo id se generara automaticamente utilizando el generador de secuencia definido anteriormente
    @Column(name = "prod_id") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private Integer id;

    @Column(name = "prod_codigo") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String codigo;

    @Column(name = "prod_nombre") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String nombre;

    @Column(name = "prod_precio") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private Double precio;

    @Column(name = "prod_stock") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}