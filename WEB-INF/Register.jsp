<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<!-- Creates a form, gathers the data, and sends data into Register.java doPost() -->
	<form action="Register" method="post">
		<table>
			<tr>
				<td>Email</td>
				<!-- We have name="email" to detect and gather for doPost() -->
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Name</td>
				<!-- We have name="name" to detect and gather for doPost() -->
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Password</td>
				<!-- We have name="email" to detect and gather for doPost() -->
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<!-- This sends the data into Register.java -->
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
	Have an account? <a href="Login"> Login</a>
</body>
</html>
