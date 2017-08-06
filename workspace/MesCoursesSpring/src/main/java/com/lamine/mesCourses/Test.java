package com.lamine.mesCourses;

import com.lamine.mesCourses.metier.impl.EnseigneMetierImpl;
import com.lamine.mesCourses.metier.impl.MagasinMetierImpl;
import com.lamine.mesCourses.metier.interfaces.IEnseigneMetier;
import com.lamine.mesCourses.metier.interfaces.IMagasinMetier;

public class Test {

	public static void main(String[] args) {
		IEnseigneMetier enseigneMetier;
		IMagasinMetier magasinMetier;
		
		magasinMetier = new MagasinMetierImpl();
		enseigneMetier = new EnseigneMetierImpl();
		
		magasinMetier.afficher(1);
		enseigneMetier.toutAfficher();
	}
}