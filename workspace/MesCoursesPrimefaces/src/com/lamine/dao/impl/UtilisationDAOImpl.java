package com.lamine.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.lamine.dao.interfaces.UtilisationDAO;
import com.lamine.dao.entite.Utilisation;
import com.lamine.util.HibernateUtil;

public class UtilisationDAOImpl implements UtilisationDAO {
	private Session session = HibernateUtil.openSession();

	@Override
	public Integer creer(Utilisation utilisation) {
		session.beginTransaction();
		Integer use = (Integer)session.save(utilisation);
		session.getTransaction().commit();
		
		return use;
	}

	@Override
	public Utilisation modifier(Utilisation utilisation) {
		session.beginTransaction();
		Utilisation use = (Utilisation)session.merge(utilisation);
		session.getTransaction().commit();
		
		return use;
	}

	@Override
	public void supprimer(Integer idUse) {
		session.beginTransaction();
		Utilisation use = afficher(idUse);
		session.delete(use);
		session.getTransaction().commit();
	}

	@Override
	public Utilisation afficher(Integer idUse) {
		return (Utilisation)session.get(Utilisation.class, idUse);
	}

	@Override
	public List<Utilisation> toutAfficher() {
		return session.createQuery("select o from Utilisation o").list();
	}
}