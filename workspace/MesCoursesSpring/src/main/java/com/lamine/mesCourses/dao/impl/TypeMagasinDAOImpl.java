package com.lamine.mesCourses.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lamine.mesCourses.dao.interfaces.ITypeMagasinDAO;
import com.lamine.mesCourses.entite.TypeMagasin;

public class TypeMagasinDAOImpl implements ITypeMagasinDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer creer(TypeMagasin typeMagasin) {
		em.persist(typeMagasin);
		return typeMagasin.getIdTypeMag();
	}

	@Override
	public TypeMagasin modifier(TypeMagasin typeMagasin) {
		em.merge(typeMagasin);
		return typeMagasin;
	}

	@Override
	public void supprimer(Integer idTypeMagasin) {
		TypeMagasin tm = afficher(idTypeMagasin);
		em.remove(tm);
	}

	@Override
	public TypeMagasin afficher(Integer idTypeMagasin) {
		return em.find(TypeMagasin.class, idTypeMagasin);
	}

	@Override
	public List<TypeMagasin> toutAfficher() {
		return em.createQuery("select o from TypeMagasin o").getResultList();
	}
}