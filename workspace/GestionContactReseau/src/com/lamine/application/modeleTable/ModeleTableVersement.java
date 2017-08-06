package com.lamine.application.modeleTable;

import com.lamine.application.metier.*;
import utilitairesMG.divers.Colonne;
import utilitairesMG.graphique.table.ModeleTable;

import java.math.BigDecimal;
import java.util.*;

@SuppressWarnings("serial")
public class ModeleTableVersement extends ModeleTable {

	public ModeleTableVersement(Vector<Versement> listeVersements,
								Vector<Colonne> listeColonnes) {
		
		Vector<Vector<Object>>listeLignes = new Vector<Vector<Object>>();

		for (int i = 0; i < listeVersements.size(); i++) {
			Vector<Object> ligne = new Vector<Object>();
			Versement v = listeVersements.elementAt(i);

			ligne.addElement(v.getNumero());
			ligne.addElement(v.getDate());
			ligne.addElement(v.getMontant());
			ligne.addElement(v.getNumeroContact());

			listeLignes.addElement(ligne);
		}

		setListeLignes(listeLignes);
		setListeColonnes(listeColonnes);
	}

	public Vector<Versement> getListeVersements() {
		Vector<Versement> listeVersements = new Vector<Versement>();
		Vector<Vector<Object>>listeLignes = getListeLignes();

		for (int i = 0; i < listeLignes.size(); i++) {
			
			Vector<Object> ligne = listeLignes.elementAt(i);
			Versement v = new Versement();

			v.setNumero((Integer)ligne.elementAt(0));
			v.setDate((Date)ligne.elementAt(1));
			v.setMontant((BigDecimal)ligne.elementAt(2));
			v.setNumeroContact((Integer)ligne.elementAt(3));

			listeVersements.addElement(v);
		}

		return listeVersements;
	}

	public Vector<Versement> getListeVersementsSupprimes() {
		Vector<Versement> listeVersements = new Vector<Versement>();
		Vector<Vector<Object>>listeLignes = getListeLignesSupprimees();

		for (int i = 0; i < listeLignes.size(); i++) {
			Vector<Object> ligne = listeLignes.elementAt(i);
			Versement v = new Versement();

			v.setNumero((Integer)ligne.elementAt(0));
			v.setDate((Date)ligne.elementAt(1));
			v.setMontant((BigDecimal)ligne.elementAt(2));
			v.setNumeroContact((Integer)ligne.elementAt(3));

			listeVersements.addElement(v);
		}

		return listeVersements;
	}

	public Vector<Versement> getListeVersements(Character marqueur)	{
		Vector<Versement> listeVersements = new Vector<Versement>();
		Vector<Vector<Object>>listeLignes = getListeLignes();

		Vector<Character> marqueursLigne = getMarqueursLignes();

		for (int i = 0; i < listeLignes.size(); i++) {
			if (marqueursLigne.elementAt(i).compareTo(marqueur) == 0) {
				Vector<Object> ligne = listeLignes.elementAt(i);
				Versement v = new Versement();

				v.setNumero((Integer)ligne.elementAt(0));
				v.setDate((Date)ligne.elementAt(1));
				v.setMontant((BigDecimal)ligne.elementAt(2));
				v.setNumeroContact((Integer)ligne.elementAt(3));

				listeVersements.addElement(v);
			}
		}

		return listeVersements;
	}

	@Override
	public boolean isCellEditable(int lig, int col) {
		return true;
	}
	
	@Override
	public int getRowCount() {
		return super.getRowCount() + 1;
	}
}