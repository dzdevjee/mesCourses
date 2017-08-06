package com.lamine.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.lamine.dao.interfaces.NatureDAO;
import com.lamine.dao.entite.Nature;
import com.lamine.util.HibernateUtil;

public class NatureDAOImpl implements NatureDAO {
	private Session session = HibernateUtil.openSession();
	
	@Override
	public Integer creer(Nature nature) {
		session.beginTransaction();
		Integer nat = (Integer)session.save(nature);
		session.getTransaction().commit();
		
		return nat;
	}

	@Override
	public Nature modifier(Nature nature) {
		session.beginTransaction();
		Nature nat = (Nature)session.merge(nature);
		session.getTransaction().commit();
		
		return nat;
	}

	@Override
	public void supprimer(Integer idNat) {
		session.beginTransaction();
		Nature nat = afficher(idNat);
		session.delete(nat);
		session.getTransaction().commit();
	}

	@Override
	public Nature afficher(Integer idNat) {
		return (Nature)session.get(Nature.class, idNat);
	}

	@Override
	public List<Nature> toutAfficher() {
		return session.createQuery("select o from Nature o").list();
	}
}