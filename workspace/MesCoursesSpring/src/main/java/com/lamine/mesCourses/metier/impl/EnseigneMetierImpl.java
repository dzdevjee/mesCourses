package com.lamine.mesCourses.metier.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.lamine.mesCourses.dao.interfaces.IEnseigneDAO;
import com.lamine.mesCourses.metier.interfaces.IEnseigneMetier;
import com.lamine.mesCourses.entite.Enseigne;

@Transactional
public class EnseigneMetierImpl implements IEnseigneMetier {
	private IEnseigneDAO enseigneDao;

	public void setEnseigneDao (IEnseigneDAO enseigneDao) {
		this.enseigneDao = enseigneDao;
	}

	@Override
	public Integer creer(Enseigne enseigne) {
		return enseigneDao.creer(enseigne);
	}

	@Override
	public Enseigne modifier(Enseigne enseigne) {
		return enseigneDao.modifier(enseigne);
	}

	@Override
	public void supprimer(Integer idEns) {
		enseigneDao.supprimer(idEns);
	}

	@Override
	public Enseigne afficher(Integer idEns) {
		return enseigneDao.afficher(idEns);
	}

	@Override
	public List<Enseigne> toutAfficher() {
		return enseigneDao.toutAfficher();
	}
}