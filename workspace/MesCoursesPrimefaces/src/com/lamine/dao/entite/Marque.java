package com.lamine.dao.entite;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="MARQUE")
public class Marque implements Serializable {
	//Attributs
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMarq;
	@Column(name="nomMarq")
	private String nomMarq;
	
	//Constructeur
	public Marque() {
	}

	//Getters
	public Integer getIdMarq() {
		return idMarq;
	}

	public String getNomMarq() {
		return nomMarq;
	}

	//Setters
	public void setIdMarq(Integer idMarq) {
		this.idMarq = idMarq;
	}

	public void setNomMarq(String nomMarq) {
		this.nomMarq = nomMarq;
	}
}