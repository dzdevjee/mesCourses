package com.lamine.application.modeleTable;

import com.lamine.application.metier.Secteur;

import utilitairesMG.divers.Colonne;
import utilitairesMG.graphique.table.ModeleTable;

import java.util.*;

@SuppressWarnings("serial")
public class ModeleTableSecteur extends ModeleTable {

	public ModeleTableSecteur(Vector<Secteur> listeSecteurs,
			Vector<Colonne> listeColonnes) {
		
		Vector<Vector<Object>>listeLignes = new Vector<Vector<Object>>();

		for (int i = 0; i < listeSecteurs.size(); i++) {
			Vector<Object> ligne = new Vector<Object>();
			Secteur s = listeSecteurs.elementAt(i);

			ligne.addElement(s.getCode());
			ligne.addElement(s.getLibelle());
			
			listeLignes.addElement(ligne);
		}

		setListeLignes(listeLignes);
		setListeColonnes(listeColonnes);
	}

	public Vector<Secteur> getListeSecteurs() {
		Vector<Secteur> listeSecteurs = new Vector<Secteur>();
		Vector<Vector<Object>>listeLignes = getListeLignes();

		for (int i = 0; i < listeLignes.size(); i++) {
			
			Vector<Object> ligne = listeLignes.elementAt(i);
			Secteur s = new Secteur();

			s.setCode((Integer)ligne.elementAt(0));
			s.setLibelle((String)ligne.elementAt(1));
			
			listeSecteurs.addElement(s);
		}

		return listeSecteurs;
	}

	public Vector<Secteur> getListeSecteursSupprimes() {
		Vector<Secteur> listeSecteurs = new Vector<Secteur>();
		Vector<Vector<Object>>listeLignes = getListeLignesSupprimees();

		for (int i = 0; i < listeLignes.size(); i++) {
			Vector<Object> ligne = listeLignes.elementAt(i);
			Secteur s = new Secteur();

			s.setCode((Integer)ligne.elementAt(0));
			s.setLibelle((String)ligne.elementAt(1));
			
			listeSecteurs.addElement(s);
		}

		return listeSecteurs;
	}

	public Vector<Secteur> getListeSecteurs(Character marqueur) {
		Vector<Secteur> listeSecteurs = new Vector<Secteur>();
		Vector<Vector<Object>>listeLignes = getListeLignes();

		Vector<Character> marqueursLigne = getMarqueursLignes();

		for (int i = 0; i < listeLignes.size(); i++) {
			if (marqueursLigne.elementAt(i).compareTo(marqueur) == 0) {
				Vector<Object> ligne = listeLignes.elementAt(i);
				Secteur s = new Secteur();

				s.setCode((Integer)ligne.elementAt(0));
				s.setLibelle((String)ligne.elementAt(1));

				listeSecteurs.addElement(s);
			}
		}

		return listeSecteurs;
	}

	@Override
	public boolean isCellEditable(int lig, int col)	{
		return true;
	}

	@Override
	public int getRowCount() {
		return super.getRowCount() + 1;
	}
}