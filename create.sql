--
-- Name: groups; Type: TABLE; Schema: public;
--

CREATE TABLE groups (
    id bigint NOT NULL,
    name character varying(15) NOT NULL,
    description character varying(100)
);

--
-- Name: groupsroles; Type: TABLE; Schema: public;
--

CREATE TABLE groupsroles (
    group_id bigint NOT NULL,
    role_id bigint NOT NULL
);


--
-- Name: roles; Type: TABLE; Schema: public;
--

CREATE TABLE roles (
    id bigint NOT NULL,
    name character varying(15) NOT NULL,
    description character varying(100)
);

--
-- Name: users; Type: TABLE; Schema: public;
--

CREATE TABLE users (
    id bigint NOT NULL,
    name varchar(15) DEFAULT 'userName' NOT NULL,
    login varchar(15) DEFAULT 'userLogin' NOT NULL,
    password varchar(15) DEFAULT 'userPassword' NOT NULL,
    group_id bigint NOT NULL
);

--
-- Name: Groups_pkey; Type: CONSTRAINT; Schema: public;
--

ALTER TABLE groups
    ADD CONSTRAINT "Groups_pkey" PRIMARY KEY (id);


--
-- Name: Roles_pkey; Type: CONSTRAINT;
--

ALTER TABLE roles
    ADD CONSTRAINT "Roles_pkey" PRIMARY KEY (id);


--
-- Name: Users_pkey; Type: CONSTRAINT; Schema: public;
--

ALTER TABLE users
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY (id);


--
-- Name: GroupsRoles_groupID_fkey; Type: FK CONSTRAINT; Schema: public;
--

ALTER TABLE groupsroles
    ADD CONSTRAINT "GroupsRoles_groupID_fkey" FOREIGN KEY (group_id) REFERENCES groups(id);


--
-- Name: GroupsRoles_roleID_fkey; Type: FK CONSTRAINT; Schema: public;
--

ALTER TABLE groupsroles
    ADD CONSTRAINT "GroupsRoles_roleID_fkey" FOREIGN KEY (role_id) REFERENCES roles(id);


--
-- Name: Users_groupID_fkey; Type: FK CONSTRAINT; Schema: public;
--

ALTER TABLE users
    ADD CONSTRAINT "Users_groupID_fkey" FOREIGN KEY (group_id) REFERENCES groups(id);


--
-- PostgreSQL database dump complete
--

