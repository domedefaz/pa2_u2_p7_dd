package ec.edu.uce.pa.grupo.u2.pedidos.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity //que esta clase es administrada por Jakarta Persistence API (JPA) y se mapeara a una tabla en la base de datos
@Table(name = "proveedores") //especifica el nombre de la tabla en la base de datos a la que se mapeara esta entidad
public class Proveedor {

    @Id //indica que el atributo id es la clave primaria de la entidad
    @SequenceGenerator(name = "proveedor_seq", sequenceName = "proveedor_seq_db", allocationSize = 1) //define un generador de secuencia para la clave primaria
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedor_seq") //indica que el valor del atributo id se generara automaticamente utilizando el generador de secuencia definido anteriormente
    @Column(name = "prov_id") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private Integer id;

    @Column(name = "prov_razon_social") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String razonSocial;

    @Column(name = "prov_telefono") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String telefono;

    @Column(name = "prov_direccion") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String direccion;

    @Column(name = "prov_ciudad") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String ciudad;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}