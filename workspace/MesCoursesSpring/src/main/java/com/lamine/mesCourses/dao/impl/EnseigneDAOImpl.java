package com.lamine.mesCourses.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lamine.mesCourses.dao.interfaces.IEnseigneDAO;
import com.lamine.mesCourses.entite.Enseigne;

public class EnseigneDAOImpl implements IEnseigneDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer creer(Enseigne enseigne) {
		em.persist(enseigne);
		return enseigne.getIdEns();
	}

	@Override
	public Enseigne modifier(Enseigne enseigne) {
		em.merge(enseigne);
		return enseigne;
	}

	@Override
	public void supprimer(Integer idEns) {
		Enseigne e = afficher(idEns);
		em.remove(e);
	}

	@Override
	public Enseigne afficher(Integer idEns) {
		return em.find(Enseigne.class, idEns);
	}

	@Override
	public List<Enseigne> toutAfficher() {
		return em.createQuery("select e from Enseigne e").getResultList();
	}	
}