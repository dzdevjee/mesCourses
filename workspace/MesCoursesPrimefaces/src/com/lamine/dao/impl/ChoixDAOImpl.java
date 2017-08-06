package com.lamine.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.lamine.dao.interfaces.ChoixDAO;
import com.lamine.dao.entite.Choix;
import com.lamine.util.HibernateUtil;

public class ChoixDAOImpl implements ChoixDAO {
	private Session session = HibernateUtil.openSession();

	@Override
	public Integer creer(Choix choix) {
		session.beginTransaction();
		Integer chx = (Integer)session.save(choix);
		session.getTransaction().commit();
		
		return chx;
	}

	@Override
	public Choix modifier(Choix choix) {
		session.beginTransaction();
		Choix chx = (Choix)session.save(choix);
		session.getTransaction().commit();
		
		return chx;
	}

	@Override
	public void supprimer(Integer idChoix) {
		session.beginTransaction();
		Choix chx = afficher(idChoix);
		session.delete(chx);
		session.getTransaction().commit();
	}

	@Override
	public Choix afficher(Integer idChoix) {
		return (Choix)session.get(Choix.class, idChoix);
	}

	@Override
	public List<Choix> toutAfficher() {
		return session.createQuery("select o from Choix o").list();
	}
}