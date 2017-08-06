package com.lamine.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.lamine.dao.interfaces.EnseigneDAO;
import com.lamine.dao.entite.Enseigne;
import com.lamine.util.HibernateUtil;

public class EnseigneDAOImpl implements EnseigneDAO {
	private Session session = HibernateUtil.openSession();
	
	@Override
	public Integer creer(Enseigne enseigne) {
		session.beginTransaction();
		Integer ens = (Integer)session.save(enseigne);
		session.getTransaction().commit();
		
		return ens;
	}

	@Override
	public Enseigne modifier(Enseigne enseigne) {
		session.beginTransaction();
		Enseigne ens = (Enseigne)session.merge(enseigne);
		session.getTransaction().commit();
		
		return ens;
	}

	@Override
	public void supprimer(Integer idEns) {
		session.beginTransaction();
		Enseigne ens = afficher(idEns);
		session.delete(ens);
		session.getTransaction().commit();
	}

	@Override
	public Enseigne afficher(Integer idEns) {
		return (Enseigne)session.get(Enseigne.class, idEns);
	}

	@Override
	public List<Enseigne> toutAfficher() {
		return session.createQuery("select o from Enseigne o ORDER BY o.nomEns asc").list();
	}
}