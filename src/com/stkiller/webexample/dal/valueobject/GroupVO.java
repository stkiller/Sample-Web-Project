package com.stkiller.webexample.dal.valueobject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groups")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "group_id"))})
public class GroupVO extends ValueObject {
    private static final long serialVersionUID = 8931275631737519968L;

    @Column(name = "description")
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "groupsroles",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleVO> roles = new HashSet<RoleVO>();

    public GroupVO() {

    }

    public GroupVO(String name, String description) {
        super(name);
        this.description = description;
        roles = new HashSet<RoleVO>();
    }

    public GroupVO(Long id, String name, String description) {
        super(id, name);
        this.description = description;
        roles = new HashSet<RoleVO>();
    }

    public GroupVO(Long id) {
        super(id, null);
    }

    public void setRoles(Set<RoleVO> roles) {
        for (RoleVO role : roles) {
            addRole(role);
        }
    }

    public void addRole(RoleVO role) {
        role.getGroups().add(this);
        this.roles.add(role);
    }

    public Set<RoleVO> getRoles() {
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
        return "GroupVO{" +
                "description='" + description + '\'' +
                ", roles=" + roles +
                "} " + super.toString();
    }
}
