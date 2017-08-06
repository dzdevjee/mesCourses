package com.lamine.metier.interfaces;

import java.util.List;
import com.lamine.dao.entite.Utilisation;

public interface UtilisationMetier {
	public Integer creer(Utilisation utilisation);
	public Utilisation modifier(Utilisation utilisation);
	public void supprimer(Integer idUse);
	public Utilisation afficher(Integer idUse);
	public List<Utilisation> toutAfficher();
}