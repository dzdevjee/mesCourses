package com.lamine.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.CellEditEvent;
import com.lamine.dao.entite.Enseigne;
import com.lamine.metier.impl.EnseigneMetierImpl;
import com.lamine.metier.interfaces.EnseigneMetier;

@ManagedBean(name="enseigneBean")
@RequestScoped
public class EnseigneBean {
	//Objets
	private EnseigneMetier enseigne;
	private Enseigne ensSelect;
	//Attributs
	private String nomEns;
	//Listes
	private List<Enseigne> listEnseignes;
	//valeurs modifiees
	private static Object ancienneValeur;
	private static Object nouvelleValeur;
	
	//Constructeur
	public EnseigneBean() {
	}
	
	@PostConstruct
	public void initBean() {
		//Injection des dependances inversées
		enseigne = new EnseigneMetierImpl();
		
		//Initialiser la liste des categories
		listEnseignes = new ArrayList<>();
		listEnseignes = enseigne.toutAfficher();
	}
	
	//Getters
	public EnseigneMetier getEnseigne() {
		return enseigne;
	}
	
	public Enseigne getEnsSelect() {
		return ensSelect;
	}

	public String getNomEns() {
		return nomEns;
	}

	public List<Enseigne> getListEnseignes() {
		return listEnseignes;
	}
	
	public Object getAncienneValeur() {
		return ancienneValeur;
	}

	public Object getNouvelleValeur() {
		return nouvelleValeur;
	}

	//Setters
	public void setEnseigne(EnseigneMetier enseigne) {
		this.enseigne = enseigne;
	}

	public void setEnsSelect(Enseigne ensSelect) {
		this.ensSelect = ensSelect;
	}
	
	public void setNomEns(String nomEns) {
		this.nomEns = nomEns;
	}
	
	public void setListEnseignes(List<Enseigne> listEnseignes) {
		this.listEnseignes = listEnseignes;
	}

	public void setAncienneValeur(Object ancienneValeur) {
		EnseigneBean.ancienneValeur = ancienneValeur;
	}

	public void setNouvelleValeur(Object nouvelleValeur) {
		EnseigneBean.nouvelleValeur = nouvelleValeur;
	}
	
	//Ajouter une enseigne
	public void ajouterEnseigne(ActionEvent action) {
		if (nomEns != null) {
			if ("".equalsIgnoreCase(nomEns)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					Enseigne e = new Enseigne();
					e.setNomEns(nomEns);
					enseigne.creer(e);
					listEnseignes = enseigne.toutAfficher();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Operation reussie!"));
				} catch (Exception ex) {
					ex.printStackTrace();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", ex.getMessage()));
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur fatale!", "Echec de l'operation"));
		}
	}
	
	//Modifier une enseigne
	public void modifierEnseigne() {
		if (ensSelect != null) {
			if ("".equalsIgnoreCase(ensSelect.getNomEns())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					ensSelect.setNomEns(nouvelleValeur.toString());
					enseigne.modifier(ensSelect);
					listEnseignes = enseigne.toutAfficher();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Operation reussie!"));
				} catch (Exception ex) {
					ex.printStackTrace();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", ex.getMessage()));
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

	//Supprimer une enseigne
	public void supprimerEnseigne() {
		if ((ensSelect != null) && (ensSelect.getNomEns() != null)) {
			try {
				enseigne.supprimer(ensSelect.getIdEns());
				listEnseignes = enseigne.toutAfficher();
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Operation reussie!"));
			} catch (Exception ex) {
				ex.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", ex.getMessage()));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur fatale!", "Echec de l'operation"));
		}
  	}
}