package com.lamine.dao.entite;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="TYPE_PRODUIT")
public class TypeProduit implements Serializable {
	//Attributs
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTypeProd;
	@Column(name="nomTypeProd")
	private String nomTypeProd;
	
	//Constructeur
	public TypeProduit() {
	}

	//Getters
	public Integer getIdTypeProd() {
		return idTypeProd;
	}

	public String getNomTypeProd() {
		return nomTypeProd;
	}
	
	//Setters
	public void setIdTypeProd(Integer idTypeProd) {
		this.idTypeProd = idTypeProd;
	}
	
	public void setNomTypeProd(String nomTypeProd) {
		this.nomTypeProd = nomTypeProd;
	}
}