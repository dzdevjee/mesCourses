package com.lamine.mesCourses.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lamine.mesCourses.dao.interfaces.ITypeProduitDAO;
import com.lamine.mesCourses.entite.TypeProduit;

public class TypeProduitDAOImpl implements ITypeProduitDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer creer(TypeProduit typeProduit) {
		em.persist(typeProduit);
		return typeProduit.getIdTypeProd();
	}

	@Override
	public TypeProduit modifier(TypeProduit typeProduit) {
		em.merge(typeProduit);
		return typeProduit;
	}

	@Override
	public void supprimer(Integer idTypeProduit) {
		TypeProduit tp = afficher(idTypeProduit);
		em.remove(tp);
	}

	@Override
	public TypeProduit afficher(Integer idTypeProduit) {
		return em.find(TypeProduit.class, idTypeProduit);
	}

	@Override
	public List<TypeProduit> toutAfficher() {
		return em.createQuery("select o from TypeProduit o").getResultList();
	}
}