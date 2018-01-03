<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>

<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%">
<div style="color: red">
			<form:errors path="loginForm.*" />
			${INVALID_USER}
		</div>
<form:form action="login.html" method="post" commandName="loginForm">
			<table border="0" cellpadding="4" cellspacing="0" align="center" width="248px">
				<tbody>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><label><span class="mandatory">*</span>Username:</label></td> <td><form:input path="userName" maxlength="15" /></td>
					</tr>
					<tr>
						<td><label><span class="mandatory">*</span>Password:</label></td> <td><form:password path="password" maxlength="8" /></td>
					</tr>
					<tr>
						<td></td><td align="right"><input type="submit" value="Login"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>

</body>
</html>