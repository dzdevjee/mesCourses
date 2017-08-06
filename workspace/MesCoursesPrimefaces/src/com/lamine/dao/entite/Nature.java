package com.lamine.dao.entite;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="NATURE")
public class Nature implements Serializable {
	//Attributs
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idNat;
	@Column(name="nomNat")
	private String nomNat;
	
	//Constructeur
	public Nature() {
	}

	//Getters
	public Integer getIdNat() {
		return idNat;
	}

	public String getNomNat() {
		return nomNat;
	}

	//Setters
	public void setIdNat(Integer idNat) {
		this.idNat = idNat;
	}

	public void setNomNat(String nomNat) {
		this.nomNat = nomNat;
	}
}