package com.lamine.application.fenetre;

import com.lamine.application.metier.Versement;
import com.lamine.application.modeleTable.ModeleTableVersement;
import com.lamine.application.utilitaire.*;

import utilitairesMG.divers.Colonne;
import utilitairesMG.graphique.table.ModeleColonneTable;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class FenetreInterneVersement extends JInternalFrame implements ActionListener {

	private JPanel panneauInterne;

	private JTable table;
	private ModeleTableVersement modeleTable;
	private ModeleColonneTable modeleColonne;

	private JScrollPane defileur;

	//MenuBar--------------------------------------------------------------
	private JMenuBar barreMenu;

	//Items-du-Menu--------------------------------------------------------
	private JMenu edition;
	private JMenuItem supprimer;
	private JMenuItem restaurer;

	//--------------------------------------------------------------------------
	//Constructeur
	//--------------------------------------------------------------------------
	
	public FenetreInterneVersement(String titre, Vector<Versement> listeVersements,
			Vector<Colonne> listeColonnes) {
		
		super(titre, true, true, true, true);
		addInternalFrameListener(new EcouteWindowClosing());

		//MenuBar----------------------------------------------------------
		barreMenu = new JMenuBar();

		//items du menu
		edition = new JMenu("Edition");
		edition.setMnemonic('E');

		supprimer = new JMenuItem("Supprimer", 'S');
		supprimer.addActionListener(this);

		restaurer = new JMenuItem("Restaurer", 'R');
		restaurer.addActionListener(this);
		restaurer.setEnabled(false);

		edition.add(supprimer);
		edition.add(restaurer);

		barreMenu.add(edition);

		setJMenuBar(barreMenu);

		//--------------------------------------------------------------------------
		//Création de l'objet JPanel :
		//--------------------------------------------------------------------------
		panneauInterne = new JPanel();
		panneauInterne.setLayout(new BorderLayout());
		panneauInterne.setPreferredSize(new Dimension(1000, 500));

		//--------------------------------------------------------------------------
		//Création de l'objet JTable :
		//--------------------------------------------------------------------------
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//--------------------------------------------------------------------------
		//Recherche de la largeur en nombre de points de la lettre M de la police
		//par defaut de la JTable.
		//--------------------------------------------------------------------------
		Font fontParDefaut = table.getFont();
		int tailleM = table.getFontMetrics(fontParDefaut).stringWidth("M");

		//--------------------------------------------------------------------------
		//Creation des modeles de table et de colonne.
		//--------------------------------------------------------------------------
		modeleTable = new ModeleTableVersement(listeVersements, listeColonnes);
		modeleColonne = new ModeleColonneTable(listeColonnes, tailleM);

		//--------------------------------------------------------------------------
		//Ajout des modeles a la JTable.
		//--------------------------------------------------------------------------
		table.setModel(modeleTable);
		table.setColumnModel(modeleColonne);
		defileur = new JScrollPane(table);
		defileur.getViewport().setBackground(new Color(220, 170, 255));

		panneauInterne.add(defileur);

		getContentPane().add(panneauInterne);

		pack();
		setVisible(true);
	}

	//--------------------------------------------------------------------------
	//Ecouteur de l'evenement fermeture de la fenetre
	//--------------------------------------------------------------------------
	
	private class EcouteWindowClosing extends InternalFrameAdapter
	{
		@Override
		public void internalFrameClosing(InternalFrameEvent e) {
			
			System.out.println("Contacts modifies :\n" + modeleTable.getListeVersements('M'));
			System.out.println("\n\nContacts inseres :\n" + modeleTable.getListeVersements('I'));
			System.out.println("\n\nContacts supprimes :\n" + modeleTable.getListeVersementsSupprimes());
				
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == supprimer ){

			modeleTable.supprimer(table.getSelectedRows());
			restaurer.setEnabled(true);
			
			validate();
			revalidate();
			repaint();
			
		} else if (e.getSource() == restaurer ) {
			
			modeleTable.restaurer();
			restaurer.setEnabled(false);

			validate();
			revalidate();
			repaint();
		}
	}
}