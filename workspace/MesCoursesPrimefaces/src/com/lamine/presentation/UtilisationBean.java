package com.lamine.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.CellEditEvent;
import com.lamine.dao.entite.Utilisation;
import com.lamine.metier.impl.UtilisationMetierImpl;
import com.lamine.metier.interfaces.UtilisationMetier;

@ManagedBean(name="utilisationBean")
@RequestScoped
public class UtilisationBean {
	//Objets
	private UtilisationMetier utilisation;
	private Utilisation useSelect;
	//Attributs
	private String nomUse;
	//Listes
	private List<Utilisation> listUtilisations;
	//valeurs modifiees
	private static Object ancienneValeur;
	private static Object nouvelleValeur;
	
	//Constructeur
	public UtilisationBean() {
	}
	
	@PostConstruct
	public void initBean() {
		//Injection des dependances inversées
		utilisation = new UtilisationMetierImpl();
		
		//Initialiser la liste des natures
		listUtilisations = new ArrayList<>();
		listUtilisations = utilisation.toutAfficher();
	}

	//Getters
	public UtilisationMetier getUtilisation() {
		return utilisation;
	}

	public Utilisation getUseSelect() {
		return useSelect;
	}

	public String getNomUse() {
		return nomUse;
	}

	public List<Utilisation> getListUtilisations() {
		return listUtilisations;
	}

	public static Object getAncienneValeur() {
		return ancienneValeur;
	}

	public static Object getNouvelleValeur() {
		return nouvelleValeur;
	}

	//Setters
	public void setUtilisation(UtilisationMetier utilisation) {
		this.utilisation = utilisation;
	}

	public void setUseSelect(Utilisation useSelect) {
		this.useSelect = useSelect;
	}

	public void setNomUse(String nomUse) {
		this.nomUse = nomUse;
	}

	public void setListUtilisations(List<Utilisation> listUtilisations) {
		this.listUtilisations = listUtilisations;
	}

	public static void setAncienneValeur(Object ancienneValeur) {
		UtilisationBean.ancienneValeur = ancienneValeur;
	}

	public static void setNouvelleValeur(Object nouvelleValeur) {
		UtilisationBean.nouvelleValeur = nouvelleValeur;
	}

	//Ajouter une utilisation
	public void ajouterUtilisation(ActionEvent action) {
		if (nomUse != null) {
			if ("".equalsIgnoreCase(nomUse)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					Utilisation u = new Utilisation();
					u.setNomUse(nomUse);
					utilisation.creer(u);
					listUtilisations = utilisation.toutAfficher();
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

	//Modifier une utilisation
	public void modifierUtilisation() {
		if (useSelect != null) {
			if ("".equalsIgnoreCase(useSelect.getNomUse())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					useSelect.setNomUse(nouvelleValeur.toString());
					System.out.println(useSelect.getNomUse());
					System.out.println(useSelect.getIdUse());
					System.out.println(useSelect.getClass());
					
					Utilisation test = new Utilisation();
					test.setIdUse(useSelect.getIdUse());
					test.setNomUse(nouvelleValeur.toString());
					
					utilisation.modifier(test);
					listUtilisations = utilisation.toutAfficher();
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

	//Supprimer une utilisation
	public void supprimerUtilisation() {
		if ((useSelect != null) && (useSelect.getNomUse() != null)) {
			try {
				utilisation.supprimer(useSelect.getIdUse());
				listUtilisations = utilisation.toutAfficher();
				
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