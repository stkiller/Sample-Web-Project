package com.stkiller.webexample.dal.valueobject;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserVO extends ValueObject {
    private static final long serialVersionUID = 397303372759738081L;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "group_id")
    private GroupVO group;

    public UserVO() {

    }

    public UserVO(String name, String login, String password, GroupVO groupVO) {
        super(name);
        this.login = login;
        this.password = password;
        this.group = groupVO;
    }

    public UserVO(String name, String login, String password) {
        super(name);
        this.login = login;
        this.password = password;
        this.group = null;
    }

    public UserVO(Long id) {
        super(id, null);
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
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
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the group
     */
    public GroupVO getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(GroupVO group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", group=" + group +
                "} " + super.toString();
    }
}
