package com.lamine.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.lamine.dao.interfaces.MagasinDAO;
import com.lamine.dao.entite.Magasin;
import com.lamine.util.HibernateUtil;

public class MagasinDAOImpl implements MagasinDAO {
	private Session session = HibernateUtil.openSession();
	
	@Override
	public Integer creer(Magasin magasin) {
		session.beginTransaction();
		Integer mag = (Integer)session.save(magasin);
		session.getTransaction().commit();
		
		return mag;
	}

	@Override
	public Magasin modifier(Magasin magasin) {
		session.beginTransaction();
		Magasin mag = (Magasin)session.merge(magasin);
		session.getTransaction().commit();
		
		return mag;
	}

	@Override
	public void supprimer(Integer idMag) {
		session.beginTransaction();
		Magasin mag = afficher(idMag);
		session.delete(mag);
		session.getTransaction().commit();
	}

	@Override
	public Magasin afficher(Integer idMag) {
		return (Magasin)session.get(Magasin.class, idMag);
	}

	@Override
	public List<Magasin> toutAfficher() {
		return session.createQuery("select o from Magasin o").list();
	}
}