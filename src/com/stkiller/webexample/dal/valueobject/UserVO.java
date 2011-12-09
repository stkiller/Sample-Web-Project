package com.stkiller.webexample.dal.valueobject;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserVO extends ValueObject {
	private static final long serialVersionUID = 397303372759738081L;

	@Column(name="login", nullable = false)
	private String login;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="group_id", nullable = false)
	private Long groupID;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="group_id")
	private GroupVO group;

	public UserVO(){
		
	}
	
	public UserVO(String name, String login, String password, Long groupID) {
		super(name);
		this.login = login;
		this.password = password;
		this.groupID = groupID;
	}

	public UserVO(Long id, String name, String login, String password, Long groupID) {
		super(id, name);
		this.login = login;
		this.password = password;
		this.groupID = groupID;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the groupID
	 */
	public Long getGroupID() {
		return groupID;
	}

	/**
	 * @param groupID
	 *            the groupID to set
	 */
	public void setGroupID(Long groupID) {
		this.groupID = groupID;
	}

	/**
	 * @return the group
	 */
	public GroupVO getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(GroupVO group) {
		this.group = group;
		this.groupID = group.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + (int) (groupID ^ (groupID >>> 32));
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof UserVO)) {
			return false;
		}
		UserVO other = (UserVO) obj;
		if (group == null) {
			if (other.group != null) {
				return false;
			}
		} else if (!group.equals(other.group)) {
			return false;
		}
		if (!groupID.equals(other.groupID)) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "UserVO [login=" + login + ", password=" + password + ", groupID=" + groupID + ", id=" + id + ", name=" + name + "]";
	}

}
