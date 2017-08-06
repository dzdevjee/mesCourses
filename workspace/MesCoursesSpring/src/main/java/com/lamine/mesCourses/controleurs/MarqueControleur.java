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
import com.lamine.mesCourses.entite.Marque;
import com.lamine.mesCourses.metier.interfaces.IMarqueMetier;

@Controller
@RequestMapping(value="/marque")
public class MarqueControleur implements HandlerExceptionResolver {
	@Autowired
	private IMarqueMetier marqueMetier;
	//Message d'erreur
	private ModelAndView messageErr = new ModelAndView();

	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("marque", new Marque());
		model.addAttribute("marques", marqueMetier.toutAfficher());
		return "marque";
	}

	@RequestMapping(value="/enregistrerMarque")
	public String enregistrerMarque(@Valid Marque marque, BindingResult bindingResult, Model model, MultipartFile file) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("marques", marqueMetier.toutAfficher());
			return("marque");
		}
		if (marque != null) {
			if (!file.isEmpty()) {
				try {
					BufferedImage bImg = ImageIO.read(file.getInputStream());
					marque.setPhoto(file.getBytes());
					if ("".equalsIgnoreCase(marque.getNomPhoto())) {
						marque.setNomPhoto(file.getOriginalFilename());
					}
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					System.out.println("Marque ---> ligne 51");
				}
			}
			if(marque.getIdMarq() != null ) {
				if (file.isEmpty()) {
					Marque m = marqueMetier.afficher(marque.getIdMarq());
					marque.setPhoto(m.getPhoto());
				}
				marqueMetier.modifier(marque);
			} else {
				marqueMetier.creer(marque);
			}
		}
		model.addAttribute("marque", new Marque());
		model.addAttribute("marques", marqueMetier.toutAfficher());
		return "marque";
	}

	@RequestMapping(value="/modifierMarque")
	public String modifierMarque(Integer idMarq, Model model) {
		Marque m = new Marque();
		if (idMarq != null) {
			//Je cherche si l'idMarq existe dans la base de données
			for (Marque marq: marqueMetier.toutAfficher()) {
				if (marq.getIdMarq() == idMarq) {
					m = marqueMetier.afficher(idMarq);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("marque", m);
		model.addAttribute("marques", marqueMetier.toutAfficher());
		return "marque";
	}

	@RequestMapping(value="/supprimerMarque")
	public String supprimerMarque(Integer idMarq, Model model) {		
		if (idMarq != null) {
			//Je cherche si l'idMarq existe dans la base de données
			for (Marque marq: marqueMetier.toutAfficher()) {
				if (marq.getIdMarq() == idMarq) {
					marqueMetier.supprimer(idMarq);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("marque", new Marque());
		model.addAttribute("marques", marqueMetier.toutAfficher());
		return "marque";
	}

	@RequestMapping(value="photoMarque",produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoMarque(Integer idMarq) {
		if (idMarq != null) {
			Marque m = marqueMetier.afficher(idMarq);
			if (m.getPhoto() != null) {
				try {
					return IOUtils.toByteArray(new ByteArrayInputStream(m.getPhoto()));
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					return null;
				}
			}
		}
		messageErr.addObject("exeption", "IdMarq isNull");
		return null;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
		messageErr.addObject("exeption", ex.getMessage());
		messageErr.setViewName("marque");
		return messageErr;
	}
}