package com.lamine.mesCourses.dao.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Magasin;

public interface IMagasinDAO {
	public Integer creer(Magasin magasin);
	public Magasin modifier(Magasin magasin);
	public void supprimer(Integer idMag);
	public Magasin afficher(Integer idMag);
	public List<Magasin> toutAfficher();
}