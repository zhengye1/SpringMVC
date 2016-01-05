<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login Page</title>
</head>

<body>
	<h2 style="color: orange">Login to eHr Payroll</h2>
	<c:if test="${'fail' eq param.auth }">
		<div style="color: red">
			Login Failed !!! <br /> Reason:
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form:form action="${pageContext.request.contextPath}/login"
		method="post">
		<table frame="box" cellpadding="0" cellspacing="6">
			<tr>
				<td>Username:</td>
				<td><input type='text' name='username' /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password'></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>