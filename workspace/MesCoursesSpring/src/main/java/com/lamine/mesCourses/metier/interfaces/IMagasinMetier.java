package com.lamine.mesCourses.metier.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Magasin;

public interface IMagasinMetier {
	public Integer creer(Magasin magasin);
	public Magasin modifier(Magasin magasin);
	public void supprimer(Integer idMag);
	public Magasin afficher(Integer idMag);
	public List<Magasin> toutAfficher();
}