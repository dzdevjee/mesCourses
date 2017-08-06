package com.lamine.mesCourses.controleurs;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.lamine.mesCourses.entite.Enseigne;
import com.lamine.mesCourses.metier.interfaces.IEnseigneMetier;

@Controller
@RequestMapping(value="/enseigne")
public class EnseigneControleur implements HandlerExceptionResolver {
	@Autowired
	private IEnseigneMetier enseigneMetier;
	//Message d'erreur
	private ModelAndView messageErr = new ModelAndView();

	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("enseigne", new Enseigne());
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		return "enseigne";
	}

	@RequestMapping(value="/enregistrerEnseigne")
	public String enregistrerEnseigne(@Valid Enseigne enseigne, BindingResult bindingResult, Model model, MultipartFile file) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("enseigne", enseigneMetier.toutAfficher());
			return("enseigne");
		}
		if (enseigne != null) {
			if (!file.isEmpty()) {
				try {
					BufferedImage bImg = ImageIO.read(file.getInputStream());
					enseigne.setPhoto(file.getBytes());
					if ("".equalsIgnoreCase(enseigne.getNomPhoto())) {
						enseigne.setNomPhoto(file.getOriginalFilename());
					}
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					System.out.println("Categorie---> ligne 51");
				}
			}
			if(enseigne.getIdEns() != null ) {
				if (file.isEmpty()) {
					Enseigne e = enseigneMetier.afficher(enseigne.getIdEns());
					enseigne.setPhoto(e.getPhoto());
				}
				enseigneMetier.modifier(enseigne);
			} else {
				enseigneMetier.creer(enseigne);
			}
		}
		model.addAttribute("enseigne", new Enseigne());
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		return "enseigne";
	}

	@RequestMapping(value="/modifierEnseigne")
	public String modifierEnseigne(Integer idEns, Model model) {		
		Enseigne e = enseigneMetier.afficher(idEns);
		if (idEns != null) {
			//Je cherche si l'idEns existe dans la base de données
			for (Enseigne ens: enseigneMetier.toutAfficher()) {
				if (ens.getIdEns() == idEns) {
					e = enseigneMetier.afficher(idEns);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("enseigne", e);
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		return "enseigne";
	}

	@RequestMapping(value="/supprimerEnseigne")
	public String supprimerEnseigne(Integer idEns, Model model) {		
		if (idEns != null) {
			//Je cherche si l'idEns existe dans la base de données
			for (Enseigne ens: enseigneMetier.toutAfficher()) {
				if (ens.getIdEns() == idEns) {
					enseigneMetier.supprimer(idEns);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("enseigne", new Enseigne());
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		return "enseigne";
	}

	@RequestMapping(value="photoEnseigne",produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoEnseigne(Integer idEns) {
		if (idEns != null) {
			Enseigne e = enseigneMetier.afficher(idEns);
			if (e.getPhoto() != null) {
				try {
					return IOUtils.toByteArray(new ByteArrayInputStream(e.getPhoto()));
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					return null;
				}
			}
		}
		messageErr.addObject("exeption", "IdEns isNull");
		return null;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
		messageErr.addObject("exeption", ex.getMessage());
		messageErr.setViewName("categorie");
		return messageErr;
	}
}