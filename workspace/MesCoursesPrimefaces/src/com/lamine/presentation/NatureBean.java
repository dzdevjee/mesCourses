package com.lamine.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.CellEditEvent;
import com.lamine.dao.entite.Nature;
import com.lamine.metier.impl.NatureMetierImpl;
import com.lamine.metier.interfaces.NatureMetier;

@ManagedBean(name="natureBean")
@RequestScoped
public class NatureBean {
	//Objets
	private NatureMetier nature;
	private Nature natSelect;
	//Attributs
	private String nomNat;
	//Listes
	private List<Nature> listNatures;
	//valeurs modifiees
	private static Object ancienneValeur;
	private static Object nouvelleValeur;
	
	//Constructeur
	public NatureBean() {
	}
	
	@PostConstruct
	public void initBean() {
		//Injection des dependances inversées
		nature = new NatureMetierImpl();
		
		//Initialiser la liste des natures
		listNatures = new ArrayList<>();
		listNatures = nature.toutAfficher();
	}

	//Getters
	public NatureMetier getNature() {
		return nature;
	}

	public Nature getNatSelect() {
		return natSelect;
	}

	public String getNomNat() {
		return nomNat;
	}

	public List<Nature> getListNatures() {
		return listNatures;
	}

	public static Object getAncienneValeur() {
		return ancienneValeur;
	}

	public static Object getNouvelleValeur() {
		return nouvelleValeur;
	}
	
	//Setters
	public void setNature(NatureMetier nature) {
		this.nature = nature;
	}

	public void setNatSelect(Nature natSelect) {
		this.natSelect = natSelect;
	}

	public void setNomNat(String nomNat) {
		this.nomNat = nomNat;
	}

	public void setListNatures(List<Nature> listNatures) {
		this.listNatures = listNatures;
	}

	public static void setAncienneValeur(Object ancienneValeur) {
		NatureBean.ancienneValeur = ancienneValeur;
	}

	public static void setNouvelleValeur(Object nouvelleValeur) {
		NatureBean.nouvelleValeur = nouvelleValeur;
	}	

	//Ajouter une nature
	public void ajouterNature(ActionEvent action) {
		if (nomNat != null) {
			if ("".equalsIgnoreCase(nomNat)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					Nature n = new Nature();
					n.setNomNat(nomNat);
					nature.creer(n);
					listNatures = nature.toutAfficher();
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
	
	//Modifier une nature
	public void modifierNature(ActionEvent action) {
		if (natSelect != null) {
			if ("".equalsIgnoreCase(natSelect.getNomNat())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					natSelect.setNomNat(nouvelleValeur.toString());
					nature.modifier(natSelect);
					listNatures = nature.toutAfficher();
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

	//Supprimer une nature
	public void supprimerNature() {
		if ((natSelect != null) && (natSelect.getNomNat() != null)) {
			try {
				nature.supprimer(natSelect.getIdNat());
				listNatures = nature.toutAfficher();
				
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