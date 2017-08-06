package com.lamine.metier.impl;

import java.util.List;
import com.lamine.dao.interfaces.MarqueDAO;
import com.lamine.metier.interfaces.MarqueMetier;
import com.lamine.dao.entite.Marque;
import com.lamine.dao.impl.MarqueDAOImpl;

public class MarqueMetierImpl implements MarqueMetier {
	private MarqueDAO marqueDao = new MarqueDAOImpl();
	
	@Override
	public Integer creer(Marque marque) {
		return marqueDao.creer(marque);
	}

	@Override
	public Marque modifier(Marque marque) {
		return marqueDao.modifier(marque);
	}

	@Override
	public void supprimer(Integer idMarq) {
		marqueDao.supprimer(idMarq);	
	}

	@Override
	public Marque afficher(Integer idMarq) {
		return marqueDao.afficher(idMarq);
	}

	@Override
	public List<Marque> toutAfficher() {
		return marqueDao.toutAfficher();
	}
}