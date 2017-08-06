package com.lamine.mesCourses.entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="UTILISATION")
public class Utilisation implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUse;
	@Column(name="nomUse")
	@NotEmpty
	@NotBlank
	@NotNull
	private String nomUse;

	//Photo
	@Column(name="nomPhoto")
	private String nomPhoto;
	@Column(name="photo")
	@Lob
	private byte [] photo;

	//ORM
	@OneToMany(mappedBy="utilisation")
	private Collection<Produit> listProduits;

	//Getters
	public Integer getIdUse() {
		return idUse;
	}

	public String getNomUse() {
		return nomUse;
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
	public void setIdUse(Integer idUse) {
		this.idUse = idUse;
	}

	public void setNomUse(String nomUse) {
		this.nomUse = nomUse;
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