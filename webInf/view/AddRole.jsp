<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <LINK REL=StyleSheet HREF="style.css" TYPE="text/css">
    <title>You can or edit role here</title>
</head>
<body>
<div class="inner">
    <c:import url="/WEB-INF/view/Header.jsp"></c:import>
    <div style="text-align: center;">
        <c:forEach var="message" items="${validation}">
            <div style="color: red;">${message}</div>
        </c:forEach>
        <form action="index.html?action=add_role" method="post">
            <input type="hidden" value="${role.id}" name="id"/>
            Role name : <input type="text" name="name" value="${role.name}"/><br/>
            Role description : <input type="text" name="description" value="${role.description }"/><br/>
            <input type="submit" value="Submit">
        </form>
    </div>
</div>
</body>
</html>