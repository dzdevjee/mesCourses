package com.lamine.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.CellEditEvent;
import com.lamine.dao.entite.Categorie;
import com.lamine.metier.impl.CategorieMetierImpl;
import com.lamine.metier.interfaces.CategorieMetier;

@ManagedBean(name="categorieBean")
@RequestScoped
public class CategorieBean {
	//Objets
	private CategorieMetier categorie;
	private Categorie catSelect;
	//Attributs
	private String nomCat;
	//Listes
	private List<Categorie> listCategories;
	//valeurs modifiees
	private static Object ancienneValeur;
	private static Object nouvelleValeur;
	
	//Constructeur
	public CategorieBean() {
	}
	
	@PostConstruct
	public void initBean() {
		//Injection des dependances inversées
		categorie = new CategorieMetierImpl();
		
		//Initialiser la liste des categories
		listCategories = new ArrayList<>();
		listCategories = categorie.toutAfficher();
	}
	
	//Getters
	public CategorieMetier getCategorie() {
		return categorie;
	}
	
	public Categorie getCatSelect() {
		return catSelect;
	}

	public String getNomCat() {
		return nomCat;
	}

	public List<Categorie> getListCategories() {
		return listCategories;
	}
	
	public Object getAncienneValeur() {
		return ancienneValeur;
	}

	public Object getNouvelleValeur() {
		return nouvelleValeur;
	}

	//Setters
	public void setCategorie(CategorieMetier categorie) {
		this.categorie = categorie;
	}

	public void setCatSelect(Categorie catSelect) {
		this.catSelect = catSelect;
	}
	
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	
	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}

	public void setAncienneValeur(Object ancienneValeur) {
		CategorieBean.ancienneValeur = ancienneValeur;
	}

	public void setNouvelleValeur(Object nouvelleValeur) {
		CategorieBean.nouvelleValeur = nouvelleValeur;
	}
	
	//Ajouter une categorie
	public void ajouterCategorie(ActionEvent action) {
		if (nomCat != null) {
			if ("".equalsIgnoreCase(nomCat)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					Categorie c = new Categorie();
					c.setNomCat(nomCat);
					categorie.creer(c);
					listCategories = categorie.toutAfficher();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Operation reussie!"));
				} catch (Exception e) {
					e.printStackTrace();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", e.getMessage()));
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur fatale!", "Echec de l'operation"));
		}
	}
	
	//Modifier une categorie
	public void modifierCategorie() {
		if (catSelect != null) {
			if ("".equalsIgnoreCase(catSelect.getNomCat())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					catSelect.setNomCat(nouvelleValeur.toString());
					categorie.modifier(catSelect);
					listCategories = categorie.toutAfficher();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Operation reussie!"));
				} catch (Exception e) {
					e.printStackTrace();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", e.getMessage()));
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur fatale!", "Echec de l'operation"));
		}
  	}

	public void editerCellule(CellEditEvent event) {
		ancienneValeur = event.getOldValue();
		nouvelleValeur = event.getNewValue();
	}

	//Supprimer une categorie
	public void supprimerCategorie() {
		if ((catSelect != null) && (catSelect.getNomCat() != null)) {
			try {
				categorie.supprimer(catSelect.getIdCat());
				listCategories = categorie.toutAfficher();
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Operation reussie!"));
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", e.getMessage()));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur fatale!", "Echec de l'operation"));
		}
  	}
}