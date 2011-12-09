<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css">
<title>You can add a group here</title>
</head>
<body>
	<div class="inner">
		<c:import url="/WEB-INF/view/Header.jsp"></c:import>
		<div style="text-align: center;">
		<form method="POST" action="j_security_check">
			User name : <input type="text" name="j_username"> <br/>
			User pass<input type="password" name="j_password"> <br/>
			<input type="submit" value="Enter"> <br/>
		</form>
		</div>
	</div>
</body>
</html>