package com.lamine.metier.impl;

import java.util.List;
import com.lamine.dao.interfaces.ChoixDAO;
import com.lamine.metier.interfaces.ChoixMetier;
import com.lamine.dao.entite.Choix;
import com.lamine.dao.impl.ChoixDAOImpl;

public class ChoixMetierImpl implements ChoixMetier {
	private ChoixDAO choixDao = new ChoixDAOImpl();

	@Override
	public Integer creer(Choix choix) {
		return choixDao.creer(choix);
	}

	@Override
	public Choix modifier(Choix choix) {
		return choixDao.modifier(choix);
	}

	@Override
	public void supprimer(Integer idChoix) {
		choixDao.supprimer(idChoix);
	}

	@Override
	public Choix afficher(Integer idChoix) {
		return choixDao.afficher(idChoix);
	}

	@Override
	public List<Choix> toutAfficher() {
		return choixDao.toutAfficher();
	}
}