package com.lamine.mesCourses.metier.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.lamine.mesCourses.dao.interfaces.ITypeProduitDAO;
import com.lamine.mesCourses.metier.interfaces.ITypeProduitMetier;
import com.lamine.mesCourses.entite.TypeProduit;

@Transactional
public class TypeProduitMetierImpl implements ITypeProduitMetier {
	private ITypeProduitDAO typeProduitDao;

	public void setTypeProduitDao (ITypeProduitDAO typeProduitDao) {
		this.typeProduitDao = typeProduitDao;
	}

	@Override
	public Integer creer(TypeProduit typeProduit) {
		return typeProduitDao.creer(typeProduit);
	}

	@Override
	public TypeProduit modifier(TypeProduit typeProduit) {
		return typeProduitDao.modifier(typeProduit);
	}

	@Override
	public void supprimer(Integer idTypeProd) {
		typeProduitDao.supprimer(idTypeProd);
	}

	@Override
	public TypeProduit afficher(Integer idTypeProd) {
		return typeProduitDao.afficher(idTypeProd);
	}

	@Override
	public List<TypeProduit> toutAfficher() {
		return typeProduitDao.toutAfficher();
	}
}