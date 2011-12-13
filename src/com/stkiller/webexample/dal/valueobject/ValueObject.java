package com.stkiller.webexample.dal.valueobject;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ValueObject implements Serializable, Comparable<ValueObject> {
    private static final long serialVersionUID = -2634242514176783277L;

    @Id()
    @TableGenerator(name = "Identity_Gen", initialValue = 1)
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Identity_Gen")
    private Long id;

    @Column(name = "name", nullable = false)
    protected String name;

    public ValueObject() {
        super();
    }

    public ValueObject(String name) {
        this.name = name;
    }

    protected ValueObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (0 < id) {
            this.id = id;
        } else {
            this.id=null;
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValueObject)) return false;

        ValueObject that = (ValueObject) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public int compareTo(ValueObject o) {
        if (o == null || o.getId() == null) {
            return -1;
        }
        return this.getId().compareTo(o.getId());
    }

    @Override
    public String toString() {
        return "ValueObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
