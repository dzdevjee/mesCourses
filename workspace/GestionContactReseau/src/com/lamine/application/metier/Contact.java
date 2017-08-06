package com.lamine.application.metier;

import java.util.*;

public class Contact {
	private Integer numero;
	private String nom;
	private String adresse;
	private String codePostal;
	private String ville;
	private Integer codeSecteur;
	
	private Secteur secteur;
	private Vector<Versement> listeVersements;
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public void setNom(String nom) {
      this.nom = nom;
   }

   public void setAdresse(String adresse) {
	   this.adresse = adresse;
   }

   public void setCodePostal(String codePostal) {
	   this.codePostal = codePostal;
   }

   public void setVille(String ville) {
	   this.ville = ville;
   }

   public void setCodeSecteur(Integer codeSecteur) {
	   this.codeSecteur = codeSecteur;
   }
   
   public void setSecteur(Secteur secteur) {
	   this.secteur = secteur;
	   
	   if (secteur != null) {
		   this.codeSecteur = secteur.getCode();
	   } else {
		   this.codeSecteur = null;
	   }
   }
   
   public void setListeVersements(Vector<Versement> listeVersements) {
	   this.listeVersements = listeVersements;
   }
   
   public Integer getNumero() {
	   return numero;
   }

   public String getNom() {
	   return nom;
   }

   public String getAdresse() {
	   return adresse;
   }

   public String getCodePostal() {
	   return codePostal;
   }

   public String getVille() {
	   return ville;
   }

   public Integer getCodeSecteur() {
	   return codeSecteur;
   }
   
   public Secteur getSecteur() {
	   return secteur;
   }
   
   public Vector<Versement> getListeVersements() {
	   return listeVersements;
   }

   @Override
   public String toString() {
	   String retour;

	   retour =  "Numero              : " + numero + "\n";
	   retour += "Nom                 : " + nom + "\n";
	   retour += "Adresse             : " + adresse + "\n";
	   retour += "Code Postal         : " + codePostal + "\n";
	   retour += "Ville               : " + ville + "\n";
	   retour += "Code secteur        : " + codeSecteur + "\n\n";
	   
	   return retour;
   }
}