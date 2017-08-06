package com.lamine.metier.interfaces;

import java.util.List;
import com.lamine.dao.entite.Enseigne;

public interface EnseigneMetier {
	public Integer creer(Enseigne enseigne);
	public Enseigne modifier(Enseigne enseigne);
	public void supprimer(Integer idEns);
	public Enseigne afficher(Integer idEns);
	public List<Enseigne> toutAfficher();
}