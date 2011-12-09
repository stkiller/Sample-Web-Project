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
		<div style="text-align: center;">
			<c:forEach var="message" items="${validation}">
				<div style="color: red;">${message}</div>
			</c:forEach>
			<form action="index.html?action=add_user" method="post">
				<input type="hidden" name="id" value="${user.id}" /> User name : <input
					type="text" name="name" value="${user.name}" /><br /> User login :
				<input type="text" name="login" value="${user.login }" /><br />
				User pass : <input type="password" name="password"
					value="${user.password }" /><br /> User group : <select
					name="group_id">
					<c:forEach var="group" items="${groups}">
						<c:choose>
							<c:when test="${user.groupID==group.id}">
								<option value="${group.id }" selected="selected">${group.name}</option>
							</c:when>
							<c:otherwise>
								<option value="${group.id }">${group.name }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select> <input type="submit" value="Submit">
			</form>
		</div>
	</div>
</body>
</html>