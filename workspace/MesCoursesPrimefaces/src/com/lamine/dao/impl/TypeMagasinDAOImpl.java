package com.lamine.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.lamine.dao.entite.TypeMagasin;
import com.lamine.util.HibernateUtil;
import com.lamine.dao.interfaces.TypeMagasinDAO;

public class TypeMagasinDAOImpl implements TypeMagasinDAO {
	private Session session = HibernateUtil.openSession();		
	
	@Override
	public Integer creer(TypeMagasin typeMagasin) {
		session.beginTransaction();
		Integer tm = (Integer)session.save(typeMagasin);
		session.getTransaction().commit();
		
		return tm;
	}

	@Override
	public TypeMagasin modifier(TypeMagasin typeMagasin) {
		session.beginTransaction();
		TypeMagasin tm = (TypeMagasin)session.merge(typeMagasin);
		session.getTransaction().commit();
		
		return tm;
	}

	@Override
	public void supprimer(Integer idTypeMagasin) {
		session.beginTransaction();
		TypeMagasin tm = afficher(idTypeMagasin);
		session.delete(tm);
		session.getTransaction().commit();
	}
	
	@Override
	public TypeMagasin afficher(Integer idTypeMagasin) {
		return (TypeMagasin)session.get(TypeMagasin.class, idTypeMagasin);
	}
	
	@Override
	public List<TypeMagasin> toutAfficher() {
		return session.createQuery("select o from TypeMagasin o").list();
	}
}