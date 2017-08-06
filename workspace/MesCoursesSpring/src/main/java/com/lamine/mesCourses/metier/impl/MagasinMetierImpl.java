package com.lamine.mesCourses.metier.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.lamine.mesCourses.dao.interfaces.IMagasinDAO;
import com.lamine.mesCourses.metier.interfaces.IMagasinMetier;
import com.lamine.mesCourses.entite.Magasin;

@Transactional
public class MagasinMetierImpl implements IMagasinMetier {
	private IMagasinDAO magasinDao;
	
	public void setMagasinDao (IMagasinDAO magasinDao) {
		this.magasinDao = magasinDao;
	}

	@Override
	public Integer creer(Magasin magasin) {
		return magasinDao.creer(magasin);
	}

	@Override
	public Magasin modifier(Magasin magasin) {
		return magasinDao.modifier(magasin);
	}

	@Override
	public void supprimer(Integer idMag) {
		magasinDao.supprimer(idMag);
	}

	@Override
	public Magasin afficher(Integer idMag) {
		return magasinDao.afficher(idMag);
	}

	@Override
	public List<Magasin> toutAfficher() {
		return magasinDao.toutAfficher();
	}
}