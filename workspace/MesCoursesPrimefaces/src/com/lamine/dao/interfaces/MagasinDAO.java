package com.lamine.dao.interfaces;

import java.util.List;
import com.lamine.dao.entite.Magasin;

public interface MagasinDAO {
	public Integer creer(Magasin magasin);
	public Magasin modifier(Magasin magasin);
	public void supprimer(Integer idMag);
	public Magasin afficher(Integer idMag);
	public List<Magasin> toutAfficher();
}