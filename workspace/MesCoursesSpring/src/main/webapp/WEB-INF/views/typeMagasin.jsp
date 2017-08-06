<%@taglib uri="http://java.sun.com/jsp/jstl/core"				prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"		prefix="f"%>
<%@taglib uri="http://www.springframework.org/security/tags"	prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Type magasin</title>
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
		<div id="formTypeMagasin" class="cadre">
			<f:form modelAttribute="typeMagasin" action="enregistrerTypeMagasin" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>ID</td>
						<td><f:input path="idTypeMag" /></td>
						<td><f:errors path="idTypeMag" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Type magasin</td>
						<td><f:input path="nomTypeMag" /></td>
						<td><f:errors path="nomTypeMag" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Nom photo</td>
						<td><f:input path="nomPhoto" /></td>
						<td><f:errors path="nomPhoto" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Photo</td>
						<td>
							<c:if test="${typeMagasin.idTypeMag != null}">
								<td><img src="photoTypeMagasin?idTypeMag=${typeMagasin.idTypeMag}" /></td>
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
		<div id="tableauTypeMagasin"  class="cadre">
			<table>
				<tr>
					<th>ID</th>
					<th>Type magasin</th>
					<th>Photo</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${typesMagasin}" var ="typeMag">
					<tr>
						<td>${typeMag.idTypeMag}</td>
						<td>${typeMag.nomTypeMag}</td>
						<td><img src="photoTypeMagasin?idTypeMag=${typeMag.idTypeMag}" /></td>
						<td><a href="modifierTypeMagasin?idTypeMag=${typeMag.idTypeMag}">Modifier</a></td>
						<td><a href="supprimerTypeMagasin?idTypeMag=${typeMag.idTypeMag}">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>