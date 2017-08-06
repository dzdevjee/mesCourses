package com.lamine.application.dao;

import com.lamine.application.*;
import com.lamine.application.utilitaire.BaseDeDonnees;
import utilitairesMG.divers.Colonne;
import utilitairesMG.jdbc.JeuResultat;
import java.util.*;

import javax.crypto.CipherInputStream;

import java.sql.*;
import com.lamine.application.metier.Contact;

@SuppressWarnings("unused")
public class ContactDAO {
	private BaseDeDonnees baseDeDonnees;
	private JeuResultat jeuResultat;
	private static String requete;
	
	public ContactDAO(BaseDeDonnees baseDeDonnees) {
		this.baseDeDonnees = baseDeDonnees;
	}
	
	public Vector<Contact> lireListe() throws SQLException {
		Vector<Contact> listeContacts;
		Contact contact;
		
		String select = "SELECT * FROM CONTACT";
		int nombreDeContacts;
		Vector ligneContact;
		int i;

		jeuResultat = baseDeDonnees.executeQuery(select);

		listeContacts = new Vector<Contact>();
		nombreDeContacts = (jeuResultat.getLignes()).size();
		
		for (i = 0; i < nombreDeContacts; i++) {
			ligneContact = (Vector)((jeuResultat.getLignes()).elementAt(i));
			
			contact = new Contact();
			contact.setNumero((Integer)ligneContact.elementAt(0));
			contact.setNom((String)ligneContact.elementAt(1));
			contact.setAdresse((String)ligneContact.elementAt(2));
			contact.setCodePostal((String)ligneContact.elementAt(3));
			contact.setVille((String)ligneContact.elementAt(4));
			contact.setCodeSecteur((Integer)ligneContact.elementAt(5));
		
			listeContacts.addElement(contact);
		}
		requete = select;
		return listeContacts;
	}
	
	public Vector<Colonne> getListeColonnes() {
		return jeuResultat.getColonnes();
	}
}