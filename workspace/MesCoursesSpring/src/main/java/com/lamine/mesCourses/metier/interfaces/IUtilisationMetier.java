package com.lamine.mesCourses.metier.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Utilisation;

public interface IUtilisationMetier {
	public Integer creer(Utilisation utilisation);
	public Utilisation modifier(Utilisation utilisation);
	public void supprimer(Integer idUse);
	public Utilisation afficher(Integer idUse);
	public List<Utilisation> toutAfficher();
}