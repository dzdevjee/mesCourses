package com.lamine.mesCourses.metier.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Categorie;

public interface ICategorieMetier {
	public Integer creer(Categorie categorie);
	public Categorie modifier(Categorie categorie);
	public void supprimer(Integer idCat);
	public Categorie afficher(Integer idCat);
	public List<Categorie> toutAfficher();
}