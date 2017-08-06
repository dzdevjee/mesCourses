package com.lamine.mesCourses.metier.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.lamine.mesCourses.dao.interfaces.INatureDAO;
import com.lamine.mesCourses.metier.interfaces.INatureMetier;
import com.lamine.mesCourses.entite.Nature;

@Transactional
public class NatureMetierImpl implements INatureMetier {
	private INatureDAO natureDao;

	public void setNatureDao (INatureDAO natureDao) {
		this.natureDao = natureDao;
	}

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