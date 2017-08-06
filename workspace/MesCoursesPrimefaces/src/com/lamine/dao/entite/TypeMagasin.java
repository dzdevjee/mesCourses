package com.lamine.dao.entite;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="TYPE_MAGASIN")
public class TypeMagasin implements Serializable {
	//Attributs
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTypeMag;
	@Column(name="nomTypeMag")
	private String nomTypeMag;
	
	//Constructeur
	public TypeMagasin() {
	}

	//Getters
	public Integer getIdTypeMag() {
		return idTypeMag;
	}

	public String getNomTypeMag() {
		return nomTypeMag;
	}
	
	//Setters
	public void setIdTypeMag(Integer idTypeMag) {
		this.idTypeMag = idTypeMag;
	}
	
	public void setNomTypeMag(String nomTypeMag) {
		this.nomTypeMag = nomTypeMag;
	}
}