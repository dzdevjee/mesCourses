package com.lamine.dao.interfaces;

import java.util.List;
import com.lamine.dao.entite.Marque;

public interface MarqueDAO {
	public Integer creer(Marque marque);
	public Marque modifier(Marque marque);
	public void supprimer(Integer idMarq);
	public Marque afficher(Integer idMarq);
	public List<Marque> toutAfficher();
}