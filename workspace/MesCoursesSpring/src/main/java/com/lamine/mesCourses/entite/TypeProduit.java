package com.lamine.mesCourses.entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TYPE_PRODUIT")
public class TypeProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTypeProd;
	@Column(name="nomTypeProd")
	@NotEmpty
	@NotBlank
	@NotNull
	private String nomTypeProd;

	//Photo
	@Column(name="nomPhoto")
	private String nomPhoto;
	@Column(name="photo")
	@Lob
	private byte [] photo;

	//ORM
	@OneToMany(mappedBy="typeProduit")
	private Collection<Produit> listProduits;

	//Getters
	public Integer getIdTypeProd() {
		return idTypeProd;
	}

	public String getNomTypeProd() {
		return nomTypeProd;
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
	public void setIdTypeProd(Integer idTypeProd) {
		this.idTypeProd = idTypeProd;
	}

	public void setNomTypeProd(String nomTypeProd) {
		this.nomTypeProd = nomTypeProd;
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