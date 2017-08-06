package com.lamine.mesCourses.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lamine.mesCourses.dao.interfaces.INatureDAO;
import com.lamine.mesCourses.entite.Nature;

public class NatureDAOImpl implements INatureDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer creer(Nature nature) {
		em.persist(nature);
		return nature.getIdNat();
	}

	@Override
	public Nature modifier(Nature nature) {
		em.merge(nature);
		return nature;
	}

	@Override
	public void supprimer(Integer idNat) {
		Nature n = afficher(idNat);
		em.remove(n);
	}

	@Override
	public Nature afficher(Integer idNat) {
		return em.find(Nature.class, idNat);
	}

	@Override
	public List<Nature> toutAfficher() {
		return em.createQuery("select o from Nature o").getResultList();
	}
}