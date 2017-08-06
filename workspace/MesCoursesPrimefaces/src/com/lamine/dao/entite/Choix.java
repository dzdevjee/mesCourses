package com.lamine.dao.entite;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="CHOIX")
public class Choix implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer idProd;
	@Id
	private Integer idMag;
	@Column(name="nomChoix")
	private String nomChoix;

	//ORM
	//@ManyToMany
//	@JoinColumn(name="idProd",referencedColumnName="idProd",insertable=false,updatable=false)
//	private Produit produit;
	
//	@ManyToMany
//	@JoinColumn(name="idMag",referencedColumnName="idMag",insertable=false,updatable=false)
//	private Magasin magasin;
		
	//Constructeur
	public Choix() {
	}

	//Getters
	public String getNomChoix() {
		return nomChoix;
	}

	public Integer getIdProd() {
		return idProd;
	}

	public Integer getIdMag() {
		return idMag;
	}

//	public Produit getProduit() {
//		return produit;
//	}

//	public Magasin getMagasin() {
//		return magasin;
//	}

	//Setters
	public void setNomChoix(String nomChoix) {
		this.nomChoix = nomChoix;
	}	
	
	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}

	public void setIdMag(Integer idMag) {
		this.idMag = idMag;
	}

//	public void setProduit(Produit produit) {
//		this.produit = produit;
//	}

//	public void setMagasin(Magasin magasin) {
//		this.magasin = magasin;
//	}
}