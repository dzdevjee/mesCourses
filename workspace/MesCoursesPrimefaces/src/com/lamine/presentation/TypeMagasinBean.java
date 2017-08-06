package com.lamine.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.CellEditEvent;
import com.lamine.dao.entite.TypeMagasin;
import com.lamine.metier.impl.TypeMagasinMetierImpl;
import com.lamine.metier.interfaces.TypeMagasinMetier;

@ManagedBean(name="typeMagasinBean")
@RequestScoped
public class TypeMagasinBean {
	//Objets
	private TypeMagasinMetier typeMagasin;
	private TypeMagasin typeMagSelect;
	//Attributs
	private String nomTypeMag;
	//Listes
	private List<TypeMagasin> listTypesMagasin;
	//valeurs modifiees
	private static Object ancienneValeur;
	private static Object nouvelleValeur;
	
	//Constructeur
	public TypeMagasinBean() {
	}
	
	@PostConstruct
	public void initBean() {
		//Injection des dependances inversées
		typeMagasin = new TypeMagasinMetierImpl();
		
		//Initialiser la liste des natures
		listTypesMagasin = new ArrayList<>();
		listTypesMagasin = typeMagasin.toutAfficher();
	}

	//Getters
	public TypeMagasinMetier getTypeMagasin() {
		return typeMagasin;
	}

	public TypeMagasin getTypeMagSelect() {
		return typeMagSelect;
	}

	public String getNomTypeMag() {
		return nomTypeMag;
	}

	public List<TypeMagasin> getListTypesMagasin() {
		return listTypesMagasin;
	}

	public static Object getAncienneValeur() {
		return ancienneValeur;
	}

	public static Object getNouvelleValeur() {
		return nouvelleValeur;
	}

	//Setters
	public void setTypeMagasin(TypeMagasinMetier typeMagasin) {
		this.typeMagasin = typeMagasin;
	}

	public void setTypeMagSelect(TypeMagasin typeMagSelect) {
		this.typeMagSelect = typeMagSelect;
	}

	public void setNomTypeMag(String nomTypeMag) {
		this.nomTypeMag = nomTypeMag;
	}

	public void setListTypesMagasin(List<TypeMagasin> listTypesMagasin) {
		this.listTypesMagasin = listTypesMagasin;
	}

	public static void setAncienneValeur(Object ancienneValeur) {
		TypeMagasinBean.ancienneValeur = ancienneValeur;
	}

	public static void setNouvelleValeur(Object nouvelleValeur) {
		TypeMagasinBean.nouvelleValeur = nouvelleValeur;
	}

	//Ajouter un type magasin
	public void ajouterTypeMagasin(ActionEvent action) {
		if (nomTypeMag != null) {
			if ("".equalsIgnoreCase(nomTypeMag)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					TypeMagasin tm = new TypeMagasin();
					tm.setNomTypeMag(nomTypeMag);
					typeMagasin.creer(tm);
					listTypesMagasin = typeMagasin.toutAfficher();
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

	//Modifier un type magasin
	public void modifierTypeMagasin(ActionEvent action) {
		if (typeMagSelect != null) {
			if ("".equalsIgnoreCase(typeMagSelect.getNomTypeMag())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					typeMagSelect.setNomTypeMag(nouvelleValeur.toString());
					typeMagasin.modifier(typeMagSelect);
					listTypesMagasin = typeMagasin.toutAfficher();
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

	//Supprimer un type magasin
	public void supprimerTypeMagasin() {
		if (typeMagSelect != null) {
			try {
				typeMagasin.supprimer(typeMagSelect.getIdTypeMag());
				listTypesMagasin = typeMagasin.toutAfficher();
				
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