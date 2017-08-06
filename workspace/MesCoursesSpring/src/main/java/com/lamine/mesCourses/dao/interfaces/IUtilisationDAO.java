package com.lamine.mesCourses.dao.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Utilisation;

public interface IUtilisationDAO {
	public Integer creer(Utilisation utilisation);
	public Utilisation modifier(Utilisation utilisation);
	public void supprimer(Integer idUse);
	public Utilisation afficher(Integer idUse);
	public List<Utilisation> toutAfficher();
}