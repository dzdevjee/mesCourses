package com.lamine.dao.entite;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="CATEGORIE")
public class Categorie implements Serializable {
	//Attributs
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCat;
	@Column(name="nomCat")
	private String nomCat;
	
	//Constructeur
	public Categorie() {
	}

	//Getters
	public Integer getIdCat() {
		return idCat;
	}

	public String getNomCat() {
		return nomCat;
	}

	//Setters
	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
}