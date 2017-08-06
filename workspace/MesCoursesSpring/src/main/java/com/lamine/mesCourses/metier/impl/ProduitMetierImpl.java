package com.lamine.mesCourses.metier.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.lamine.mesCourses.dao.interfaces.IProduitDAO;
import com.lamine.mesCourses.metier.interfaces.IProduitMetier;
import com.lamine.mesCourses.entite.Produit;

@Transactional
public class ProduitMetierImpl implements IProduitMetier {
	private IProduitDAO produitDao;

	public void setProduitDao (IProduitDAO produitDao) {
		this.produitDao = produitDao;
	}

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