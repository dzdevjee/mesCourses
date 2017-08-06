package com.lamine.mesCourses.metier.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.lamine.mesCourses.dao.interfaces.IUtilisationDAO;
import com.lamine.mesCourses.metier.interfaces.IUtilisationMetier;
import com.lamine.mesCourses.entite.Utilisation;

@Transactional
public class UtilisationMetierImpl implements IUtilisationMetier {
	private IUtilisationDAO utilisationDao;

	public void setUtilisationDao (IUtilisationDAO utilisationDao) {
		this.utilisationDao = utilisationDao;
	}

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