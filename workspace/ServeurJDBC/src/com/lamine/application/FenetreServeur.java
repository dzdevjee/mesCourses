package com.lamine.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FenetreServeur extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel panneauFond;
    private JPanel panneauNord;
    private JPanel panneauCentre;
    private JPanel panneauSud;
    
    private JLabel titre;
    private JTextArea message;
    private JScrollPane defileur;
    private JButton etat;
    private int statutBoutonEtat  = 0; //1 = on, 0=off

    public FenetreServeur(String titre) {
        super(titre);
        addWindowListener(new EcouteFenetre());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //panneauFond
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());

        //panneauNord --- titre
        this.titre = new JLabel(titre.toUpperCase());
        this.titre.setFont(new Font("Serif", Font.PLAIN, 32));
        this.titre.setForeground(Color.LIGHT_GRAY);
        
        panneauNord = new JPanel();
        panneauNord.setBackground(new Color(25, 50, 75));
        panneauNord.add(this.titre);

        //panneauCentre --- message
        message = new JTextArea();
        message.setEditable(false);
        message.setFont(new Font("Courier new", Font.PLAIN, 12));
        
        defileur = new JScrollPane(message);
        defileur.setPreferredSize(new Dimension(450, 150));
        
        panneauCentre = new JPanel();
        panneauCentre.setLayout(new BorderLayout());
        panneauCentre.setBackground(Color.WHITE);
        panneauCentre.add(defileur);

        //panneauSud --- etat
        etat = new JButton("ON");
        etat.setForeground(Color.GREEN);
        etat.addActionListener(this);

        panneauSud = new JPanel();
        panneauSud.setBackground(new Color(25, 50, 75));
        panneauSud.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panneauSud.add(etat);

        panneauFond.add(panneauNord, BorderLayout.NORTH);
        panneauFond.add(panneauCentre, BorderLayout.CENTER);
        panneauFond.add(panneauSud, BorderLayout.SOUTH);

        getContentPane().add(panneauFond);
        pack();
        setVisible(true);
    }

    public void setMessage(String message){
        this.message.append(message + "\n");
        this.message.setCaretPosition(this.message.getText().length());
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == etat ) {
            //off button clicked
            if(statutBoutonEtat == 0) {
                //logic here
                statutBoutonEtat = 1;
                etat.setText("OFF");
                etat.setForeground(Color.RED);
                ControleurServeur.demarrerServeur();
                setMessage("Demarrage du serveur JDBC...\n");

            } else if(statutBoutonEtat == 1) {
                //logic here
                statutBoutonEtat = 0;
                etat.setText("ON");
                etat.setForeground(Color.GREEN);
                ControleurServeur.arreterServeur();
                setMessage("Arret du serveur JDBC...\n");
            }
        }
    }
    
    private class EcouteFenetre extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            if (statutBoutonEtat == 0) {
                ControleurServeur.arreterSysteme();
            } else if(statutBoutonEtat == 1) {
                setMessage("Veuillez arreter le serveur JDBC avant de quiter...");
            }
        }
    }
}