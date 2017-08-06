package com.lamine.dao.interfaces;

import java.util.List;
import com.lamine.dao.entite.Utilisation;

public interface UtilisationDAO {
	public Integer creer(Utilisation utilisation);
	public Utilisation modifier(Utilisation utilisation);
	public void supprimer(Integer idUse);
	public Utilisation afficher(Integer idUse);
	public List<Utilisation> toutAfficher();
}