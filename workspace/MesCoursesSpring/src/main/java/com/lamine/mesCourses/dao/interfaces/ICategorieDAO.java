package com.lamine.mesCourses.dao.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Categorie;

public interface ICategorieDAO {
	public Integer creer(Categorie categorie);
	public Categorie modifier(Categorie categorie);
	public void supprimer(Integer idCat);
	public Categorie afficher(Integer idCat);
	public List<Categorie> toutAfficher();
}