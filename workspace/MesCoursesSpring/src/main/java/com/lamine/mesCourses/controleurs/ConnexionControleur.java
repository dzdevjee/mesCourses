package com.lamine.mesCourses.controleurs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConnexionControleur {
	@RequestMapping(value="/connexion")
	public String connexion() {
		return "connexion";
	}

	@RequestMapping(value="/deconnexion")
	public String deconnexion() {
		return "deconnexion";
	}
}