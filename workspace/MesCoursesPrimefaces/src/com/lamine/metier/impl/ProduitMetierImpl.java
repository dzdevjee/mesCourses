package com.lamine.metier.impl;

import java.util.List;
import com.lamine.dao.interfaces.ProduitDAO;
import com.lamine.metier.interfaces.ProduitMetier;
import com.lamine.dao.entite.Produit;
import com.lamine.dao.impl.ProduitDAOImpl;

public class ProduitMetierImpl implements ProduitMetier {
	private ProduitDAO produitDao = new ProduitDAOImpl();
	
	@Override
	public Integer creer(Produit produit) {
		return produitDao.creer(produit);
	}

	@Override
	public Produit modifier(Produit produit) {
		return produitDao.modifier(produit);
	}

	@Override
	public void supprimer(Integer idProd) {
		produitDao.supprimer(idProd);
	}

	@Override
	public Produit afficher(Integer idProd) {
		return produitDao.afficher(idProd);
	}

	@Override
	public List<Produit> toutAfficher() {
		return produitDao.toutAfficher();
	}
}