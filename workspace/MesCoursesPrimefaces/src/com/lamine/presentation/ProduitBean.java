package com.lamine.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;
import com.lamine.dao.entite.Categorie;
import com.lamine.dao.entite.Enseigne;
import com.lamine.dao.entite.Marque;
import com.lamine.dao.entite.Nature;
import com.lamine.dao.entite.Produit;
import com.lamine.dao.entite.TypeProduit;
import com.lamine.dao.entite.Utilisation;
import com.lamine.metier.impl.CategorieMetierImpl;
import com.lamine.metier.impl.EnseigneMetierImpl;
import com.lamine.metier.impl.MarqueMetierImpl;
import com.lamine.metier.impl.NatureMetierImpl;
import com.lamine.metier.impl.ProduitMetierImpl;
import com.lamine.metier.impl.TypeProduitMetierImpl;
import com.lamine.metier.impl.UtilisationMetierImpl;
import com.lamine.metier.interfaces.CategorieMetier;
import com.lamine.metier.interfaces.EnseigneMetier;
import com.lamine.metier.interfaces.MarqueMetier;
import com.lamine.metier.interfaces.NatureMetier;
import com.lamine.metier.interfaces.ProduitMetier;
import com.lamine.metier.interfaces.TypeProduitMetier;
import com.lamine.metier.interfaces.UtilisationMetier;

@ManagedBean(name="produitBean")
@RequestScoped
public class ProduitBean {
	//Objets
	private ProduitMetier produit;
	private Produit prodSelect;
	private MarqueMetier marque;
	private TypeProduitMetier typeProduit;
	private NatureMetier nature;
	private CategorieMetier categorie;
	private UtilisationMetier utilisation;
	private EnseigneMetier enseigne;
	//Attributs
	private String nomProd;
	private String qteProd;
	private String qteNetProd;
	private String uniteMesure;
	private String prixProd;
	private String qteStk;
	private String comProd;
	private String marq;
	private String typeProd;
	private String nat;
	private String cat;
	private String use;
	private String ens;	
	//Listes
	private List<Produit> listProduits;
	private List<SelectItem> listTypesProd;
	private List<SelectItem> listMarq;
	private List<SelectItem> listNat;
	private List<SelectItem> listCat;
	private List<SelectItem> listUse;
	private List<SelectItem> listEns;
	//valeurs modifiees
	private static Object ancienneValeur;
	private static Object nouvelleValeur;
		
	//Constructeur
	public ProduitBean() {
	}
	
	@PostConstruct
	public void initBean() {
		//Injection des dependances inversées
		produit = new ProduitMetierImpl();
		typeProduit = new TypeProduitMetierImpl();
		marque = new MarqueMetierImpl();
		nature = new NatureMetierImpl();
		categorie = new CategorieMetierImpl();
		utilisation = new UtilisationMetierImpl();
		enseigne = new EnseigneMetierImpl();
		
		//Afficher la liste des produits
		listProduits = new ArrayList<>();
		listProduits = produit.toutAfficher();
		
		//Afficher les listes
		List<TypeProduit> listeTP = typeProduit.toutAfficher();
		listTypesProd = new ArrayList<>();
		for (TypeProduit tp:listeTP) {
			listTypesProd.add(new SelectItem(tp.getIdTypeProd(), tp.getNomTypeProd()));
		}
		
		List<Marque> listeMQ = marque.toutAfficher();
		listMarq = new ArrayList<>();
		for (Marque mq:listeMQ) {
			listMarq.add(new SelectItem(mq.getIdMarq(), mq.getNomMarq()));
		}


		List<Nature> listeNT = nature.toutAfficher();
		listNat = new ArrayList<>();
		for (Nature nt:listeNT) {
			listNat.add(new SelectItem(nt.getIdNat(), nt.getNomNat()));
		}
		
		List<Categorie> listeCT = categorie.toutAfficher();
		listCat = new ArrayList<>();
		for (Categorie ct:listeCT) {
			listCat.add(new SelectItem(ct.getIdCat(), ct.getNomCat()));
		}
		
		List<Utilisation> listeUS = utilisation.toutAfficher();
		listUse = new ArrayList<>();
		for (Utilisation us:listeUS) {
			listUse.add(new SelectItem(us.getIdUse(), us.getNomUse()));
		}
		
		List<Enseigne> listeEN = enseigne.toutAfficher();
		listEns = new ArrayList<>();
		for (Enseigne en:listeEN) {
			listEns.add(new SelectItem(en.getIdEns(), en.getNomEns()));
		}
	}

