package com.lamine.application.fenetre;

import com.lamine.application.ClientJDBC;
import com.lamine.application.metier.*;
import utilitairesMG.divers.Colonne;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

@SuppressWarnings("serial")
public class FenetreClient extends JFrame implements ActionListener {

	private JDesktopPane panneauFond;

	//MenuBar--------------------------------------------------------------
	private JMenuBar barreMenu;

	//Items-du-Menu--------------------------------------------------------
	private JMenu tables;
	private JMenuItem contact;
	private JMenuItem versement;
	private JMenuItem secteur;

	//--------------------------------------------------------------------------
	//Constructeur
	//--------------------------------------------------------------------------
	public FenetreClient(String titre){

		super(titre);
		addWindowListener(new EcouteWindowClosing());

		panneauFond = new JDesktopPane();
		panneauFond.setPreferredSize(new Dimension(1000, 500));
		panneauFond.setLayout(new BorderLayout());

		//MenuBar----------------------------------------------------------
		barreMenu = new JMenuBar();

		//items du menu
		tables = new JMenu("Tables");
		tables.setMnemonic('T');
		
		contact = new JMenuItem("Contact", 'C');
		contact.addActionListener(this);

		versement = new JMenuItem("Versement", 'V');
		versement.addActionListener(this);

		secteur = new JMenuItem("Secteur", 'S');
		secteur.addActionListener(this);

		tables.add(contact);
		tables.add(versement);
		tables.add(secteur);

		barreMenu.add(tables);

		setJMenuBar(barreMenu);
		getContentPane().add(panneauFond);

		pack();

		setVisible(true);
	}

	public void afficherContact(Vector<Contact> listeContacts, Vector<Colonne> listeColonnes) {
		FenetreInterneContact fenetreInterneContact =
            new FenetreInterneContact("Contacts", listeContacts, listeColonnes);
		panneauFond.add(fenetreInterneContact);
	}

	public void afficherVersement(Vector<Versement> listeVersements, Vector<Colonne> listeColonnes){
		FenetreInterneVersement fenetreInterneVersement = new FenetreInterneVersement("Versements", listeVersements, listeColonnes);
		panneauFond.add(fenetreInterneVersement);
	}
	
	public void afficherSecteur(Vector<Secteur> listeSecteurs, Vector<Colonne> listeColonnes){
		FenetreInterneSecteur fenetreInterneSecteur = new FenetreInterneSecteur("Secteurs", listeSecteurs, listeColonnes);
		panneauFond.add(fenetreInterneSecteur);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == versement ){	
//			ClientJDBC.getVersement();
		}else if (e.getSource() == secteur ){
//			ClientJDBC.getSecteur();
		}else{
			ClientJDBC.getContact();
		}
	}

	//--------------------------------------------------------------------------
	//Ecouteur de l'evenement fermeture de la fenetre
	//--------------------------------------------------------------------------
	private class EcouteWindowClosing extends WindowAdapter	{
		@Override
		public void windowClosing(WindowEvent e) {
			ClientJDBC.arreterSysteme();
		}
	}
}