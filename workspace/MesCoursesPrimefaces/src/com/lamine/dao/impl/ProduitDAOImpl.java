package com.lamine.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.lamine.dao.interfaces.ProduitDAO;
import com.lamine.dao.entite.Produit;
import com.lamine.util.HibernateUtil;

public class ProduitDAOImpl implements ProduitDAO {
	private Session session = HibernateUtil.openSession();
	
	@Override
	public Integer creer(Produit produit) {
		session.beginTransaction();
		Integer prod = (Integer)session.save(produit);
		session.getTransaction().commit();
		
		return prod;
	}

	@Override
	public Produit modifier(Produit produit) {
		session.beginTransaction();
		Produit prod = (Produit)session.merge(produit);
		session.getTransaction().commit();
		
		return prod;
	}

	@Override
	public void supprimer(Integer idProd) {
		session.beginTransaction();
		Produit prod = afficher(idProd);
		session.delete(prod);
		session.getTransaction().commit();
	}

	@Override
	public Produit afficher(Integer idProd) {
		return (Produit)session.get(Produit.class, idProd);
	}

	@Override
	public List<Produit> toutAfficher() {
		return session.createQuery("select o from Produit o").list();
	}
}