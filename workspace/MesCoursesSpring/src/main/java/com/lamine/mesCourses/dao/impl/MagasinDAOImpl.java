package com.lamine.mesCourses.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lamine.mesCourses.dao.interfaces.IMagasinDAO;
import com.lamine.mesCourses.entite.Magasin;

public class MagasinDAOImpl implements IMagasinDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer creer(Magasin magasin) {
		em.persist(magasin);
		return magasin.getIdMag();
	}

	@Override
	public Magasin modifier(Magasin magasin) {
		em.merge(magasin);
		return magasin;
	}

	@Override
	public void supprimer(Integer idMag) {
		Magasin mag = afficher(idMag);
		em.remove(mag);
	}

	@Override
	public Magasin afficher(Integer idMag) {
		return em.find(Magasin.class, idMag);
	}

	@Override
	public List<Magasin> toutAfficher() {
		return em.createQuery("select o from Magasin o").getResultList();
	}	
}