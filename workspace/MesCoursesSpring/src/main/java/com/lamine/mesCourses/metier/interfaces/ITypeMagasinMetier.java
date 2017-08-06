package com.lamine.mesCourses.metier.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.TypeMagasin;

public interface ITypeMagasinMetier {
	public Integer creer(TypeMagasin typeMagasin);
	public TypeMagasin modifier(TypeMagasin typeMagasin);
	public void supprimer(Integer idTypeMag);
	public TypeMagasin afficher(Integer idTypeMag);
	public List<TypeMagasin> toutAfficher();
}