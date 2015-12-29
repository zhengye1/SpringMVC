<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<div align="center">
		<h1 style="background-color: lightgreen; color: darkgreen">Add
			New Employee Page</h1>
		<table width="80%" align="center">
			<tr bgcolor="lightblue">
				<td align="left"><a href="listEmployees"
					style="background-color: lightblue;">List Employee</a></td>
		</table>
	</div>
	<br />
	<div align="center">
		<table cellspacing="0" cellpadding="6" border="1" width="80%">
			<tr>
				<td colspan="8"
					style="background-color: lightblue; color: darkgreen; font-size: 16pt"
					align="center">Employee Information</td>
			</tr>
			<tr>
				<td><form:form method="POST" action="updateEmployee"
						modelAttribute="employee">
						<table width="100%">
							<form:hidden path="id" value="0" />
							<tr>
								<td><form:label path="firstName">First Name</form:label></td>
								<td align="left" width="70%"><form:input path="firstName" /></td>
							</tr>
							<tr>
								<td><form:label path="lastName">Last Name</form:label></td>
								<td align="left" width="70%"><form:input path="lastName" /></td>
							</tr>
							<tr>
								<td><form:label path="jobTitle">Job Title</form:label></td>
								<td align="left" width="70%"><form:input path="jobTitle" /></td>
							</tr>
							<tr>
								<td><form:label path="department">Department</form:label></td>
								<td align="left" width="70%"><form:input path="department" /></td>
							</tr>
							<tr>
								<td><form:label path="salary">Salary</form:label></td>
								<td align="left" width="70%"><form:input path="salary" /></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Submit" /></td>
							</tr>
						</table>
					</form:form></td>
			</tr>
		</table>
	</div>
</body>
</html>