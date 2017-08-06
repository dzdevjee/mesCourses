package com.lamine.metier.impl;

import java.util.List;
import com.lamine.dao.interfaces.UtilisationDAO;
import com.lamine.metier.interfaces.UtilisationMetier;
import com.lamine.dao.entite.Utilisation;
import com.lamine.dao.impl.UtilisationDAOImpl;

public class UtilisationMetierImpl implements UtilisationMetier {
	private UtilisationDAO utilisationDao = new UtilisationDAOImpl();

	@Override
	public Integer creer(Utilisation utilisation) {
		return utilisationDao.creer(utilisation);
	}

	@Override
	public Utilisation modifier(Utilisation utilisation) {
		return utilisationDao.modifier(utilisation);
	}

	@Override
	public void supprimer(Integer idUse) {
		utilisationDao.supprimer(idUse);
	}

	@Override
	public Utilisation afficher(Integer idUse) {
		return utilisationDao.afficher(idUse);
	}

	@Override
	public List<Utilisation> toutAfficher() {
		return utilisationDao.toutAfficher();
	}
}