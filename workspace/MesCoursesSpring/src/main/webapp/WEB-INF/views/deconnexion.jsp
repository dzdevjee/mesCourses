<%@taglib uri="http://java.sun.com/jsp/jstl/core"				prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"		prefix="f"%>
<%@taglib uri="http://www.springframework.org/security/tags"	prefix="s" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Deconnexion</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/img/MesCourses.png" />
		<meta http-equiv="Refresh" content="3;url=http://localhost:8080/mesCourses/connexion">
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
					<td>	<a href="<c:url value="/produit/index" />">				Produit		</a>	</td>
					
						<td>	<a href="<c:url value="/enseigne/index" />">			Enseigne	</a>	</td>
						<td>	<a href="<c:url value="/magasin/index" />">				Magasin		</a>	</td>
						<td>	<a href="<c:url value="/marque/index" />">				Marque		</a>	</td>
						<td>	<a href="<c:url value="/typeMagasin/index" />">			TypeMagasin	</a>	</td>
						<td>	<a href="<c:url value="/typeProduit/index" />">			TypeProduit	</a>	</td>
						<td>	<a href="<c:url value="/categorie/index" />">			Categorie	</a>	</td>
						<td>	<a href="<c:url value="/nature/index" />">				Nature		</a>	</td>
						<td>	<a href="<c:url value="/utilisation/index" />">			Utilisation	</a>	</td>

					<td class="connect">
						<a href="<c:url value="/connexion" />">Connexion</a>
					</td>
				</tr>
			</table>
		</div>

		
		<div class="mainLogout">
			<h1>Déconnexion	<img id="imgLoading" src="<%=request.getContextPath()%>/resources/img/Icons/loadingbar.gif" alt="UnderConstruct" />	</h1>
		</div>
	</body>
</html>