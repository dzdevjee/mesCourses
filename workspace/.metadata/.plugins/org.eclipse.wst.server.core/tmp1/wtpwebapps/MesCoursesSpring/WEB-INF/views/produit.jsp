<%@taglib uri="http://java.sun.com/jsp/jstl/core"				prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"		prefix="f"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Produit</title>
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
		<div id="formProduit" class="cadre">
			<f:form modelAttribute="produit" action="enregistrerProduit" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>ID</td>
						<td><f:input path="idProd" /></td>
						<td><f:errors path="idProd" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Produit</td>
						<td><f:input path="nomProd" /></td>
						<td><f:errors path="nomProd" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Quantité</td>
						<td><f:input path="qteProd" /></td>
						<td><f:errors path="qteProd" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Quantité net</td>
						<td><f:input path="qteNetProd" /></td>
						<td><f:errors path="qteNetProd" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Unite de mesure</td>
						<td><f:input path="uniteMesure" /></td>
						<td><f:errors path="uniteMesure" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Prix unitaire</td>
						<td><f:input path="prixProd" /></td>
						<td><f:errors path="prixProd" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Quantité en stock</td>
						<td><f:input path="qteStk" /></td>
						<td><f:errors path="qteStk" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Commentaire</td>
						<td><f:input path="comProd" /></td>
						<td><f:errors path="comProd" cssClass="erreurs"/></td>
					</tr>
					<tr>
						<td>Categorie</td>
						<td>
							<f:select path="categorie.idCat" items="${categories}" itemValue="idCat" itemLabel="nomCat" />
						</td>
					</tr>
					<tr>
						<td>Enseigne</td>
						<td>
							<f:select path="enseigne.idEns" items="${enseignes}" itemValue="idEns" itemLabel="nomEns" />
						</td>
					</tr>
					<tr>
						<td>Marque</td>
						<td>
							<f:select path="marque.idMarq" items="${marques}" itemValue="idMarq" itemLabel="nomMarq" />
						</td>
					</tr>
					<tr>
						<td>Nature</td>
						<td>
							<f:select path="nature.idNat" items="${natures}" itemValue="idNat" itemLabel="nomNat" />
						</td>
					</tr>
		
					<tr>
						<td>Type</td>
						<td>
							<f:select path="typeProduit.idTypeProd"  items="${typesProduit}" itemValue="idTypeProd" itemLabel="nomTypeProd" />
						</td>
					</tr>
					<tr>
						<td>Utilisation</td>
						<td>
							<f:select path="utilisation.idUse" items="${utilisations}" itemValue="idUse" itemLabel="nomUse" />
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
						<c:if test="${produit.idProd != null}">
							<td><img src="photoProduit?idProd=${produit.idProd}" /></td>
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
		<div id="tableauProduit" class="cadre">
			<table>
				<tr>
					<th>ID</th>
					<th>Produit</th>
					<th>Quantité</th>
					<th>Quantité net</th>
					<th>Unité de mesure</th>
					<th>Prix unitaire</th>
					<th>Quantité en stock</th>
					<th>Commentaire</th>
					<th>Categorie</th>
					<th>Enseigne</th>
					<th>Marque</th>
					<th>Nature</th>
					<th>Type</th>
					<th>Utilisation</th>
					<th>Photo</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${produits}" var ="prod">
					<tr>
						<td>${prod.idProd}</td>
						<td>${prod.nomProd}</td>
						<td>${prod.qteProd}</td>
						<td>${prod.qteNetProd}</td>
						<td>${prod.uniteMesure}</td>
						<td>${prod.prixProd}</td>
						<td>${prod.qteStk}</td>
						<td>${prod.comProd}</td>
						<td>${prod.categorie.nomCat}</td>
						<td>${prod.enseigne.nomEns}</td>
						<td>${prod.marque.nomMarq}</td>
						<td>${prod.nature.nomNat}</td>
						<td>${prod.typeProduit.nomTypeProd}</td>
						<td>${prod.utilisation.nomUse}</td>
						<td><img src="photoProduit?idProd=${prod.idProd}" /></td>
						<td><a href="modifierProduit?idProd=${prod.idProd}">Modifier</a></td>
						<td><a href="supprimerProduit?idProd=${prod.idProd}">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>