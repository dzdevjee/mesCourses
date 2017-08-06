package com.lamine.metier.impl;

import java.util.List;
import com.lamine.dao.interfaces.EnseigneDAO;
import com.lamine.metier.interfaces.EnseigneMetier;
import com.lamine.dao.entite.Enseigne;
import com.lamine.dao.impl.EnseigneDAOImpl;

public class EnseigneMetierImpl implements EnseigneMetier {
	private EnseigneDAO magasinDao = new EnseigneDAOImpl();
	
	@Override
	public Integer creer(Enseigne enseigne) {
		return magasinDao.creer(enseigne);
	}

	@Override
	public Enseigne modifier(Enseigne enseigne) {		
		return magasinDao.modifier(enseigne);
	}

	@Override
	public void supprimer(Integer idEns) {
		magasinDao.supprimer(idEns);
	}

	@Override
	public Enseigne afficher(Integer idEns) {
		return magasinDao.afficher(idEns);
	}

	@Override
	public List<Enseigne> toutAfficher() {
		return magasinDao.toutAfficher();
	}
}