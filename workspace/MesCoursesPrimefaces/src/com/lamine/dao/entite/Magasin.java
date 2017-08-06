package com.lamine.dao.entite;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="MAGASIN")
public class Magasin implements Serializable {
	//Attributs
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMag;
	@Column(name="adrMag")
	private String adrMag;
	@Column(name="horMag")
	private String horMag;
	//FK
	@Column(name="idEns")
	private Integer idEns;
	@Column(name="idTypeMag")
	private Integer idTypeMag;
	
	//ORM
	@ManyToOne
	@JoinColumn(name="idEns",referencedColumnName="idEns",insertable=false,updatable=false)
	private Enseigne enseigne;
	@ManyToOne
	@JoinColumn(name="idTypeMag",referencedColumnName="idTypeMag",insertable=false,updatable=false)
	private TypeMagasin typeMagasin;
	
	//Constructeur
	public Magasin() {
	}

	//Getters
	public Integer getIdMag() {
		return idMag;
	}

	public String getAdrMag() {
		return adrMag;
	}

	public String getHorMag() {
		return horMag;
	}
	
	public Integer getIdEns() {
		return idEns;
	}
	
	public Integer getIdTypeMag() {
		return idTypeMag;
	}

	public Enseigne getEnseigne() {
		return enseigne;
	}
	
	public TypeMagasin getTypeMagasin() {
		return typeMagasin;
	}

	//Setters
	public void setIdMag(Integer idMag) {
		this.idMag = idMag;
	}

	public void setAdrMag(String adrMag) {
		this.adrMag = adrMag;
	}

	public void setHorMag(String horMag) {
		this.horMag = horMag;
	}
	
	public void setIdEns(Integer idEns) {
		this.idEns = idEns;
	}
	
	public void setIdTypeMag(Integer idTypeMag) {
		this.idTypeMag = idTypeMag;
	}

	public void setEnseigne(Enseigne enseigne) {
		this.enseigne = enseigne;
	}

	public void setTypeMagasin(TypeMagasin typeMagasin) {
		this.typeMagasin = typeMagasin;
	}
}