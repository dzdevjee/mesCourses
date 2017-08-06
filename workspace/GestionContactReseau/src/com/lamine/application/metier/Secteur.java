package com.lamine.application.metier;

import java.util.Vector;

public class Secteur {
	private Integer code;
	private String libelle;
	
	private Vector<Contact> listeContacts;

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setListeContacts(Vector<Contact> listeContacts) {
		this.listeContacts = listeContacts;
	}
	
	public Integer getCode() {
		return code;
	}

	public String getLibelle() {
		return libelle;
	}

	public Vector<Contact> getListeContacts() {
		return listeContacts;
	}

	@Override
	public String toString() {
		String retour;

		retour =  "Code              : " + code + "\n";
		retour += "Libelle           : " + libelle + "\n";
		
		return retour;
	}
}