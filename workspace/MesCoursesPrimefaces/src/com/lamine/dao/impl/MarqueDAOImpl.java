package com.lamine.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.lamine.dao.interfaces.MarqueDAO;
import com.lamine.dao.entite.Marque;
import com.lamine.util.HibernateUtil;

public class MarqueDAOImpl implements MarqueDAO {
	private Session session = HibernateUtil.openSession();
	
	@Override
	public Integer creer(Marque marque) {
		session.beginTransaction();
		Integer marq = (Integer)session.save(marque);
		session.getTransaction().commit();
		
		return marq;
	}

	@Override
	public Marque modifier(Marque marque) {
		session.beginTransaction();
		Marque marq = (Marque)session.merge(marque);
		session.getTransaction().commit();
		
		return marq;
	}

	@Override
	public void supprimer(Integer idMarq) {
		session.beginTransaction();
		Marque marq = afficher(idMarq);
		session.delete(marq);
		session.getTransaction().commit();		
	}

	@Override
	public Marque afficher(Integer idMarq) {
		return (Marque)session.get(Marque.class, idMarq);
	}

	@Override
	public List<Marque> toutAfficher() {
		return session.createQuery("select o from Marque o").list();
	}
}