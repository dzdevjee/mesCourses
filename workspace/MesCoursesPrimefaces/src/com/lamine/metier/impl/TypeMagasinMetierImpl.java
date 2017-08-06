package com.lamine.metier.impl;

import java.util.List;
import com.lamine.dao.entite.TypeMagasin;
import com.lamine.dao.impl.TypeMagasinDAOImpl;
import com.lamine.dao.interfaces.TypeMagasinDAO;
import com.lamine.metier.interfaces.TypeMagasinMetier;

public class TypeMagasinMetierImpl implements TypeMagasinMetier {
	private TypeMagasinDAO typeMagasinDao = new TypeMagasinDAOImpl();		
	
	@Override
	public Integer creer(TypeMagasin typeMagasin) {
		return typeMagasinDao.creer(typeMagasin);
	}

	@Override
	public TypeMagasin modifier(TypeMagasin typeMagasin) {
		return typeMagasinDao.modifier(typeMagasin);
	}

	@Override
	public void supprimer(Integer idTypeMagasin) {
		typeMagasinDao.supprimer(idTypeMagasin);
	}
	
	@Override
	public TypeMagasin afficher(Integer idTypeMagasin) {
		return typeMagasinDao.afficher(idTypeMagasin);
	}
	
	@Override
	public List<TypeMagasin> toutAfficher() {
		return typeMagasinDao.toutAfficher();
	}
}