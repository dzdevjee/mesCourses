package com.lamine.mesCourses.dao.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Nature;

public interface INatureDAO {
	public Integer creer(Nature nature);
	public Nature modifier(Nature nature);
	public void supprimer(Integer idNat);
	public Nature afficher(Integer idNat);
	public List<Nature> toutAfficher();
}