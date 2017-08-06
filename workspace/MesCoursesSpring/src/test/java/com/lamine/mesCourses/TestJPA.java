package com.lamine.mesCourses;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lamine.mesCourses.entite.Categorie;
import com.lamine.mesCourses.entite.Enseigne;
import com.lamine.mesCourses.metier.interfaces.ICategorieMetier;
import com.lamine.mesCourses.metier.interfaces.IEnseigneMetier;

public class TestJPA {
	ClassPathXmlApplicationContext app;
	
	@Before
	public void setUp() throws Exception {
		app = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}

	@Test
	public void test1() {
		try {
			ICategorieMetier categorieMetier = (ICategorieMetier) app.getBean("categorieMetier");
			
			List<Categorie> listCategories = categorieMetier.toutAfficher();
			Categorie c = new Categorie();
			c.setNomCat("Nourriture");
			categorieMetier.creer(c);
			c = new Categorie();
			c.setNomCat("Vetements");
			categorieMetier.creer(c);
			
			List<Categorie> listCategories2 = categorieMetier.toutAfficher();
			
			
			
			assertTrue(listCategories.size() + 2 == listCategories2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

	@Test
	public void test2() {
		try {
			IEnseigneMetier enseigneMetier = (IEnseigneMetier) app.getBean("enseigneMetier");
			
			List<Enseigne> listEnseignes = enseigneMetier.toutAfficher();
			Enseigne e = new Enseigne();
			e.setNomEns("Halal distrib");
			enseigneMetier.creer(e);
			e = new Enseigne();
			e.setNomEns("Hal'Market");
			enseigneMetier.creer(e);
			
			List<Enseigne> listEnseignes2 = enseigneMetier.toutAfficher();
			
			
			
			assertTrue(listEnseignes.size() + 2 == listEnseignes2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	/*
	@Test
	public void test3() {
		try {
			IEnseigneMetier enseigneMetier = (IEnseigneMetier) app.getBean("enseigneMetier");
			
			List<Enseigne> listEnseignes = enseigneMetier.toutAfficher();
			Enseigne e = new Enseigne();
			e.setNomEns("Halal distrib");
			enseigneMetier.creer(e);
			e = new Enseigne();
			e.setNomEns("Hal'Market");
			enseigneMetier.creer(e);
			
			List<Enseigne> listEnseignes2 = enseigneMetier.toutAfficher();
			
			
			
			assertTrue(listEnseignes.size() + 2 == listEnseignes2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void test4() {
		try {
			IEnseigneMetier enseigneMetier = (IEnseigneMetier) app.getBean("enseigneMetier");
			
			List<Enseigne> listEnseignes = enseigneMetier.toutAfficher();
			Enseigne e = new Enseigne();
			e.setNomEns("Halal distrib");
			enseigneMetier.creer(e);
			e = new Enseigne();
			e.setNomEns("Hal'Market");
			enseigneMetier.creer(e);
			
			List<Enseigne> listEnseignes2 = enseigneMetier.toutAfficher();
			
			
			
			assertTrue(listEnseignes.size() + 2 == listEnseignes2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void test5() {
		try {
			IEnseigneMetier enseigneMetier = (IEnseigneMetier) app.getBean("enseigneMetier");
			
			List<Enseigne> listEnseignes = enseigneMetier.toutAfficher();
			Enseigne e = new Enseigne();
			e.setNomEns("Halal distrib");
			enseigneMetier.creer(e);
			e = new Enseigne();
			e.setNomEns("Hal'Market");
			enseigneMetier.creer(e);
			
			List<Enseigne> listEnseignes2 = enseigneMetier.toutAfficher();
			
			
			
			assertTrue(listEnseignes.size() + 2 == listEnseignes2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void test6() {
		try {
			IEnseigneMetier enseigneMetier = (IEnseigneMetier) app.getBean("enseigneMetier");
			
			List<Enseigne> listEnseignes = enseigneMetier.toutAfficher();
			Enseigne e = new Enseigne();
			e.setNomEns("Halal distrib");
			enseigneMetier.creer(e);
			e = new Enseigne();
			e.setNomEns("Hal'Market");
			enseigneMetier.creer(e);
			
			List<Enseigne> listEnseignes2 = enseigneMetier.toutAfficher();
			
			
			
			assertTrue(listEnseignes.size() + 2 == listEnseignes2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void test7() {
		try {
			IEnseigneMetier enseigneMetier = (IEnseigneMetier) app.getBean("enseigneMetier");
			
			List<Enseigne> listEnseignes = enseigneMetier.toutAfficher();
			Enseigne e = new Enseigne();
			e.setNomEns("Halal distrib");
			enseigneMetier.creer(e);
			e = new Enseigne();
			e.setNomEns("Hal'Market");
			enseigneMetier.creer(e);
			
			List<Enseigne> listEnseignes2 = enseigneMetier.toutAfficher();
			
			
			
			assertTrue(listEnseignes.size() + 2 == listEnseignes2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void test8() {
		try {
			IEnseigneMetier enseigneMetier = (IEnseigneMetier) app.getBean("enseigneMetier");
			
			List<Enseigne> listEnseignes = enseigneMetier.toutAfficher();
			Enseigne e = new Enseigne();
			e.setNomEns("Halal distrib");
			enseigneMetier.creer(e);
			e = new Enseigne();
			e.setNomEns("Hal'Market");
			enseigneMetier.creer(e);
			
			List<Enseigne> listEnseignes2 = enseigneMetier.toutAfficher();
			
			
			
			assertTrue(listEnseignes.size() + 2 == listEnseignes2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void test9() {
		try {
			IEnseigneMetier enseigneMetier = (IEnseigneMetier) app.getBean("enseigneMetier");
			
			List<Enseigne> listEnseignes = enseigneMetier.toutAfficher();
			Enseigne e = new Enseigne();
			e.setNomEns("Halal distrib");
			enseigneMetier.creer(e);
			e = new Enseigne();
			e.setNomEns("Hal'Market");
			enseigneMetier.creer(e);
			
			List<Enseigne> listEnseignes2 = enseigneMetier.toutAfficher();
			
			
			
			assertTrue(listEnseignes.size() + 2 == listEnseignes2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void test10() {
		try {
			IEnseigneMetier enseigneMetier = (IEnseigneMetier) app.getBean("enseigneMetier");
			
			List<Enseigne> listEnseignes = enseigneMetier.toutAfficher();
			Enseigne e = new Enseigne();
			e.setNomEns("Halal distrib");
			enseigneMetier.creer(e);
			e = new Enseigne();
			e.setNomEns("Hal'Market");
			enseigneMetier.creer(e);
			
			List<Enseigne> listEnseignes2 = enseigneMetier.toutAfficher();
			
			
			
			assertTrue(listEnseignes.size() + 2 == listEnseignes2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void test11() {
		try {
			IEnseigneMetier enseigneMetier = (IEnseigneMetier) app.getBean("enseigneMetier");
			
			List<Enseigne> listEnseignes = enseigneMetier.toutAfficher();
			Enseigne e = new Enseigne();
			e.setNomEns("Halal distrib");
			enseigneMetier.creer(e);
			e = new Enseigne();
			e.setNomEns("Hal'Market");
			enseigneMetier.creer(e);
			
			List<Enseigne> listEnseignes2 = enseigneMetier.toutAfficher();
			
			
			
			assertTrue(listEnseignes.size() + 2 == listEnseignes2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}*/
}