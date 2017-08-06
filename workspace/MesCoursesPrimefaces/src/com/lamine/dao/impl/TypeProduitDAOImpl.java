package com.lamine.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.lamine.dao.interfaces.TypeProduitDAO;
import com.lamine.dao.entite.TypeProduit;
import com.lamine.util.HibernateUtil;

public class TypeProduitDAOImpl implements TypeProduitDAO {
	private Session session = HibernateUtil.openSession();
	
	@Override
	public Integer creer(TypeProduit typeProduit) {
		session.beginTransaction();
		Integer typeProd = (Integer)session.save(typeProduit);
		session.getTransaction().commit();
		
		return typeProd;
	}

	@Override
	public TypeProduit modifier(TypeProduit typeProduit) {
		session.beginTransaction();
		TypeProduit typeProd = (TypeProduit)session.merge(typeProduit);
		session.getTransaction().commit();
		
		return typeProd;
	}

	@Override
	public void supprimer(Integer idTypeProduit) {
		session.beginTransaction();
		TypeProduit typeProd = afficher(idTypeProduit);
		session.delete(typeProd);
		session.getTransaction().commit();
	}

	@Override
	public TypeProduit afficher(Integer idTypeProduit) {
		return (TypeProduit)session.get(TypeProduit.class, idTypeProduit);
	}

	@Override
	public List<TypeProduit> toutAfficher() {
		return session.createQuery("select o from TypeProduit o").list();
	}
}