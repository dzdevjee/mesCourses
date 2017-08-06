package com.lamine.mesCourses.entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="NATURE")
public class Nature implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idNat;
	@Column(name="nomNat")
	@NotEmpty
	@NotBlank
	@NotNull
	private String nomNat;

	//Photo
	@Column(name="nomPhoto")
	private String nomPhoto;
	@Column(name="photo")
	@Lob
	private byte [] photo;

	//ORM
	@OneToMany(mappedBy="nature")
	private Collection<Produit> listProduits;

	//Getters
	public Integer getIdNat() {
		return idNat;
	}

	public String getNomNat() {
		return nomNat;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public Collection<Produit> getListProduits() {
		return listProduits;
	}

	//Setters
	public void setIdNat(Integer idNat) {
		this.idNat = idNat;
	}

	public void setNomNat(String nomNat) {
		this.nomNat = nomNat;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public void setListProduits(Collection<Produit> listProduits) {
		this.listProduits = listProduits;
	}
}