package com.lamine.metier.interfaces;

import java.util.List;
import com.lamine.dao.entite.Magasin;

public interface MagasinMetier {
	public Integer creer(Magasin magasin);
	public Magasin modifier(Magasin magasin);
	public void supprimer(Integer idMag);
	public Magasin afficher(Integer idMag);
	public List<Magasin> toutAfficher();
}