package com.lamine.dao.interfaces;

import java.util.List;
import com.lamine.dao.entite.Choix;

public interface ChoixDAO {
	public Integer creer(Choix choix);
	public Choix modifier(Choix choix);
	public void supprimer(Integer idChoix);
	public Choix afficher(Integer idChoix);
	public List<Choix> toutAfficher();
}