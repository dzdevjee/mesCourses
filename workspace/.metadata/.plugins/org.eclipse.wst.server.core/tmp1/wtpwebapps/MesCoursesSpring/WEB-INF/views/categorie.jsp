<%@taglib uri="http://java.sun.com/jsp/jstl/core"				prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"		prefix="f"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Categorie</title>
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
						<a href="<c:url value="/j_spring_security_logout" />">Deconnexion</a>
					</td>
				</tr>
			</table>
		</div>
		<div id="formCategorie" class="cadre">
			<f:form modelAttribute="categorie" action="enregistrerCategorie" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>ID</td>
						<td><f:input path="idCat" readisabled="true"/></td>
						<td><f:errors path="idCat" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Categorie</td>
						<td><f:input path="nomCat" /></td>
						<td><f:errors path="nomCat" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Nom photo</td>
						<td><f:input path="nomPhoto" /></td>
						<td><f:errors path="nomPhoto" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Photo</td>
						<td>
							<c:if test="${categorie.idCat != null}">
								<td><img src="photoCategorie?idCat=${categorie.idCat}" /></td>
							</c:if>
						</td>
						<td><input type="file" name="file" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Enregistrer" /></td>
						<td></td>
					</tr>	
				</table>
			</f:form>
		</div>
		<div id="tableauCategorie"  class="cadre">
			<table>
				<tr>
					<th>ID</th>
					<th>Categorie</th>
					<th>Photo</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${categories}" var ="cat">
					<tr>
						<td>${cat.idCat}</td>
						<td>${cat.nomCat}</td>
						<td><img src="photoCategorie?idCat=${cat.idCat}" /></td>
						<td><a href="modifierCategorie?idCat=${cat.idCat}">Modifier</a></td>
						<td><a href="supprimerCategorie?idCat=${cat.idCat}">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>