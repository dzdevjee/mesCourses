package com.lamine.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.lamine.dao.interfaces.CategorieDAO;
import com.lamine.dao.entite.Categorie;
import com.lamine.util.HibernateUtil;

public class CategorieDAOImpl implements CategorieDAO {
	private Session session = HibernateUtil.openSession();
	
	@Override
	public Integer creer(Categorie categorie) {
		session.beginTransaction();
		Integer cat = (Integer)session.save(categorie);
		session.getTransaction().commit();
		
		return cat;
	}

	@Override
	public Categorie modifier(Categorie categorie) {
		session.beginTransaction();
		Categorie cat = (Categorie)session.merge(categorie);
		session.getTransaction().commit();
		
		return cat;
	}

	@Override
	public void supprimer(Integer idCat) {
		session.beginTransaction();
		Categorie cat = afficher(idCat);
		session.delete(cat);
		session.getTransaction().commit();
	}

	@Override
	public Categorie afficher(Integer idCat) {
		return (Categorie)session.get(Categorie.class, idCat);
	}

	@Override
	public List<Categorie> toutAfficher() {
		return session.createQuery("select o from Categorie o order by o.nomCat asc").list();
		
	}
}