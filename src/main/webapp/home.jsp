<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Struts2</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="header">CRUD Operations</div>
	<div class="createUser">
		<a href="addUser.jsp"><button>Create New User</button></a>
	</div>
	<div class="footer">Struts2 Framework</div>
	<s:if test="flag==true">
		<div class="createUser">
			<h3>No users found, please add users</h3>
		</div>
	</s:if>
	<s:else>
		<div class="table-row">
			<div>
				<table>
					<tr>
						<th>User ID</th>
						<th>Name</th>
						<th>Email</th>
						<th colspan="2">Actions</th>
					</tr>
					<s:iterator value="users">
						<tr>

							<td><s:property value="userId" /></td>
							<td><s:property value="userName" /></td>
							<td><s:property value="email" /></td>
							<td><a href="updateForm?userId=<s:property value="userId"/>">
									<button>Update</button>
							</a></td>
							<td><a href="delete?userId=<s:property value="userId"/>">
									<button>Delete</button>
							</a></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</s:else>
</body>
</html>