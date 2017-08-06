package com.lamine.application.fenetre;

import com.lamine.application.ClientJDBC;
import com.lamine.application.metier.Contact;
import com.lamine.application.modeleTable.ModeleTableContact;
import utilitairesMG.divers.Colonne;
import utilitairesMG.graphique.table.ModeleColonneTable;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class FenetreInterneContact extends JInternalFrame implements ActionListener {

	private JPanel panneauInterne;

	private JTable table;
	private ModeleTableContact modeleTable;
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
	
	public FenetreInterneContact(String titre, Vector<Contact> listeContacts, Vector<Colonne> listeColonnes) {
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
		//Creation de l'objet JPanel :
		//--------------------------------------------------------------------------
		panneauInterne = new JPanel();
		panneauInterne.setLayout(new BorderLayout());
		panneauInterne.setPreferredSize(new Dimension(1000, 500));

		//--------------------------------------------------------------------------
		//Cr�ation de l'objet JTable :
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
		modeleTable = new ModeleTableContact(listeContacts, listeColonnes);
		modeleColonne = new ModeleColonneTable(listeColonnes, tailleM);

		//--------------------------------------------------------------------------
		//Changement de l'editeur de la colonne 5 (CodeSecteur)
		//--------------------------------------------------------------------------
		
		JComboBox combo = new JComboBox();
		combo.addItem(null);
		for (int i = 1; i <= 4; i++) {
			combo.addItem(i);
		}

		DefaultCellEditor editeur = new DefaultCellEditor(combo);
		editeur.setClickCountToStart(2);

		modeleColonne.setEditeurColonne(5, editeur);

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
	
	private class EcouteWindowClosing extends InternalFrameAdapter {
		@Override
		public void internalFrameClosing(InternalFrameEvent e) {
			
			System.out.println("Contacts modifies :\n" + modeleTable.getListeContacts('M'));
			System.out.println("\n\nContacts inseres :\n" + modeleTable.getListeContacts('I'));
			System.out.println("\n\nContacts supprimes :\n" + modeleTable.getListeContactsSupprimes());
			
			ClientJDBC.majContact(modeleTable.getListeContacts('M'), modeleTable.getListeContacts('I'), modeleTable.getListeContactsSupprimes());
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