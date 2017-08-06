package com.lamine.mesCourses.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lamine.mesCourses.dao.interfaces.IUtilisationDAO;
import com.lamine.mesCourses.entite.Utilisation;

public class UtilisationDAOImpl implements IUtilisationDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer creer(Utilisation utilisation) {
		em.persist(utilisation);
		return utilisation.getIdUse();
	}

	@Override
	public Utilisation modifier(Utilisation utilisation) {
		em.merge(utilisation);
		return utilisation;
	}

	@Override
	public void supprimer(Integer idUse) {
		Utilisation u = afficher(idUse);
		em.remove(u);
	}

	@Override
	public Utilisation afficher(Integer idUse) {
		return em.find(Utilisation.class, idUse);
	}

	@Override
	public List<Utilisation> toutAfficher() {
		return em.createQuery("select o from Utilisation o").getResultList();
	}
}