	//Getters
	public ProduitMetier getProduit() {
		return produit;
	}

	public Produit getProdSelect() {
		return prodSelect;
	}

	public MarqueMetier getMarque() {
		return marque;
	}

	public TypeProduitMetier getTypeProduit() {
		return typeProduit;
	}

	public NatureMetier getNature() {
		return nature;
	}

	public CategorieMetier getCategorie() {
		return categorie;
	}

	public UtilisationMetier getUtilisation() {
		return utilisation;
	}

	public EnseigneMetier getEnseigne() {
		return enseigne;
	}

	public String getNomProd() {
		return nomProd;
	}

	public String getQteProd() {
		return qteProd;
	}

	public String getQteNetProd() {
		return qteNetProd;
	}

	public String getUniteMesure() {
		return uniteMesure;
	}

	public String getPrixProd() {
		return prixProd;
	}

	public String getQteStk() {
		return qteStk;
	}

	public String getComProd() {
		return comProd;
	}

	public String getMarq() {
		return marq;
	}

	public String getTypeProd() {
		return typeProd;
	}

	public String getNat() {
		return nat;
	}

	public String getCat() {
		return cat;
	}

	public String getUse() {
		return use;
	}

	public String getEns() {
		return ens;
	}

	public List<Produit> getListProduits() {
		return listProduits;
	}

	public List<SelectItem> getListTypesProd() {
		return listTypesProd;
	}

	public List<SelectItem> getListMarq() {
		return listMarq;
	}

	public List<SelectItem> getListNat() {
		return listNat;
	}

	public List<SelectItem> getListCat() {
		return listCat;
	}

	public List<SelectItem> getListUse() {
		return listUse;
	}

	public List<SelectItem> getListEns() {
		return listEns;
	}

	public static Object getAncienneValeur() {
		return ancienneValeur;
	}

	public static Object getNouvelleValeur() {
		return nouvelleValeur;
	}
	
	//Setters
	public void setProduit(ProduitMetier produit) {
		this.produit = produit;
	}

	public void setProdSelect(Produit prodSelect) {
		this.prodSelect = prodSelect;
	}

	public void setMarque(MarqueMetier marque) {
		this.marque = marque;
	}

	public void setTypeProduit(TypeProduitMetier typeProduit) {
		this.typeProduit = typeProduit;
	}

	public void setNature(NatureMetier nature) {
		this.nature = nature;
	}

	public void setCategorie(CategorieMetier categorie) {
		this.categorie = categorie;
	}

	public void setUtilisation(UtilisationMetier utilisation) {
		this.utilisation = utilisation;
	}

