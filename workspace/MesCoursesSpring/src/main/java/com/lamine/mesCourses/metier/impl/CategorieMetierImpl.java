package com.lamine.mesCourses.metier.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.lamine.mesCourses.dao.interfaces.ICategorieDAO;
import com.lamine.mesCourses.metier.interfaces.ICategorieMetier;
import com.lamine.mesCourses.entite.Categorie;

@Transactional
public class CategorieMetierImpl implements ICategorieMetier {
	private ICategorieDAO categorieDao;

	public void setCategorieDao (ICategorieDAO categorieDao) {
		this.categorieDao = categorieDao;
	}

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