package com.lamine.metier.impl;

import java.util.List;
import com.lamine.dao.interfaces.TypeProduitDAO;
import com.lamine.metier.interfaces.TypeProduitMetier;
import com.lamine.dao.entite.TypeProduit;
import com.lamine.dao.impl.TypeProduitDAOImpl;

public class TypeProduitMetierImpl implements TypeProduitMetier {
	private TypeProduitDAO typeProduitDao = new TypeProduitDAOImpl();
	
	@Override
	public Integer creer(TypeProduit typeProduit) {
		return typeProduitDao.creer(typeProduit);
	}

	@Override
	public TypeProduit modifier(TypeProduit typeProduit) {
		return typeProduitDao.modifier(typeProduit);
	}

	@Override
	public void supprimer(Integer idTypeProduit) {
		typeProduitDao.supprimer(idTypeProduit);
	}

	@Override
	public TypeProduit afficher(Integer idTypeProduit) {
		return typeProduitDao.afficher(idTypeProduit);
	}

	@Override
	public List<TypeProduit> toutAfficher() {
		return typeProduitDao.toutAfficher();
	}
}