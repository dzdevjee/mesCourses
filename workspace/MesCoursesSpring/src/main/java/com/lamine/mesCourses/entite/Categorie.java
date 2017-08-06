package com.lamine.mesCourses.entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CATEGORIE")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCat;
	@Column(name="nomCat")
	@NotBlank
	@NotEmpty
	@NotNull
	private String nomCat;

	//Photo
	@Column(name="nomPhoto")
	private String nomPhoto;
	@Column(name="photo")
	@Lob
	private byte [] photo;

	//ORM
	@OneToMany(mappedBy="categorie")
	private Collection<Produit> listProduits;

	//Getters
	public Integer getIdCat() {
		return idCat;
	}

	public String getNomCat() {
		return nomCat;
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
	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
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