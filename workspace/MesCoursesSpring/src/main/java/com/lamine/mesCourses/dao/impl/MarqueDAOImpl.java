package com.lamine.mesCourses.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lamine.mesCourses.dao.interfaces.IMarqueDAO;
import com.lamine.mesCourses.entite.Marque;

public class MarqueDAOImpl implements IMarqueDAO{
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer creer(Marque marque) {
		em.persist(marque);
		return marque.getIdMarq();
	}

	@Override
	public Marque modifier(Marque marque) {
		em.merge(marque);
		return marque;
	}

	@Override
	public void supprimer(Integer idMarq) {
		Marque m = afficher(idMarq);
		em.remove(m);
	}

	@Override
	public Marque afficher(Integer idMarq) {
		return em.find(Marque.class, idMarq);
	}

	@Override
	public List<Marque> toutAfficher() {
		return em.createQuery("select o from Marque o").getResultList();
	}
}