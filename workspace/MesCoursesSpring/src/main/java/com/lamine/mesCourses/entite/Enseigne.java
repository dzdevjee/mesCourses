package com.lamine.mesCourses.entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ENSEIGNE")
public class Enseigne implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEns;
	@Column(name="nomEns")
	@NotEmpty
	@NotBlank
	@NotNull
	private String nomEns;

	//Photo
	@Column(name="nomPhoto")
	private String nomPhoto;
	@Column(name="photo")
	@Lob
	private byte [] photo;

	//ORM
	@OneToMany(mappedBy="enseigne")
	private Collection<Magasin> listMagasins;
	@OneToMany(mappedBy="enseigne")
	private Collection<Produit> listProduits;

	//Getters
	public Integer getIdEns() {
		return idEns;
	}

	public String getNomEns() {
		return nomEns;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public Collection<Magasin> getListMagasins() {
		return listMagasins;
	}

	public Collection<Produit> getListProduits() {
		return listProduits;
	}

	//Setters
	public void setIdEns(Integer idEns) {
		this.idEns = idEns;
	}

	public void setNomEns(String nomEns) {
		this.nomEns = nomEns;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public void setListMagasins(Collection<Magasin> listMagasins) {
		this.listMagasins = listMagasins;
	}

	public void setListProduits(Collection<Produit> listProduits) {
		this.listProduits = listProduits;
	}
}