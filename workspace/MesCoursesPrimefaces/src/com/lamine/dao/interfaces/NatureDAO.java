package com.lamine.dao.interfaces;

import java.util.List;
import com.lamine.dao.entite.Nature;

public interface NatureDAO {
	public Integer creer(Nature nature);
	public Nature modifier(Nature nature);
	public void supprimer(Integer idNat);
	public Nature afficher(Integer idNat);
	public List<Nature> toutAfficher();
}