<%@taglib uri="http://java.sun.com/jsp/jstl/core"				prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"		prefix="f"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Magasin</title>
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
		<div id="formMagasin" class="cadre">
			<f:form modelAttribute="magasin" action="enregistrerMagasin" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>ID</td>
						<td><f:input path="idMag" /></td>
						<td><f:errors path="idMag" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Adresse</td>
						<td><f:input path="adrMag" /></td>
						<td><f:errors path="adrMag" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Horaires</td>
						<td><f:input path="horMag" /></td>
						<td><f:errors path="horMag" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Enseigne</td>
						<td>
							<f:select path="enseigne.idEns" items="${enseignes}" itemValue="idEns" itemLabel="nomEns" />
						</td>
					</tr>
					<tr>
						<td>Type</td>
						<td>
							<f:select path="typeMagasin.idTypeMag"  items="${typesMagasin}" itemValue="idTypeMag" itemLabel="nomTypeMag" />
						</td>
					</tr>
					<tr>
						<td>Nom photo</td>
						<td><f:input path="nomPhoto" /></td>
						<td><f:errors path="nomPhoto" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Photo</td>
						<td><input type="file" name="file" /></td>
						<c:if test="${magasin.idMag != null}">
							<td><img src="photoMagasin?idMag=${magasin.idMag}" /></td>
						</c:if>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Enregistrer" /></td>
						<td></td>
					</tr>
				</table>
			</f:form>
		</div>
		<div id="tableauMagasin" class="cadre">
			<table>
				<tr>
					<th>ID</th>
					<th>Adresse</th>
					<th>Horaires</th>
					<th>Enseigne</th>
					<th>Type</th>
					<th>Photo</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${magasins}" var ="mag">
					<tr>
						<td>${mag.idMag}</td>
						<td>${mag.adrMag}</td>
						<td>${mag.horMag}</td>
						<td>${mag.enseigne.nomEns}</td>
						<td>${mag.typeMagasin.nomTypeMag}</td>
						<td><img src="photoMagasin?idMag=${mag.idMag}" /></td>
						<td><a href="modifierMagasin?idMag=${mag.idMag}">Modifier</a></td>
						<td><a href="supprimerMagasin?idMag=${mag.idMag}">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>