package com.stkiller.webexample.dal.valueobject;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public abstract class ValueObject implements Serializable, Comparable<ValueObject> {
    private static final long serialVersionUID = -2634242514176783277L;

    @Id()
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "name", nullable = false)
    protected String name;

    public ValueObject() {
        super();
    }

    public ValueObject(String name) {
        this.name = name;
    }

    public ValueObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        if (id != null && id <= 0) {
            this.id = null;
        } else {
            this.id = id;
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
    public String toString() {
        return String.format("ValueObject [id=%s, name=%s]", id, name);
    }

    /*
      * (non-Javadoc)
      *
      * @see java.lang.Object#hashCode()
      */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /*
      * (non-Javadoc)
      *
      * @see java.lang.Object#equals(java.lang.Object)
      */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ValueObject)) {
            return false;
        }
        ValueObject other = (ValueObject) obj;
        if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ValueObject o) {
        if (o == null || o.getId() == null) {
            return -1;
        }
        return this.getId().compareTo(o.getId());
    }

}
