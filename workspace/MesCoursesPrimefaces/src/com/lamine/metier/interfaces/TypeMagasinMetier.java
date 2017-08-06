package com.lamine.metier.interfaces;

import java.util.List;
import com.lamine.dao.entite.TypeMagasin;

public interface TypeMagasinMetier {
	public Integer creer(TypeMagasin typeMagasin);
	public TypeMagasin modifier(TypeMagasin typeMagasin);
	public void supprimer(Integer idTypeMagasin);
	public TypeMagasin afficher(Integer idTypeMagasin);
	public List<TypeMagasin> toutAfficher();
}