package com.lamine.mesCourses.metier.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.Marque;

public interface IMarqueMetier {
	public Integer creer(Marque marque);
	public Marque modifier(Marque marque);
	public void supprimer(Integer idMarq);
	public Marque afficher(Integer idMarq);
	public List<Marque> toutAfficher();
}