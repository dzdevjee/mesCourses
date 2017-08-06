package com.lamine.application;

import java.net.*;
import com.lamine.utilitaire.BaseDeDonnees;
import java.io.*;

public class ServeurJDBC extends Thread {
    private ServerSocket serveur;
    private static BaseDeDonnees baseDeDonnees;
    private boolean actif;

    public ServeurJDBC(BaseDeDonnees baseDeDonnees) {
    	ServeurJDBC.baseDeDonnees = baseDeDonnees;

        try {
            serveur = new ServerSocket(6226);
            serveur.setSoTimeout(10);
            actif = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Socket socketClient;
        Thread threadClient;

        while(actif) {
            try {
                socketClient = serveur.accept();

                threadClient = new ThreadClient(socketClient);
                threadClient.start();
                ControleurServeur.setMessage("Connexion du client reussie");
            } catch (SocketTimeoutException ste) {
                if(interrupted()) {
                    actif = false;
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        try {
            serveur.close();
            ControleurServeur.setMessage("Arret du serveur reussi");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}