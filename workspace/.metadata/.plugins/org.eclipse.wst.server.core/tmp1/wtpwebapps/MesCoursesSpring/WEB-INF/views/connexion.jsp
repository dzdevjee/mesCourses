<%@taglib uri="http://java.sun.com/jsp/jstl/core"				prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"		prefix="f"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Connexion</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/img/MesCourses.png" />
	</head>
	<body>
		<div class="erreurs">
			${exeption}
		</div>
		<div class="menu">
			<table>
				<tr>
					<td class="home">
						<a href="<c:url value="/" />">
							<img src="<%=request.getContextPath()%>/resources/img/home.png" alt="Home" />
						</a>
					</td>

					<td class="connect">
						<a href="<c:url value="/connexion" />">Connexion</a>
					</td>

				</tr>
			</table>
		</div>
		<div class="loginCadre">
			<form action="j_spring_security_check" method="post">
				<table>
					<tr>
						<td>Login</td>
						<td><input type="text" name="j_username" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="j_password"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="Login" /></td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>