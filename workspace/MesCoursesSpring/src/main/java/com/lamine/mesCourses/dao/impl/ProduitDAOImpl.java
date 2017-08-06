package com.lamine.mesCourses.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lamine.mesCourses.dao.interfaces.IProduitDAO;
import com.lamine.mesCourses.entite.Produit;

public class ProduitDAOImpl implements IProduitDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Integer creer(Produit produit) {
		em.persist(produit);
		return produit.getIdProd();
	}

	@Override
	public Produit modifier(Produit produit) {
		em.merge(produit);
		return produit;
	}

	@Override
	public void supprimer(Integer idProd) {
		Produit prod = afficher(idProd);
		em.remove(prod);
	}

	@Override
	public Produit afficher(Integer idProd) {
		return em.find(Produit.class, idProd);
	}

	@Override
	public List<Produit> toutAfficher() {
		return em.createQuery("select o from Produit o").getResultList();
	}
}