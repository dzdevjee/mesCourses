package com.lamine.metier.interfaces;

import java.util.List;
import com.lamine.dao.entite.Produit;

public interface ProduitMetier {
	public Integer creer(Produit produit);
	public Produit modifier(Produit produit);
	public void supprimer(Integer idProd);
	public Produit afficher(Integer idProd);
	public List<Produit> toutAfficher();
}