package com.lamine.dao.interfaces;

import java.util.List;
import com.lamine.dao.entite.Categorie;

public interface CategorieDAO {
	public Integer creer(Categorie categorie);
	public Categorie modifier(Categorie categorie);
	public void supprimer(Integer idCat);
	public Categorie afficher(Integer idCat);
	public List<Categorie> toutAfficher();
}