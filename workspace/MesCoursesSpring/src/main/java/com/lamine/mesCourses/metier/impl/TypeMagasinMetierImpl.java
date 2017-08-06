package com.lamine.mesCourses.metier.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.lamine.mesCourses.dao.interfaces.ITypeMagasinDAO;
import com.lamine.mesCourses.metier.interfaces.ITypeMagasinMetier;
import com.lamine.mesCourses.entite.TypeMagasin;

@Transactional
public class TypeMagasinMetierImpl implements ITypeMagasinMetier {
	private ITypeMagasinDAO typeMagasinDao;

	public void setTypeMagasinDao (ITypeMagasinDAO typeMagasinDao) {
		this.typeMagasinDao = typeMagasinDao;
	}

	@Override
	public Integer creer(TypeMagasin typeMagasin) {
		return typeMagasinDao.creer(typeMagasin);
	}

	@Override
	public TypeMagasin modifier(TypeMagasin typeMagasin) {
		return typeMagasinDao.modifier(typeMagasin);
	}

	@Override
	public void supprimer(Integer idTypeMag) {
		typeMagasinDao.supprimer(idTypeMag);
	}

	@Override
	public TypeMagasin afficher(Integer idTypeMag) {
		return typeMagasinDao.afficher(idTypeMag);
	}

	@Override
	public List<TypeMagasin> toutAfficher() {
		return typeMagasinDao.toutAfficher();
	}
}