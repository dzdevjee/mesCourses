package com.lamine.utilitaire;

import java.sql.*;
import utilitairesMG.jdbc.JeuResultat;

public class BaseDeDonnees {
    private Connection connexion;
    private String nomBase;
    private String url;
    private String user;
    private String password;

    public BaseDeDonnees(){
    }

    public BaseDeDonnees(String nomBase) {
        this.nomBase = nomBase;
    }

    public BaseDeDonnees(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public static void chargementDriver(String driver) throws ClassNotFoundException {
        Class.forName(driver);
    }
    
    public Connection getConnection() throws SQLException {
    	if((connexion == null) || (connexion.isClosed())){
            DriverManager.setLoginTimeout(10);
        	connexion = DriverManager.getConnection(nomBase);
        }
        return connexion;
    }
        
    public Connection getConnection(String url, String user, String password) throws SQLException {
        if((connexion == null) || (connexion.isClosed())){
            DriverManager.setLoginTimeout(10);
            connexion = DriverManager.getConnection(url, user, password);
        }
        return connexion;
    }

    public void setConnection(Connection connexion){
        this.connexion = connexion;
    }

    public void closeConnection() throws SQLException {
        if((connexion != null) && (!connexion.isClosed())){
            connexion.close();
        }
    }
	
    public JeuResultat executeQuery(String select) throws SQLException {
        Statement traitement;
        ResultSet resultats;
        JeuResultat jeuResultat;

        if(select.compareTo("") == 0) {
            throw new SQLException("Requete vide");
        }

        traitement = connexion.createStatement();

        try {
            resultats = traitement.executeQuery(select);

            try {
                jeuResultat = new JeuResultat(resultats);
                return jeuResultat;
            } catch (SQLException sqle) {
                throw new SQLException("Erreur creation JeuResultat : " + sqle.getMessage());
            } finally {
                resultats.close();
            }
        } finally {
            traitement.close();
        }
    }

    public int executeUpdate (String requete) throws SQLException{
        Statement traitement;
        int nbrLigne = 0;

        if(requete.compareTo("") == 0) {
            throw new SQLException("Requete vide");
        }

        traitement = connexion.createStatement();

        try {
            nbrLigne = traitement.executeUpdate(requete);
        } finally {
            traitement.close();
        }

        return nbrLigne;
    }
}