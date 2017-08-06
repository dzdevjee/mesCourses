package com.lamine.mesCourses.entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TYPE_MAGASIN")
public class TypeMagasin implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTypeMag;
	@Column(name="nomTypeMag")
	@NotEmpty
	@NotBlank
	@NotNull
	private String nomTypeMag;

	//Photo
	@Column(name="nomPhoto")
	private String nomPhoto;
	@Column(name="photo")
	@Lob
	private byte [] photo;

	//ORM
	@OneToMany(mappedBy="typeMagasin")
	private Collection<Magasin> listMagasins;

	//Getters
	public Integer getIdTypeMag() {
		return idTypeMag;
	}

	public String getNomTypeMag() {
		return nomTypeMag;
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

	//Setters
	public void setIdTypeMag(Integer idTypeMag) {
		this.idTypeMag = idTypeMag;
	}

	public void setNomTypeMag(String nomTypeMag) {
		this.nomTypeMag = nomTypeMag;
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
}