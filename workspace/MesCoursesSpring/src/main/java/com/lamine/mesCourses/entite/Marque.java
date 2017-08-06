package com.lamine.mesCourses.entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="MARQUE")
public class Marque implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMarq;
	@Column(name="nomMarq")
	@NotEmpty
	@NotBlank
	@NotNull
	private String nomMarq;

	//Photo
	@Column(name="nomPhoto")
	private String nomPhoto;
	@Column(name="photo")
	@Lob
	private byte [] photo;

	//ORM
	@OneToMany(mappedBy="marque")
	private Collection<Produit> listProduits;

	//Getters
	public Integer getIdMarq() {
		return idMarq;
	}

	public String getNomMarq() {
		return nomMarq;
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
	public void setIdMarq(Integer idMarq) {
		this.idMarq = idMarq;
	}

	public void setNomMarq(String nomMarq) {
		this.nomMarq = nomMarq;
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