package com.lamine.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.CellEditEvent;
import com.lamine.dao.entite.TypeProduit;
import com.lamine.metier.impl.TypeProduitMetierImpl;
import com.lamine.metier.interfaces.TypeProduitMetier;

@ManagedBean(name="typeProduitBean")
@RequestScoped
public class TypeProduitBean {
	//Objets
	private TypeProduitMetier typeProduit;
	private TypeProduit typeProdSelect;
	//Attributs
	private String nomTypeProd;
	//Listes
	private List<TypeProduit> listTypesProduit;
	//valeurs modifiees
	private static Object ancienneValeur;
	private static Object nouvelleValeur;
	
	//Constructeur
	public TypeProduitBean() {
	}
	
	@PostConstruct
	public void initBean() {
		//Injection des dependances inversées
		typeProduit = new TypeProduitMetierImpl();
		
		//Initialiser la liste des natures
		listTypesProduit = new ArrayList<>();
		listTypesProduit = typeProduit.toutAfficher();
	}

	//Getters
	public TypeProduitMetier getTypeProduit() {
		return typeProduit;
	}

	public TypeProduit getTypeProdSelect() {
		return typeProdSelect;
	}

	public String getNomTypeProd() {
		return nomTypeProd;
	}

	public List<TypeProduit> getListTypesProduit() {
		return listTypesProduit;
	}

	public static Object getAncienneValeur() {
		return ancienneValeur;
	}

	public static Object getNouvelleValeur() {
		return nouvelleValeur;
	}

	//Setters
	public void setTypeProduit(TypeProduitMetier typeProduit) {
		this.typeProduit = typeProduit;
	}

	public void setTypeProdSelect(TypeProduit typeProdSelect) {
		this.typeProdSelect = typeProdSelect;
	}

	public void setNomTypeProd(String nomTypeProd) {
		this.nomTypeProd = nomTypeProd;
	}

	public void setListTypesProduit(List<TypeProduit> listTypesProduit) {
		this.listTypesProduit = listTypesProduit;
	}

	public static void setAncienneValeur(Object ancienneValeur) {
		TypeProduitBean.ancienneValeur = ancienneValeur;
	}

	public static void setNouvelleValeur(Object nouvelleValeur) {
		TypeProduitBean.nouvelleValeur = nouvelleValeur;
	}

	//Ajouter un type produit
	public void ajouterTypeProduit(ActionEvent action) {
		if (nomTypeProd != null) {
			if ("".equalsIgnoreCase(nomTypeProd)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					TypeProduit tp = new TypeProduit();
					tp.setNomTypeProd(nomTypeProd);
					typeProduit.creer(tp);
					listTypesProduit = typeProduit.toutAfficher();
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

	//Modifier un type Produit
	public void modifierTypeProduit(ActionEvent action) {
		if (typeProdSelect != null) {
			if ("".equalsIgnoreCase(typeProdSelect.getNomTypeProd())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					typeProdSelect.setNomTypeProd(nouvelleValeur.toString());
					typeProduit.modifier(typeProdSelect);
					listTypesProduit = typeProduit.toutAfficher();
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
	public void supprimerTypeProduit() {
		if ((typeProdSelect != null) && (typeProdSelect.getNomTypeProd() != null)) {
			try {
				typeProduit.supprimer(typeProdSelect.getIdTypeProd());
				listTypesProduit = typeProduit.toutAfficher();
				
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