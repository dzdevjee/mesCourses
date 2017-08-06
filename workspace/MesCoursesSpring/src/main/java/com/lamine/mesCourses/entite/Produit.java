package com.lamine.mesCourses.entite;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="PRODUIT")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProd;
	@Column(name="nomProd")
	@NotEmpty
	@NotBlank
	@NotNull
	private String nomProd;
	@Column(name="qteProd")

	private Integer qteProd;
	@Column(name="qteNetProd")

	private Integer qteNetProd;
	@Column(name="uniteMesure")
	@NotEmpty
	@NotBlank
	@NotNull
	private String uniteMesure;
	@Column(name="prixProd")

	private Double prixProd;
	@Column(name="qteStk")

	private Integer qteStk;
	@Column(name="comProd")
	@NotEmpty
	@NotBlank
	@NotNull
	private String comProd;

	//Photo
	@Column(name="nomPhoto")
	private String nomPhoto;
	@Column(name="photo")
	@Lob
	private byte [] photo;

	//ORM
	@ManyToOne
	@JoinColumn(name="idCat",referencedColumnName="idCat")
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name="idEns",referencedColumnName="idEns")
	private Enseigne enseigne;
	@ManyToOne
	@JoinColumn(name="idMarq",referencedColumnName="idMarq")
	private Marque marque;
	@ManyToOne
	@JoinColumn(name="idNat",referencedColumnName="idNat")
	private Nature nature;
	@ManyToOne
	@JoinColumn(name="idTypeProd",referencedColumnName="idTypeProd")
	private TypeProduit typeProduit;
	@ManyToOne
	@JoinColumn(name="idUse",referencedColumnName="idUse")
	private Utilisation utilisation;

	//Getters
	public Integer getIdProd() {
		return idProd;
	}

	public String getNomProd() {
		return nomProd;
	}

	public Integer getQteProd() {
		return qteProd;
	}

	public Integer getQteNetProd() {
		return qteNetProd;
	}

	public String getUniteMesure() {
		return uniteMesure;
	}

	public Double getPrixProd() {
		return prixProd;
	}

	public Integer getQteStk() {
		return qteStk;
	}

	public String getComProd() {
		return comProd;
	}

	public Marque getMarque() {
		return marque;
	}

	public TypeProduit getTypeProduit() {
		return typeProduit;
	}

	public Nature getNature() {
		return nature;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public Utilisation getUtilisation() {
		return utilisation;
	}

	public Enseigne getEnseigne() {
		return enseigne;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public byte[] getPhoto() {
		return photo;
	}

	//Setters
	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public void setQteProd(Integer qteProd) {
		this.qteProd = qteProd;
	}

	public void setQteNetProd(Integer qteNetProd) {
		this.qteNetProd = qteNetProd;
	}

	public void setUniteMesure(String uniteMesure) {
		this.uniteMesure = uniteMesure;
	}

	public void setPrixProd(Double prixProd) {
		this.prixProd = prixProd;
	}

	public void setQteStk(Integer qteStk) {
		this.qteStk = qteStk;
	}

	public void setComProd(String comProd) {
		this.comProd = comProd;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setUtilisation(Utilisation utilisation) {
		this.utilisation = utilisation;
	}

	public void setEnseigne(Enseigne enseigne) {
		this.enseigne = enseigne;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}