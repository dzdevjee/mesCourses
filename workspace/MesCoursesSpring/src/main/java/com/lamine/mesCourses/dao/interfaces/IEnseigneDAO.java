package com.lamine.mesCourses.dao.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Enseigne;

public interface IEnseigneDAO {
	public Integer creer(Enseigne enseigne);
	public Enseigne modifier(Enseigne enseigne);
	public void supprimer(Integer idEns);
	public Enseigne afficher(Integer idEns);
	public List<Enseigne> toutAfficher();
}