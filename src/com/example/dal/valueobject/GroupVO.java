package com.example.dal.valueobject;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "groups")
public class GroupVO extends ValueObject {
    private static final long serialVersionUID = 8931275631737519968L;

    @Column(name = "description")
    private String description;
    @OneToMany()
    private List<RoleVO> roles;

    public GroupVO() {

    }

    public GroupVO(String name, String description) {
        super(name);
        this.description = description;
        roles = new LinkedList<RoleVO>();
    }

    public GroupVO(Long id, String name, String description) {
        super(id, name);
        this.description = description;
        roles = new LinkedList<RoleVO>();
    }

    public void setRoles(List<RoleVO> roles) {
        this.roles = roles;
    }

    public List<RoleVO> getRoles() {
        return roles;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GroupVO [description=" + description + ", roles=" + roles + ", id=" + id + ", name=" + name + "]";
    }
}
