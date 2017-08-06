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
import com.lamine.mesCourses.entite.Categorie;
import com.lamine.mesCourses.metier.interfaces.ICategorieMetier;

@Controller
@RequestMapping(value="/categorie")
public class CategorieControleur implements HandlerExceptionResolver {
	@Autowired
	private ICategorieMetier categorieMetier;
	//Message d'erreur
	private ModelAndView messageErr = new ModelAndView();
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", categorieMetier.toutAfficher());
		return "categorie";
	}

	@RequestMapping(value="/enregistrerCategorie")
	public String enregistrerCategorie(@Valid Categorie categorie, BindingResult bindingResult, Model model, MultipartFile file) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", categorieMetier.toutAfficher());
			return("categorie");
		}
		if (categorie != null) {
			if (!file.isEmpty()) {
				try {
					BufferedImage bImg = ImageIO.read(file.getInputStream());
					categorie.setPhoto(file.getBytes());
					if ("".equalsIgnoreCase(categorie.getNomPhoto())) {
						categorie.setNomPhoto(file.getOriginalFilename());
					}
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					System.out.println("Categorie---> ligne 51");
				}
			}
			if (categorie.getIdCat() != null ) {
				if (file.isEmpty()) {
					Categorie c = categorieMetier.afficher(categorie.getIdCat());
					categorie.setPhoto(c.getPhoto());
				}
				categorieMetier.modifier(categorie);
			} else {
				categorieMetier.creer(categorie);
			}
		}
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", categorieMetier.toutAfficher());
		return "categorie";
	}

	@RequestMapping(value="/modifierCategorie")
	public String modifierCategorie(Integer idCat, Model model) {		
		Categorie c = new Categorie();
		if (idCat != null) {
			//Je cherche si l'idCat existe dans la base de données
			for (Categorie cat: categorieMetier.toutAfficher()) {
				if (cat.getIdCat() == idCat) {
					c = categorieMetier.afficher(idCat);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("categorie", c);
		model.addAttribute("categories", categorieMetier.toutAfficher());
		return "categorie";
	}

	@RequestMapping(value="/supprimerCategorie")
	public String supprimerCategorie(Integer idCat, Model model) {
		if (idCat != null) {
			//Je cherche si l'idCat existe dans la base de données
			for (Categorie cat: categorieMetier.toutAfficher()) {
				if (cat.getIdCat() == idCat) {
					categorieMetier.supprimer(idCat);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", categorieMetier.toutAfficher());
		return "categorie";
	}

	@RequestMapping(value="photoCategorie",produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoCategorie(Integer idCat) {
		if (idCat != null) {
			Categorie c = categorieMetier.afficher(idCat);
			if (c.getPhoto() != null) {
				try {
					return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					return null;
				}
			}
		}
		messageErr.addObject("exeption", "IdCat isNull");
		return null;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
		messageErr.addObject("exeption", ex.getMessage());
		messageErr.setViewName("categorie");
		return messageErr;
	}
}