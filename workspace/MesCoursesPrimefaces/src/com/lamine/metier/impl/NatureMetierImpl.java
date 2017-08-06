package com.lamine.metier.impl;

import java.util.List;
import com.lamine.dao.interfaces.NatureDAO;
import com.lamine.metier.interfaces.NatureMetier;
import com.lamine.dao.entite.Nature;
import com.lamine.dao.impl.NatureDAOImpl;

public class NatureMetierImpl implements NatureMetier {
	private NatureDAO natureDao = new NatureDAOImpl();
	
	@Override
	public Integer creer(Nature nature) {
		return natureDao.creer(nature);
	}

	@Override
	public Nature modifier(Nature nature) {
		return natureDao.modifier(nature);
	}

	@Override
	public void supprimer(Integer idNat) {
		natureDao.supprimer(idNat);
	}

	@Override
	public Nature afficher(Integer idNat) {
		return natureDao.afficher(idNat);
	}

	@Override
	public List<Nature> toutAfficher() {
		return natureDao.toutAfficher();
	}
}