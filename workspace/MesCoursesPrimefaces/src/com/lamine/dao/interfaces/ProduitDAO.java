package com.lamine.dao.interfaces;

import java.util.List;
import com.lamine.dao.entite.Produit;

public interface ProduitDAO {
	public Integer creer(Produit produit);
	public Produit modifier(Produit produit);
	public void supprimer(Integer idProd);
	public Produit afficher(Integer idProd);
	public List<Produit> toutAfficher();
}