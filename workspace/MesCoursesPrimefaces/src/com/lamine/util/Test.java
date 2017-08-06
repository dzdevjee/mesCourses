package com.lamine.util;

import org.hibernate.Session;

import com.lamine.dao.entite.Categorie;
import com.lamine.dao.entite.Utilisation;
import com.lamine.dao.impl.CategorieDAOImpl;
import com.lamine.dao.impl.UtilisationDAOImpl;
import com.lamine.dao.interfaces.CategorieDAO;
import com.lamine.dao.interfaces.UtilisationDAO;

public class Test {
	private static Session session = HibernateUtil.openSession();
	
	public static void main(String[] args) {
	
		session.createQuery("select o from Nature o").list();
		session.createQuery("select o from Utilisation o").list();
		session.createQuery("select o from Categorie o").list();
		session.createQuery("select o from Marque o").list();
		session.createQuery("select o from Enseigne o").list();
		session.createQuery("select o from TypeProduit o").list();
		session.createQuery("select o from Produit o").list();
		session.createQuery("select o from Choix o").list();
		session.createQuery("select o from Magasin o").list();
		session.createQuery("select o from TypeMagasin o").list();
		/*
		//Utilisation
			Utilisation ut = new Utilisation();
			
			UtilisationDAO utdao = new UtilisationDAOImpl();
			utdao.afficher(7);
			ut.setNomUse("test2");
			
			utdao.modifier(ut);
			*/	
	/*
		//TypeMagasin
		TypeMagasinDAO tmdao = new TypeMagasinDAOImpl();
		
		TypeMagasin tm = new TypeMagasin();
		tm.setNomTypeMag("Hyper Marche");
		System.out.println(tm.toString());
		tmdao.creer(tm);
		
		//Magasin
		Magasin mag = new Magasin();
		mag.setIdMag(1);
		mag.setNomMag("Hal Market");
		mag.setAdrMag("Maison Alfort");
		
		MagasinDAO mdao = new MagasinDAOImpl();
		mdao.creer(mag);
		
		//Choix
		Choix chx = new Choix();
		chx.setNomChoix("Halal");
		
		ChoixDAO chdao = new ChoixDAOImpl();
		chdao.creer(chx);
		//Produit
		Produit p = new Produit();
		p.setNomProd("Ferrero Rocher");
		p.setQteProd(50);
		p.setQteNetProd(50);
		p.setUniteMesure("g");
		p.setPrixProd(5.0);
		p.setQteStk(2);
		p.setComProd("Promo");
		
		ProduitDAO pdao = new ProduitDAOImpl();
		pdao.creer(p);
		
		//TypeProduit
		TypeProduit tp = new TypeProduit();
		tp.setNomTypeProd("Hyper Marche");
		
		TypeProduitDAO tpdao = new TypeProduitDAOImpl();
		tpdao.creer(tp);
		
		//Marque
		Marque mq = new Marque();
		mq.setNomMarq("Hyper Marche");
		
		MarqueDAO mqdao = new MarqueDAOImpl();
		mqdao.creer(mq);
		
		//Nature
		Nature nt = new Nature();
		nt.setNomNat("Hyper Marche");
		
		NatureDAO ntdao = new NatureDAOImpl();
		ntdao.creer(nt);
		
		//Utilisation
		Utilisation ut = new Utilisation();
		tm.setNomTypeMag("Hyper Marche");
		
		UtilisationDAO utdao = new UtilisationDAOImpl();
		utdao.creer(ut);
		
		//Categorie		
		
		Categorie ct = new Categorie();
		ct.setNomCat("Hyper Marche");
		
		CategorieDAO ctdao = new CategorieDAOImpl();
		ctdao.creer(ct);
	*/
	}
}