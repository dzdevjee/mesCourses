package com.lamine.dao.entite;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="ENSEIGNE")
public class Enseigne implements Serializable{
	//Attributs
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEns;
	@Column(name="nomEns")
	private String nomEns;
	
	//Constructeur
	public Enseigne() {
	}

	//Getters
	public Integer getIdEns() {
		return idEns;
	}

	public String getNomEns() {
		return nomEns;
	}

	//Setters
	public void setIdEns(Integer idEns) {
		this.idEns = idEns;
	}

	public void setNomEns(String nomEns) {
		this.nomEns = nomEns;
	}
}