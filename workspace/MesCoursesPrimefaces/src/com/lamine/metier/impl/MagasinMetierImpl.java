package com.lamine.metier.impl;

import java.util.List;
import com.lamine.dao.interfaces.MagasinDAO;
import com.lamine.metier.interfaces.MagasinMetier;
import com.lamine.dao.entite.Magasin;
import com.lamine.dao.impl.MagasinDAOImpl;

public class MagasinMetierImpl implements MagasinMetier {
	private MagasinDAO magasinDao = new MagasinDAOImpl();
	
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