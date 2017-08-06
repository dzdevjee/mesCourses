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
import com.lamine.mesCourses.entite.Nature;
import com.lamine.mesCourses.metier.interfaces.INatureMetier;

@Controller
@RequestMapping(value="/nature")
public class NatureControleur implements HandlerExceptionResolver {
	@Autowired
	private INatureMetier natureMetier;
	//Message d'erreur
	private ModelAndView messageErr = new ModelAndView();

	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("nature", new Nature());
		model.addAttribute("natures", natureMetier.toutAfficher());
		return "nature";
	}

	@RequestMapping(value="/enregistrerNature")
	public String enregistrerNature(@Valid Nature nature, BindingResult bindingResult, Model model, MultipartFile file) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("natures", natureMetier.toutAfficher());
			return("nature");
		}
		if (nature != null) {
			if (!file.isEmpty()) {
				try {
					BufferedImage bImg = ImageIO.read(file.getInputStream());
					nature.setPhoto(file.getBytes());
					if ("".equalsIgnoreCase(nature.getNomPhoto())) {
						nature.setNomPhoto(file.getOriginalFilename());
					}
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					System.out.println("Nature---> ligne 51");
				}
			}
			if (nature.getIdNat() != null ) {
				if (file.isEmpty()) {
					Nature n = natureMetier.afficher(nature.getIdNat());
					nature.setPhoto(n.getPhoto());
				}
				natureMetier.modifier(nature);
			} else {
				natureMetier.creer(nature);
			}
		}
		model.addAttribute("nature", new Nature());
		model.addAttribute("natures", natureMetier.toutAfficher());
		return "nature";
	}

	@RequestMapping(value="/modifierNature")
	public String modifierNature(Integer idNat, Model model) {		
		Nature n = new Nature();
		if (idNat != null) {
			//Je cherche si l'idNat existe dans la base de données
			for (Nature nat: natureMetier.toutAfficher()) {
				if (nat.getIdNat() == idNat) {
					n = natureMetier.afficher(idNat);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("nature", n);
		model.addAttribute("natures", natureMetier.toutAfficher());
		return "nature";
	}

	@RequestMapping(value="/supprimerNature")
	public String supprimerNature(Integer idNat, Model model) {
		if (idNat != null) {
			//Je cherche si l'idNat existe dans la base de données
			for (Nature nat: natureMetier.toutAfficher()) {
				if (nat.getIdNat() == idNat) {
					natureMetier.supprimer(idNat);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("nature", new Nature());
		model.addAttribute("natures", natureMetier.toutAfficher());
		return "nature";
	}

	@RequestMapping(value="photoNature",produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoNature(Integer idNat) {
		if (idNat != null) {
			Nature n = natureMetier.afficher(idNat);
			if (n.getPhoto() != null) {
				try {
					return IOUtils.toByteArray(new ByteArrayInputStream(n.getPhoto()));
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					return null;
				}
			}
		}
		messageErr.addObject("exeption", "IdNat isNull");
		return null;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
		messageErr.addObject("exeption", ex.getMessage());
		messageErr.setViewName("nature");
		return messageErr;
	}
}