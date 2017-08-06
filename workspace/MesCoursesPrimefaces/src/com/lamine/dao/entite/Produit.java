package com.lamine.dao.entite;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="PRODUIT")
public class Produit implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProd;
	@Column(name="nomProd")
	private String nomProd;
	@Column(name="qteProd")
	private Integer qteProd;
	@Column(name="qteNetProd")
	private Integer qteNetProd;
	@Column(name="uniteMesure")
	private String uniteMesure;
	@Column(name="prixProd")
	private Double prixProd;
	@Column(name="qteStk")
	private Integer qteStk;
	@Column(name="comProd")
	private String comProd;
	//FK
	@Column(name="idMarq")
	private Integer idMarq;
	@Column(name="idTypeProd")
	private Integer idTypeProd;
	@Column(name="idNat")
	private Integer idNat;
	@Column(name="idCat")
	private Integer idCat;
	@Column(name="idUse")
	private Integer idUse;
	@Column(name="idEns")
	private Integer idEns;
	//ORM
	@ManyToOne
	@JoinColumn(name="idMarq",referencedColumnName="idMarq",insertable=false,updatable=false)
	private Marque marque;
	@ManyToOne
	@JoinColumn(name="idTypeProd",referencedColumnName="idTypeProd",insertable=false,updatable=false)
	private TypeProduit typeProduit;
	@ManyToOne
	@JoinColumn(name="idNat",referencedColumnName="idNat",insertable=false,updatable=false)
	private Nature nature;
	@ManyToOne
	@JoinColumn(name="idCat",referencedColumnName="idCat",insertable=false,updatable=false)
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name="idUse",referencedColumnName="idUse",insertable=false,updatable=false)
	private Utilisation utilisation;
	@ManyToOne
	@JoinColumn(name="idEns",referencedColumnName="idEns",insertable=false,updatable=false)
	private Enseigne enseigne;
	
	//Constructeur
	public Produit() {
	}

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

	public Integer getIdMarq() {
		return idMarq;
	}

	public Integer getIdTypeProd() {
		return idTypeProd;
	}

	public Integer getIdNat() {
		return idNat;
	}

	public Integer getIdCat() {
		return idCat;
	}

	public Integer getIdUse() {
		return idUse;
	}

	public Integer getIdEns() {
		return idEns;
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

	public void setIdMarq(Integer idMarq) {
		this.idMarq = idMarq;
	}

	public void setIdTypeProd(Integer idTypeProd) {
		this.idTypeProd = idTypeProd;
	}

	public void setIdNat(Integer idNat) {
		this.idNat = idNat;
	}

	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}

	public void setIdUse(Integer idUse) {
		this.idUse = idUse;
	}

	public void setIdEns(Integer idEns) {
		this.idEns = idEns;
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
}