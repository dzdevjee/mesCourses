package com.lamine.mesCourses.dao.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Marque;

public interface IMarqueDAO {
	public Integer creer(Marque marque);
	public Marque modifier(Marque marque);
	public void supprimer(Integer idMarq);
	public Marque afficher(Integer idMarq);
	public List<Marque> toutAfficher();
}