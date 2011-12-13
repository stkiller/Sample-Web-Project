package com.stkiller.webexample.dal.valueobject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "role_id"))})
public class RoleVO extends ValueObject {
	private static final long serialVersionUID = -8135306853787087895L;

    @Column(name = "description")
    private String description;


    public Set<GroupVO> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupVO> groups) {
        this.groups = groups;
    }

    @ManyToMany(mappedBy = "roles")
    private Set<GroupVO> groups = new HashSet<GroupVO>();

	public RoleVO(){
		
	}
	
	public RoleVO(String name, String description) {
		super(name);
		this.description = description;
	}

    public RoleVO(Long id) {
        super(id, null);
    }

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

    @Override
    public String toString() {
        return "RoleVO{" +
                "description='" + description + '\'' +
                "} " + super.toString();
    }
}
