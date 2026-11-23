package ec.edu.uce.pa.grupo.u2.pedidos.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity //que esta clase es administrada por Jakarta Persistence API (JPA) y se mapeara a una tabla en la base de datos
@Table(name = "clientes") //especifica el nombre de la tabla en la base de datos a la que se mapeara esta entidad
public class Cliente {

    @Id //indica que el atributo id es la clave primaria de la entidad
    @SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq_db", allocationSize = 1) //define un generador de secuencia para la clave primaria
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq") //indica que el valor del atributo id se generara automaticamente utilizando el generador de secuencia definido anteriormente
    @Column(name = "clie_id") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private Integer id;

    @Column(name = "clie_identificacion") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String identificacion;

    @Column(name = "clie_nombre") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String nombre;

    @Column(name = "clie_correo") //especifica el nombre de la columna en la tabla de la base de datos a la que se mapeara este atributo
    private String correo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}