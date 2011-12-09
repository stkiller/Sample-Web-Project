<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css">
<title>Insert title here</title>
</head>
<body>
 	<div class="inner">
    <c:import url="/WEB-INF/view/Header.jsp"></c:import>
    <h3>Users</h3>
	<table border="1" align="center">
		<tr>
			<th>ID</th><th>Name</th><th>Login</th><th>Password</th><th>Group Name</th><th>Edit</th><th>Remove</th>
		</tr>
		<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.id }</td><td>${user.name}</td>
			<td>${user.login}</td><td>${user.password}</td>
			<td>${user.group.name}</td><td><input type="button" onclick="location.href='index.html?action=add_user&id=${user.id}'" value="Edit"/></td>
			<td><input type="button" onclick="location.href='index.html?action=delete_entity&id=${user.id}&type=user'" value="Remove"/></td>
		</tr>
		</c:forEach>
	</table>

    <h3>Groups</h3>
	<table border="1" align="center">
		<tr>
			<th>ID</th><th>Name</th><th>Description</th><th>Edit</th><th>Remove</th>
		</tr>
		<c:forEach var="group" items="${groups}">
		<tr>
			<td>${group.id }</td><td>${group.name}</td><td>${group.description}</td>
			<td><input type="button" onclick="location.href='index.html?action=add_group&id=${group.id}'" value="Edit"/></td>
			<td><input type="button" onclick="location.href='index.html?action=delete_entity&id=${group.id}&type=group'" value="Remove"/></td>
		</tr>
		</c:forEach>
	</table>
		
    <h3>Roles</h3>
	<table border="1" align="center">
		<tr>
			<th>ID</th><th>Name</th><th>Description</th><th>Edit</th><th>Remove</th>
		</tr>
		<c:forEach var="role" items="${roles}">
		<tr>
			<td>${role.id }</td><td>${role.name}</td><td>${role.description}</td>
			<td><input type="button" onclick="location.href='index.html?action=add_role&id=${role.id}'" value="Edit"/></td>
			<td><input type="button" onclick="location.href='index.html?action=delete_entity&id=${role.id}&type=role'" value="Remove"/></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>