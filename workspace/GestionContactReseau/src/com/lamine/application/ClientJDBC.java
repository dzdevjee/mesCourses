package com.lamine.application;

import java.net.*;
import java.sql.*;
import java.util.*;
import com.lamine.application.dao.*;
import com.lamine.application.fenetre.FenetreClient;
import com.lamine.application.metier.Contact;
import com.lamine.application.metier.Secteur;
import com.lamine.application.metier.Versement;
import com.lamine.application.utilitaire.BaseDeDonnees;
import java.io.*;
import utilitairesMG.divers.Colonne;

public class ClientJDBC {
	private static FenetreClient fenetre;
	private static ContactDAO contactDAO;
	private static BaseDeDonnees baseDeDonnees;
	private static String url = "jdbc:mysql://localhost:2602/gestioncontacts?useSSL=false";
	private static String utilisateur = "root";
	private static String motDePasse = "khad";

	public static void main (String argv[]){
    	Socket socketServeur;
    	
    	try {
            Class.forName("com.mysql.jdbc.Driver");
            baseDeDonnees = new BaseDeDonnees(url, utilisateur, motDePasse);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Erreur -->  Driver inconnu " + cnfe.getMessage());
        }
    	
        try {
            socketServeur = new Socket("localhost", 6226);
            fenetre = new FenetreClient("GestionContactLocal");
           
            socketServeur.close();

        } catch (ConnectException ce) {
            System.out.println("Connexion impossible : serveur indisponible");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
	public static void getContact() {
		Vector<Contact> listeContacts;
		Vector<Colonne> listeColonnes;
		
		try {
			baseDeDonnees.getConnection(url, utilisateur, motDePasse);
			contactDAO = new ContactDAO(baseDeDonnees);
			try {
				listeContacts = contactDAO.lireListe();
				listeColonnes = contactDAO.getListeColonnes();
				
				fenetre.afficherContact(listeContacts, listeColonnes);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				baseDeDonnees.closeConnection();
			}
		} catch (SQLException e) {
				System.out.println(e.getMessage());
		}
	}
	
	public static void majContact(Vector<Contact> listeContacts, Vector<Contact> listeContacts2,
			Vector<Contact> listeContactsSupprimes) {
	}
	//--------------------------------------------------------------------------
	//Arret de l'application.
	//--------------------------------------------------------------------------
    
    public static void arreterSysteme() {
        System.exit(0);
    }
}