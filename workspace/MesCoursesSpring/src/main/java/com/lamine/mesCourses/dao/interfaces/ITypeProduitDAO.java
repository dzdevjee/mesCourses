package com.lamine.mesCourses.dao.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.TypeProduit;

public interface ITypeProduitDAO {
	public Integer creer(TypeProduit typeProduit);
	public TypeProduit modifier(TypeProduit typeProduit);
	public void supprimer(Integer idTypeProduit);
	public TypeProduit afficher(Integer idTypeProduit);
	public List<TypeProduit> toutAfficher();
}