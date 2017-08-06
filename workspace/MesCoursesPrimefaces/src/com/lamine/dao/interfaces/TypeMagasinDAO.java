package com.lamine.dao.interfaces;

import java.util.List;
import com.lamine.dao.entite.TypeMagasin;

public interface TypeMagasinDAO {
	public Integer creer(TypeMagasin typeMagasin);
	public TypeMagasin modifier(TypeMagasin typeMagasin);
	public void supprimer(Integer idTypeMagasin);
	public TypeMagasin afficher(Integer idTypeMagasin);
	public List<TypeMagasin> toutAfficher();
}