package com.lamine.application;

import com.lamine.utilitaire.BaseDeDonnees;

public class ControleurServeur {
    private static FenetreServeur fenetre;
    private static ServeurJDBC serveur;
    private static BaseDeDonnees baseDeDonnees;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:2602/gestioncontacts?useSSL=false";
            String utilisateur = "root";
            String motDePasse = "khad";
            baseDeDonnees = new BaseDeDonnees(url, utilisateur, motDePasse);

            fenetre = new FenetreServeur("Serveur JDBC");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Erreur -->  Driver inconnu " + cnfe.getMessage());
        }
    }

    public static void setMessage(String message) {
        fenetre.setMessage(message + "\n");
    }

    public static void demarrerServeur() {
        serveur = new ServeurJDBC(baseDeDonnees);
        serveur.start();
    }

    public static void arreterServeur() {
        serveur.interrupt();
    }

    public static void arreterSysteme() {
        System.exit(0);
    }
}