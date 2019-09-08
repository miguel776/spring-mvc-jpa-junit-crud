package com.mike.springjpa.crud.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 *  - The Department class is annotated with @Entity, indicating that it is a JPA entity. For lack of a @Table annotation, it is assumed
 *    that this entity will be mapped to a table named DEPARTMENT.
 *  - The Department´s id property is annotated with @Id so that JPA will recognize it as the object’s ID. The id property is also annotated
 *    with @GeneratedValue to indicate that the ID should be generated automatically.
 *  - The property call name is annotate as @Column, it is mean that will be mapped to columns that share, on the other hand, this is
 *    property can have amx lenght 20, can´t be null and have to be unioque as indicated in the anotation @Column.
 *  - The convenient toString() method will print out the department’s property.
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */

@Entity(name = "department")
@Table(name = "DEPARTMENT")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", length = 20, nullable = false, unique=true)
    private String name;

    /**
     * Department identifier
     * @return id (long)
     */
    public long getId() {
        return id;
    }

    /**
     * Department identifier
     * @param id (long)
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Department name
     * @return name (String)
     */
    public String getName() {
        return name;
    }

    /**
     * Department name
     * @param name (String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This  method will print out the department’s properties.
     * @return (String)
     */
    @Override
    public String toString() {
        return String.format(
                "Department[id=%d, name='%s']",
                id, name);
    }
}
