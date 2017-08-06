package com.lamine.metier.interfaces;

import java.util.List;
import com.lamine.dao.entite.TypeProduit;

public interface TypeProduitMetier {
	public Integer creer(TypeProduit typeProduit);
	public TypeProduit modifier(TypeProduit typeProduit);
	public void supprimer(Integer idTypeProduit);
	public TypeProduit afficher(Integer idTypeProduit);
	public List<TypeProduit> toutAfficher();
}