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
		<h1>Create User</h1>
	</div>
	<s:if test="idExists==true">
		<div class="createUser">
			<h3>User ID already exists!</h3>
		</div>
	</s:if>
	<div class="createUser">
		<s:form action="test" class="form">
			<s:textfield class="textfield" align="center" name="userId"
				placeholder="Enter ID" />
			<s:textfield class="textfield" align="center" name="userName"
				placeholder="Enter Name" />
			<s:textfield class="textfield" align="center" name="email"
				placeholder="Enter Email" />
			<s:submit class="button1" value="Create" align="center" />
		</s:form>
	</div>
	<div class="footer">Struts2 Framework</div>
</body>
</html>