package com.lamine.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.CellEditEvent;
import com.lamine.dao.entite.Marque;
import com.lamine.metier.impl.MarqueMetierImpl;
import com.lamine.metier.interfaces.MarqueMetier;

@ManagedBean(name="marqueBean")
@RequestScoped
public class MarqueBean {
	//Objets
	private MarqueMetier marque;
	private Marque marqSelect;
	//Attributs
	private String nomMarq;
	//Listes
	private List<Marque> listMarques;
	//valeurs modifiees
	private static Object ancienneValeur;
	private static Object nouvelleValeur;
	
	//Constructeur
	public MarqueBean() {
	}
	
	@PostConstruct
	public void initBean() {
		//Injection des dependances inversées
		marque = new MarqueMetierImpl();
		
		//Initialiser la liste des natures
		listMarques = new ArrayList<>();
		listMarques = marque.toutAfficher();
	}

	//Getters
	public MarqueMetier getMarque() {
		return marque;
	}

	public Marque getMarqSelect() {
		return marqSelect;
	}

	public String getNomMarq() {
		return nomMarq;
	}

	public List<Marque> getListMarques() {
		return listMarques;
	}
	
	public static Object getAncienneValeur() {
		return ancienneValeur;
	}

	public static Object getNouvelleValeur() {
		return nouvelleValeur;
	}
	
	//Setters
	public void setMarque(MarqueMetier marque) {
		this.marque = marque;
	}

	public void setMarqSelect(Marque marqSelect) {
		this.marqSelect = marqSelect;
	}

	public void setNomMarq(String nomMarq) {
		this.nomMarq = nomMarq;
	}

	public void setListMarques(List<Marque> listMarques) {
		this.listMarques = listMarques;
	}

	public static void setAncienneValeur(Object ancienneValeur) {
		MarqueBean.ancienneValeur = ancienneValeur;
	}

	public static void setNouvelleValeur(Object nouvelleValeur) {
		MarqueBean.nouvelleValeur = nouvelleValeur;
	}	

	//Ajouter une marque
	public void ajouterMarque(ActionEvent action) {
		if (nomMarq != null) {
			if ("".equalsIgnoreCase(nomMarq)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					Marque m = new Marque();
					m.setNomMarq(nomMarq);
					marque.creer(m);
					listMarques = marque.toutAfficher();
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
	
	//Modifier une marque
	public void modifierMarque(ActionEvent action) {
		if (marqSelect != null) {
			if ("".equalsIgnoreCase(marqSelect.getNomMarq())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					marqSelect.setNomMarq(nouvelleValeur.toString());
					marque.modifier(marqSelect);
					listMarques = marque.toutAfficher();
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

	//Supprimer une marque
	public void supprimerMarque() {
		if ((marqSelect != null) && (marqSelect.getNomMarq() != null)) {
			try {
				marque.supprimer(marqSelect.getIdMarq());
				listMarques = marque.toutAfficher();
				
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