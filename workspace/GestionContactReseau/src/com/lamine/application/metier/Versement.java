package com.lamine.application.metier;

import java.math.BigDecimal;
import java.util.Date;

public class Versement {	
	private Integer numero;
	private Date date;
	private BigDecimal montant;
	private Integer numeroContact;
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}
	
	public void setNumeroContact(Integer numeroContact) {
		this.numeroContact = numeroContact;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public Date getDate() {
		return date;
	}
	
	public BigDecimal getMontant() {
		return montant;
	}
	
	public Integer getNumeroContact() {
		return numeroContact;
	}
	
	@Override
	public String toString() {
		String retour;
	
		retour =  "Numero              : " + numero + "\n";
		retour += "Date                : " + date + "\n";
		retour += "Montant             : " + montant + "\n";
		retour += "Numero contact      : " + numeroContact + "\n";
		
		return retour;
	}
}