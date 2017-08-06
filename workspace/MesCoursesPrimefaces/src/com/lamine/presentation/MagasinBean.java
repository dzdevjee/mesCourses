package com.lamine.presentation;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;

import com.lamine.dao.entite.Enseigne;
import com.lamine.dao.entite.Magasin;
import com.lamine.dao.entite.TypeMagasin;
import com.lamine.metier.impl.EnseigneMetierImpl;
import com.lamine.metier.impl.MagasinMetierImpl;
import com.lamine.metier.impl.TypeMagasinMetierImpl;
import com.lamine.metier.interfaces.EnseigneMetier;
import com.lamine.metier.interfaces.MagasinMetier;
import com.lamine.metier.interfaces.TypeMagasinMetier;

@ManagedBean(name="magasinBean")
@RequestScoped
public class MagasinBean {
	//Objets
	private MagasinMetier magasin;
	private Magasin magSelect;
	private EnseigneMetier enseigne;
	private TypeMagasinMetier typeMagasin;
	//Attributs
	private String adrMag;
	private String horMag;
	private String ens;
	private String typeMag;
	//Liste
	private List<Magasin> listMagasins;
	private List<SelectItem> listEns;
	private List<SelectItem> listTypesMag;
	//valeurs modifiees
	private static Object ancienneValeur;
	private static Object nouvelleValeur;

	//Constructeur
	public MagasinBean() {
	}

	@PostConstruct
	public void initBean() {
		//Injection des dependances inversées
		magasin = new MagasinMetierImpl();
		enseigne = new EnseigneMetierImpl();
		typeMagasin = new TypeMagasinMetierImpl();

		//Afficher la liste des magasins
		listMagasins = new ArrayList<>();
		listMagasins = magasin.toutAfficher();
		
		//Afficher la liste des enseignes
		List<Enseigne> listeEN = enseigne.toutAfficher();
		listEns = new ArrayList<>();
		for (Enseigne en:listeEN) {
			listEns.add(new SelectItem(en.getIdEns(), en.getNomEns()));
		}
		
		//Afficher la liste des types des magasins
		List<TypeMagasin> listeTM = typeMagasin.toutAfficher();
		listTypesMag = new ArrayList<>();
		for (TypeMagasin tm:listeTM) {
			listTypesMag.add(new SelectItem(tm.getIdTypeMag(), tm.getNomTypeMag()));
		}
	}

	//Getters
	public MagasinMetier getMagasin() {
		return magasin;
	}

	public Magasin getMagSelect() {
		return magSelect;
	}

	public EnseigneMetier getEnseigne() {
		return enseigne;
	}
	public TypeMagasinMetier getTypeMagasin() {
		return typeMagasin;
	}

	public String getAdrMag() {
		return adrMag;
	}

	public String getHorMag() {
		return horMag;
	}

	public String getEns() {
		return ens;
	}
	
	public String getTypeMag() {
		return typeMag;
	}

	public List<Magasin> getListMagasins() {
		return listMagasins;
	}
	
	public List<SelectItem> getListEns() {
		return listEns;
	}
	
	public List<SelectItem> getListTypesMag() {
		return listTypesMag;
	}

	public static Object getAncienneValeur() {
		return ancienneValeur;
	}

	public static Object getNouvelleValeur() {
		return nouvelleValeur;
	}

	//Setters
	public void setMagasin(MagasinMetier magasin) {
		this.magasin = magasin;
	}

	public void setMagSelect(Magasin magSelect) {
		this.magSelect = magSelect;
	}

	public void setEnseigne(EnseigneMetier enseigne) {
		this.enseigne = enseigne;
	}

	public void setTypeMagasin(TypeMagasinMetier typeMagasin) {
		this.typeMagasin = typeMagasin;
	}

	public void setAdrMag(String adrMag) {
		this.adrMag = adrMag;
	}

	public void setHorMag(String horMag) {
		this.horMag = horMag;
	}

	public void setEns(String ens) {
		this.ens = ens;
	}

	public void setTypeMag(String typeMag) {
		this.typeMag = typeMag;
	}

	public void setListMagasins(List<Magasin> listMagasins) {
		this.listMagasins = listMagasins;
	}

	public void setListEns(List<SelectItem> listEns) {
		this.listEns = listEns;
	}
	
	public void setListTypesMag(List<SelectItem> listTypesMag) {
		this.listTypesMag = listTypesMag;
	}
	
	public static void setAncienneValeur(Object ancienneValeur) {
		MagasinBean.ancienneValeur = ancienneValeur;
	}

	public static void setNouvelleValeur(Object nouvelleValeur) {
		MagasinBean.nouvelleValeur = nouvelleValeur;
	}
	
	//Ajouter un magasin
	public void ajouterMagasin(ActionEvent action) {
		if ((adrMag != null) && (horMag != null) && (ens != null) && (typeMag != null)) {
			if (("".equalsIgnoreCase(adrMag)) || ("".equalsIgnoreCase(horMag)) || ("".equalsIgnoreCase(ens)) || ("".equalsIgnoreCase(typeMag))) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else  {
				try {
					Magasin m = new Magasin();
					m.setAdrMag(adrMag);
					m.setHorMag(horMag);
					m.setIdEns(Integer.valueOf(ens));
					m.setIdTypeMag(Integer.valueOf(typeMag));
					magasin.creer(m);
					listMagasins = magasin.toutAfficher();
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
	
	//Modifier un magasin
	public void modifierMagasin(ActionEvent action) {
		if (magSelect != null) {
			if (("".equalsIgnoreCase(magSelect.getAdrMag())) || ("".equalsIgnoreCase(magSelect.getHorMag()))) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					if (nouvelleValeur != null) {
						adrMag = ((Magasin)nouvelleValeur).getAdrMag();
						horMag = ((Magasin)nouvelleValeur).getHorMag();
						Integer idEns = Integer.valueOf(((Magasin)nouvelleValeur).getEnseigne().getNomEns());
						Integer idTypeMag = Integer.valueOf(((Magasin)nouvelleValeur).getTypeMagasin().getNomTypeMag());
						magSelect.setAdrMag(adrMag);
						magSelect.setHorMag(horMag);
						magSelect.setIdEns(idEns);
						magSelect.setIdTypeMag(idTypeMag);
						magasin.modifier(magSelect);
						listMagasins = magasin.toutAfficher();
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Operation reussie!"));
					}
				} catch (Exception e) {
					e.printStackTrace();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", e.getMessage()));
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur fatale!", "Echec de l'operation"));
		}
	}
	
    public void onRowEdit(RowEditEvent event) {
        nouvelleValeur = event.getObject();
    }
     
    public void onRowCancel(RowEditEvent event) {
    	ancienneValeur = event.getObject();
    }

	//Supprimer un magasin
	public void supprimerMagasin(ActionEvent action) {
		if (magSelect != null) {
			try {
				magasin.supprimer(magSelect.getIdMag());
				listMagasins = magasin.toutAfficher();
				
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