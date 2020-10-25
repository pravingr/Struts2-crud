<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Struts2</title>
<link rel="stylesheet" href="css/useradd.css">
</head>
<body>
	<div class="header">CRUD Operations</div>
	<div class="createUser">
		<h1>Update User</h1>
	</div>
	<div class="createUser">
		<s:form action="update" class="form">
			<s:textfield class="textfield" align="center" name="userId"
				placeholder="Enter ID" readonly="true" />
			<s:textfield class="textfield" align="center" name="userName"
				placeholder="Enter Name" />
			<s:textfield class="textfield" align="center" name="email"
				placeholder="Enter Email" />
			<s:submit class="button1" value="Update" align="center" />
		</s:form>
	</div>
	<div class="footer">Struts2 Framework</div>
</body>
</html>