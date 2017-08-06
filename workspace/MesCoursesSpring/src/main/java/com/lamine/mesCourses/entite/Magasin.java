package com.lamine.mesCourses.entite;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="MAGASIN")
public class Magasin implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMag;
	@Column(name="adrMag")
	@NotEmpty
	@NotBlank
	@NotNull
	private String adrMag;
	@Column(name="horMag")
	@NotEmpty
	@NotBlank
	@NotNull
	private String horMag;

	//Photo
	@Column(name="nomPhoto")
	private String nomPhoto;
	@Column(name="photo")
	@Lob
	private byte [] photo;

	//ORM
	@ManyToOne
	@JoinColumn(name="idEns",referencedColumnName="idEns")
	private Enseigne enseigne;
	@ManyToOne
	@JoinColumn(name="idTypeMag",referencedColumnName="idTypeMag")
	private TypeMagasin typeMagasin;

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

	public Enseigne getEnseigne() {
		return enseigne;
	}

	public TypeMagasin getTypeMagasin() {
		return typeMagasin;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public byte[] getPhoto() {
		return photo;
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

	public void setEnseigne(Enseigne enseigne) {
		this.enseigne = enseigne;
	}

	public void setTypeMagasin(TypeMagasin typeMagasin) {
		this.typeMagasin = typeMagasin;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}