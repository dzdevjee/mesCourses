package com.lamine.dao.entite;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="UTILISATION")
public class Utilisation implements Serializable{
	//Attributs
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUse;
	@Column(name="nomUse")
	private String nomUse;
	
	//Constructeur
	public Utilisation() {
	}

	//Getters
	public Integer getIdUse() {
		return idUse;
	}

	public String getNomUse() {
		return nomUse;
	}

	//Setters
	public void setIdUse(Integer idUse) {
		this.idUse = idUse;
	}

	public void setNomUse(String nomUse) {
		this.nomUse = nomUse;
	}
}