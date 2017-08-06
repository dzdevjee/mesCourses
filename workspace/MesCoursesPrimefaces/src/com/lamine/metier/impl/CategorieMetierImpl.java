package com.lamine.metier.impl;

import java.util.List;
import com.lamine.dao.interfaces.CategorieDAO;
import com.lamine.metier.interfaces.CategorieMetier;
import com.lamine.dao.entite.Categorie;
import com.lamine.dao.impl.CategorieDAOImpl;

public class CategorieMetierImpl implements CategorieMetier {
	private CategorieDAO categorieDao = new CategorieDAOImpl();
	
	@Override
	public Integer creer(Categorie categorie) {
		return categorieDao.creer(categorie);
	}

	@Override
	public Categorie modifier(Categorie categorie) {
		return categorieDao.modifier(categorie);
	}

	@Override
	public void supprimer(Integer idCat) {
		categorieDao.supprimer(idCat);
	}

	@Override
	public Categorie afficher(Integer idCat) {
		return categorieDao.afficher(idCat);
	}

	@Override
	public List<Categorie> toutAfficher() {
		return categorieDao.toutAfficher();
	}
}