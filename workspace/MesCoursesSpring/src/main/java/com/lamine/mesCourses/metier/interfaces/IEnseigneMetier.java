package com.lamine.mesCourses.metier.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Enseigne;

public interface IEnseigneMetier {
	public Integer creer(Enseigne enseigne);
	public Enseigne modifier(Enseigne enseigne);
	public void supprimer(Integer idEns);
	public Enseigne afficher(Integer idEns);
	public List<Enseigne> toutAfficher();
}