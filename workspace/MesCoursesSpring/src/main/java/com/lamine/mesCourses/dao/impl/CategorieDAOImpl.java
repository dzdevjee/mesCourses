package com.lamine.mesCourses.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lamine.mesCourses.dao.interfaces.ICategorieDAO;
import com.lamine.mesCourses.entite.Categorie;

public class CategorieDAOImpl implements ICategorieDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer creer(Categorie categorie) {
		em.persist(categorie);
		return categorie.getIdCat();
	}

	@Override
	public Categorie modifier(Categorie categorie) {
		em.merge(categorie);
		return categorie;
	}

	@Override
	public void supprimer(Integer idCat) {
		Categorie c = afficher(idCat);
		em.remove(c);
	}

	@Override
	public Categorie afficher(Integer idCat) {
		return em.find(Categorie.class, idCat);
	}

	@Override
	public List<Categorie> toutAfficher() {
		return em.createQuery("select o from Categorie o").getResultList();
	}
}