package com.lamine.mesCourses.metier.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.TypeProduit;

public interface ITypeProduitMetier {
	public Integer creer(TypeProduit typeProduit);
	public TypeProduit modifier(TypeProduit typeProduit);
	public void supprimer(Integer idTypeProd);
	public TypeProduit afficher(Integer idTypeProd);
	public List<TypeProduit> toutAfficher();
}