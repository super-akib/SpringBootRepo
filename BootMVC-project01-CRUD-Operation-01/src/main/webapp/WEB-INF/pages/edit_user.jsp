<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>Update User Details</title>
<link rel="stylesheet" href="stylesheet/edit.css">
</head>
<body>
	<div class="main-container">
		<frm:form modelAttribute="userData">
			<span>Id:<frm:input id="userId" path="id" readonly="true"/></span>
			<hr>
			<table>
				<tr>
				</tr>
				<tr>
					<td>User-Name:</td>
					<td><frm:input path="userName" /></td>
				</tr>
				<tr>
					<td>Email-Id</td>
					<td><frm:input path="emailId" /></td>
				</tr>
				<tr>
					<td>Contact:</td>
					<td><frm:input path="contactNumber" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><frm:input path="address" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Edit"></td>
					<td><input type="reset" value="Clear"></td>
				</tr>
			</table>
		</frm:form>
	</div>
</body>
</html>