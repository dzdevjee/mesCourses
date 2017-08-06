package com.lamine.mesCourses.metier.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.lamine.mesCourses.dao.interfaces.IMarqueDAO;
import com.lamine.mesCourses.metier.interfaces.IMarqueMetier;
import com.lamine.mesCourses.entite.Marque;

@Transactional
public class MarqueMetierImpl implements IMarqueMetier {
	private IMarqueDAO marqueDao;

	public void setMarqueDao (IMarqueDAO marqueDao) {
		this.marqueDao = marqueDao;
	}

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