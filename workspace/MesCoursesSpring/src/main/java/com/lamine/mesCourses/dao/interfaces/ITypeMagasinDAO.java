package com.lamine.mesCourses.dao.interfaces;

import java.util.List;
import com.lamine.mesCourses.entite.TypeMagasin;

public interface ITypeMagasinDAO {
	public Integer creer(TypeMagasin typeMagasin);
	public TypeMagasin modifier(TypeMagasin typeMagasin);
	public void supprimer(Integer idTypeMagasin);
	public TypeMagasin afficher(Integer idTypeMagasin);
	public List<TypeMagasin> toutAfficher();
}