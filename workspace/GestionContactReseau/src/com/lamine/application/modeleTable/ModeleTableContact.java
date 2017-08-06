package com.lamine.application.modeleTable;

import com.lamine.application.metier.Contact;
import utilitairesMG.divers.Colonne;
import utilitairesMG.graphique.table.ModeleTable;

import java.util.*;

@SuppressWarnings("serial")
public class ModeleTableContact extends ModeleTable {

	//--------------------------------------------------------------------------
	//CONSTRUCTEUR
	//--------------------------------------------------------------------------
	//On transforme la liste d'objets 'Contact' en  lignes (Vector<Object>) pour
	//alimenter le ModeleTable
	//--------------------------------------------------------------------------
	public ModeleTableContact(Vector<Contact> listeContacts,
			Vector<Colonne> listeColonnes) {
		
		Vector<Vector<Object>>listeLignes = new Vector<Vector<Object>>();

		for (int i = 0; i < listeContacts.size(); i++) {
			Vector<Object> ligne = new Vector<Object>();
			Contact c = listeContacts.elementAt(i);

			ligne.addElement(c.getNumero());
			ligne.addElement(c.getNom());
			ligne.addElement(c.getAdresse());
			ligne.addElement(c.getCodePostal());
			ligne.addElement(c.getVille());
			ligne.addElement(c.getCodeSecteur());

			listeLignes.addElement(ligne);
		}

		setListeLignes(listeLignes);
		setListeColonnes(listeColonnes);
	}

	//--------------------------------------------------------------------------
	//Recuperation de la liste des contacts a partir de la liste des lignes du
	//ModeleTable
	//--------------------------------------------------------------------------
	public Vector<Contact> getListeContacts() {
		Vector<Contact> listeContacts = new Vector<Contact>();
		Vector<Vector<Object>>listeLignes = getListeLignes();

		for (int i = 0; i < listeLignes.size(); i++) {
			
			Vector<Object> ligne = listeLignes.elementAt(i);
			Contact c = new Contact();

			c.setNumero((Integer)ligne.elementAt(0));
			c.setNom((String)ligne.elementAt(1));
			c.setAdresse((String)ligne.elementAt(2));
			c.setCodePostal((String)ligne.elementAt(3));
			c.setVille((String)ligne.elementAt(4));
			c.setCodeSecteur((Integer)ligne.elementAt(5));

			listeContacts.addElement(c);
		}

		return listeContacts;
	}

	//--------------------------------------------------------------------------
	//Recuperation de la liste des contacts supprimes a partir de la liste des
	//lignes supprimees du ModeleTable
	//--------------------------------------------------------------------------
	public Vector<Contact> getListeContactsSupprimes()
	{
		Vector<Contact> listeContacts = new Vector<Contact>();
		Vector<Vector<Object>>listeLignes = getListeLignesSupprimees();

		for (int i = 0; i < listeLignes.size(); i++)
		{
			Vector<Object> ligne = listeLignes.elementAt(i);
			Contact c = new Contact();

			c.setNumero((Integer)ligne.elementAt(0));
			c.setNom((String)ligne.elementAt(1));
			c.setAdresse((String)ligne.elementAt(2));
			c.setCodePostal((String)ligne.elementAt(3));
			c.setVille((String)ligne.elementAt(4));
			c.setCodeSecteur((Integer)ligne.elementAt(5));

			listeContacts.addElement(c);
		}

		return listeContacts;
	}

	//--------------------------------------------------------------------------
	//Recuperation de la liste des 'Contact' marques.
	//Le marqueur sert a reperer les contacts modifies ('M') ou inseres ('I').
	//--------------------------------------------------------------------------
	public Vector<Contact> getListeContacts(Character marqueur)
	{
		Vector<Contact> listeContacts = new Vector<Contact>();
		Vector<Vector<Object>>listeLignes = getListeLignes();

		Vector<Character> marqueursLigne = getMarqueursLignes();

		for (int i = 0; i < listeLignes.size(); i++)
		{
			if (marqueursLigne.elementAt(i).compareTo(marqueur) == 0)
			{
				Vector<Object> ligne = listeLignes.elementAt(i);
				Contact c = new Contact();

				c.setNumero((Integer)ligne.elementAt(0));
				c.setNom((String)ligne.elementAt(1));
				c.setAdresse((String)ligne.elementAt(2));
				c.setCodePostal((String)ligne.elementAt(3));
				c.setVille((String)ligne.elementAt(4));
				c.setCodeSecteur((Integer)ligne.elementAt(5));

				listeContacts.addElement(c);
			}
		}

		return listeContacts;
	}

	//--------------------------------------------------------------------------
	//Rendre editables toutes les cellules sauf la premiere colonne
	//--------------------------------------------------------------------------
	@Override
	public boolean isCellEditable(int lig, int col)
	{
		return true;
	}

	//--------------------------------------------------------------------------
	//Creer une ligne de plus dans la JTable pour permettre les ajouts
	//--------------------------------------------------------------------------
	@Override
	public int getRowCount()
	{
		return super.getRowCount() + 1;
	}
}