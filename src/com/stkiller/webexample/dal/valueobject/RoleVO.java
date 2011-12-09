package com.stkiller.webexample.dal.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class RoleVO extends ValueObject {
	private static final long serialVersionUID = -8135306853787087895L;
	
	@Column(name="description")
	private String description;

	public RoleVO(){
		
	}
	
	public RoleVO(String name, String description) {
		super(name);
		this.description = description;
	}

	public RoleVO(Long id, String name, String description) {
		super(id, name);
		this.description = description;
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
		return "RoleVO [description=" + description + ", id=" + id + ", name=" + name + "]";
	}
}