	public void setEnseigne(EnseigneMetier enseigne) {
		this.enseigne = enseigne;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public void setQteProd(String qteProd) {
		this.qteProd = qteProd;
	}

	public void setQteNetProd(String qteNetProd) {
		this.qteNetProd = qteNetProd;
	}

	public void setUniteMesure(String uniteMesure) {
		this.uniteMesure = uniteMesure;
	}

	public void setPrixProd(String prixProd) {
		this.prixProd = prixProd;
	}

	public void setQteStk(String qteStk) {
		this.qteStk = qteStk;
	}

	public void setComProd(String comProd) {
		this.comProd = comProd;
	}

	public void setMarq(String marq) {
		this.marq = marq;
	}

	public void setTypeProd(String typeProd) {
		this.typeProd = typeProd;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public void setEns(String ens) {
		this.ens = ens;
	}

	public void setListProduits(List<Produit> listProduits) {
		this.listProduits = listProduits;
	}

	public void setListTypesProd(List<SelectItem> listTypesProd) {
		this.listTypesProd = listTypesProd;
	}

	public void setListMarq(List<SelectItem> listMarq) {
		this.listMarq = listMarq;
	}

	public void setListNat(List<SelectItem> listNat) {
		this.listNat = listNat;
	}

	public void setListCat(List<SelectItem> listCat) {
		this.listCat = listCat;
	}

	public void setListUse(List<SelectItem> listUse) {
		this.listUse = listUse;
	}

	public void setListEns(List<SelectItem> listEns) {
		this.listEns = listEns;
	}

	public static void setAncienneValeur(Object ancienneValeur) {
		ProduitBean.ancienneValeur = ancienneValeur;
	}

	public static void setNouvelleValeur(Object nouvelleValeur) {
		ProduitBean.nouvelleValeur = nouvelleValeur;
	}
	
	//Ajouter un magasin
	public void ajouterProduit(ActionEvent action) {
		if ((nomProd != null) 	&& (qteProd != null) && (qteNetProd != null)&& (uniteMesure != null) && (prixProd != null)&& (qteStk != null) && (comProd != null)
								&& (marq != null) && (typeProd != null)&& (nat != null) && (cat != null)&& (use != null) && (ens != null)) {
			if (("".equalsIgnoreCase(nomProd)) 	&& ("".equalsIgnoreCase(qteProd)) && ("".equalsIgnoreCase(qteNetProd)) && ("".equalsIgnoreCase(uniteMesure))
												&& ("".equalsIgnoreCase(prixProd)) && ("".equalsIgnoreCase(qteStk)) && ("".equalsIgnoreCase(comProd))
												&& ("".equalsIgnoreCase(marq)) && ("".equalsIgnoreCase(typeProd)) && ("".equalsIgnoreCase(nat)) && ("".equalsIgnoreCase(cat))
												&& ("".equalsIgnoreCase(use)) && ("".equalsIgnoreCase(ens))) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Champs obligatoire!!"));
			} else {
				try {
					Produit p = new Produit();
					p.setNomProd(nomProd);
					p.setQteProd(Integer.valueOf(qteProd));
					p.setQteNetProd(Integer.valueOf(qteNetProd));
					p.setUniteMesure(uniteMesure);
					p.setPrixProd(Double.valueOf(prixProd));
					p.setQteStk(Integer.valueOf(qteStk));
					p.setComProd(comProd);
					p.setIdMarq(Integer.valueOf(marq));
					p.setIdTypeProd(Integer.valueOf(typeProd));
					p.setIdNat(Integer.valueOf(nat));
					p.setIdCat(Integer.valueOf(cat));
					p.setIdUse(Integer.valueOf(use));
					p.setIdEns(Integer.valueOf(ens));
					produit.creer(p);
					listProduits = produit.toutAfficher();
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
	//Modifier un produit
	public void modifierProduit(ActionEvent action) {
		if (prodSelect != null) {
			try {
				if (nouvelleValeur != null) {
					prodSelect.setNomProd(((Produit)nouvelleValeur).getNomProd());
					prodSelect.setQteProd(((Produit)nouvelleValeur).getQteProd());
					prodSelect.setQteNetProd(((Produit)nouvelleValeur).getQteNetProd());
					prodSelect.setUniteMesure(((Produit)nouvelleValeur).getUniteMesure());
					prodSelect.setPrixProd(((Produit)nouvelleValeur).getPrixProd());
					prodSelect.setQteStk(((Produit)nouvelleValeur).getQteStk());
					prodSelect.setComProd(((Produit)nouvelleValeur).getComProd());
					prodSelect.setIdMarq(Integer.valueOf(((Produit)nouvelleValeur).getMarque().getNomMarq()));
					prodSelect.setIdTypeProd(Integer.valueOf(((Produit)nouvelleValeur).getTypeProduit().getNomTypeProd()));
					prodSelect.setIdNat(Integer.valueOf(((Produit)nouvelleValeur).getNature().getNomNat()));
					prodSelect.setIdCat(Integer.valueOf(((Produit)nouvelleValeur).getCategorie().getNomCat()));
					prodSelect.setIdUse(Integer.valueOf(((Produit)nouvelleValeur).getUtilisation().getNomUse()));
					prodSelect.setIdEns(Integer.valueOf(((Produit)nouvelleValeur).getEnseigne().getNomEns()));
					produit.modifier(prodSelect);
					listProduits = produit.toutAfficher();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Operation reussie!"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", e.getMessage()));
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

	//Supprimer un produit
	public void supprimerProduit(ActionEvent action) {
		if (prodSelect != null) {
			try {
				produit.supprimer(prodSelect.getIdProd());
				listProduits = produit.toutAfficher();
				
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