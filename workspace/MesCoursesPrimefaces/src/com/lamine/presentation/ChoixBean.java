package com.lamine.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import com.lamine.dao.entite.Choix;
import com.lamine.dao.entite.Magasin;
import com.lamine.dao.entite.Produit;
import com.lamine.metier.impl.ChoixMetierImpl;
import com.lamine.metier.impl.MagasinMetierImpl;
import com.lamine.metier.impl.ProduitMetierImpl;
import com.lamine.metier.interfaces.ChoixMetier;
import com.lamine.metier.interfaces.MagasinMetier;
import com.lamine.metier.interfaces.ProduitMetier;

@ManagedBean(name="choixBean")
@RequestScoped
public class ChoixBean {
	private ChoixMetier choix;
	private String nomProd;
	private String nomMag;
	private List<SelectItem> listProd;
	private List<SelectItem> listMag;
	private String nomChoix;
	private ProduitMetier produit;
	private MagasinMetier magasin;
	private boolean affSect;
	
	//Constructeur
	public ChoixBean() {
	}
	
	@PostConstruct
	public void initBean() {
		produit = new ProduitMetierImpl();
		magasin = new MagasinMetierImpl();
		choix = new ChoixMetierImpl();
		nomChoix = "";
		List<Produit> listeP = produit.toutAfficher();
		listProd = new ArrayList<>();
		for (Produit p:listeP) {
			listProd.add(new SelectItem(p.getIdProd(), p.getNomProd()));
		}
		List<Magasin> listeM = magasin.toutAfficher();
		listMag = new ArrayList<>();
		for (Magasin m:listeM) {
			listMag.add(new SelectItem(m.getIdMag(), m.getAdrMag()));
		}
		affSect = false;
	}

	//Getters	
	public String getNomProd() {
		return nomProd;
	}

	public String getNomMag() {
		return nomMag;
	}

	public List<SelectItem> getListProd() {
		return listProd;
	}

	public List<SelectItem> getListMag() {
		return listMag;
	}
	public String getNomChoix() {
		return nomChoix;
	}
	
	public boolean isAffSect() {
		return affSect;
	}

	//Setters
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public void setNomMag(String nomMag) {
		this.nomMag = nomMag;
	}

	public void setListProd(List<SelectItem> listProd) {
		this.listProd = listProd;
	}

	public void setListMag(List<SelectItem> listMag) {
		this.listMag = listMag;
	}	
	
	public void setNomChoix(String nomChoix) {
		this.nomChoix = nomChoix;
	}
	
	public void setAffSect(boolean affSect) {
		this.affSect = affSect;
	}
	
	//Ajouter un magasin
	public void ajouterChoix(ActionEvent action) {
		if ((nomProd != null) && (nomMag != null) && (nomChoix != null)) {
			if ("".equalsIgnoreCase(nomProd)) {
				FacesContext.getCurrentInstance().addMessage("nomProd", new FacesMessage("Champs obligatoire"));
			} else if ("".equalsIgnoreCase(nomMag)) {
				FacesContext.getCurrentInstance().addMessage("nomMag", new FacesMessage("Champs obligatoire"));
			} else if ("".equalsIgnoreCase(nomChoix)) {
				FacesContext.getCurrentInstance().addMessage("nomChoix", new FacesMessage("Champs obligatoire"));
			} else  {
				Choix c = new Choix();
				System.out.println(Integer.valueOf(nomProd));
				System.out.println(Integer.valueOf(nomProd).getClass());
				System.out.println(Integer.valueOf(nomMag));
				System.out.println(Integer.valueOf(nomMag).getClass());
				System.out.println(nomChoix);
				System.out.println(nomChoix.getClass());
				c.setIdProd(Integer.valueOf(nomProd));
				c.setIdMag(Integer.valueOf(nomMag));
				c.setNomChoix(nomChoix);
				choix.creer(c);
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("formAjouterChoix", new FacesMessage("Champs obligatoire"));;
		}
	}
}