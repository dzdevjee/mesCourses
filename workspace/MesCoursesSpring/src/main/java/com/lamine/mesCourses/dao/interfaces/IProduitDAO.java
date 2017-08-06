package com.lamine.mesCourses.dao.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Produit;

public interface IProduitDAO {
	public Integer creer(Produit produit);
	public Produit modifier(Produit produit);
	public void supprimer(Integer idProd);
	public Produit afficher(Integer idProd);
	public List<Produit> toutAfficher();
}