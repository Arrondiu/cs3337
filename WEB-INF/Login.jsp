<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<!-- Creates a form, gathers the data, and send data into Login.java doPost() -->
	<form action="Login" method="post">
		<table>
			<tr>
				<td>Email</td>
				<!-- We have name="email" to detect and gather for doPost() -->
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password</td>
				<!-- We have name="password" to detect and gather for doPost() -->
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<!-- This sends the data into Register.java -->
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
	Don't have an account? <a href="Register">Register</a>
</body>
</html>
