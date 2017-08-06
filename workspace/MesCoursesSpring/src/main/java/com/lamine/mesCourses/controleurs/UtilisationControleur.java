package com.lamine.mesCourses.controleurs;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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
import com.lamine.mesCourses.entite.Utilisation;
import com.lamine.mesCourses.metier.interfaces.IUtilisationMetier;

@Controller
@RequestMapping(value="/utilisation")
public class UtilisationControleur implements HandlerExceptionResolver {
	@Autowired
	private IUtilisationMetier utilisationMetier;
	//Message d'erreur
	private ModelAndView messageErr = new ModelAndView();

	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("utilisation", new Utilisation());
		model.addAttribute("utilisations", utilisationMetier.toutAfficher());
		return ("utilisation");
	}

	@RequestMapping(value="/enregistrerUtilisation")
	public String enregistrerUtilisation(@Valid Utilisation utilisation, BindingResult bindingResult, Model model, MultipartFile file) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("utilisations", utilisationMetier.toutAfficher());
			return("utilisation");
		}
		if (utilisation != null) {
			if (!file.isEmpty()) {
				try {
					BufferedImage bImg = ImageIO.read(file.getInputStream());
					utilisation.setPhoto(file.getBytes());
					if ("".equalsIgnoreCase(utilisation.getNomPhoto())) {
						utilisation.setNomPhoto(file.getOriginalFilename());
					}
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					System.out.println("Utilisation---> ligne 51");
				}
			}
			if (utilisation.getIdUse() != null ) {
				if (file.isEmpty()) {
					Utilisation u = utilisationMetier.afficher(utilisation.getIdUse());
					utilisation.setPhoto(u.getPhoto());
				}
				utilisationMetier.modifier(utilisation);
			} else {
				utilisationMetier.creer(utilisation);
			}
		}
		model.addAttribute("utilisation", new Utilisation());
		model.addAttribute("utilisations", utilisationMetier.toutAfficher());
		return "utilisation";
	}

	@RequestMapping(value="/modifierUtilisation")
	public String modifierUtilisation(Integer idUse, Model model) {		
		Utilisation u = new Utilisation();
		if (idUse != null) {
			//Je cherche si l'idUse existe dans la base de données
			for (Utilisation use: utilisationMetier.toutAfficher()) {
				if (use.getIdUse() == idUse) {
					u = utilisationMetier.afficher(idUse);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("utilisation", u);
		model.addAttribute("utilisations", utilisationMetier.toutAfficher());
		return "utilisation";
	}

	@RequestMapping(value="/supprimerUtilisation")
	public String supprimerUtilisation(Integer idUse, Model model) {
		if (idUse != null) {
			//Je cherche si l'idUse existe dans la base de données
			for (Utilisation use: utilisationMetier.toutAfficher()) {
				if (use.getIdUse() == idUse) {
					utilisationMetier.supprimer(idUse);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("utilisation", new Utilisation());
		model.addAttribute("utilisations", utilisationMetier.toutAfficher());
		return "utilisation";
	}

	@RequestMapping(value="photoUtilisation",produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoUtilisation(Integer idUse) {
		if (idUse != null) {
			Utilisation u = utilisationMetier.afficher(idUse);
			if (u.getPhoto() != null) {
				try {
					return IOUtils.toByteArray(new ByteArrayInputStream(u.getPhoto()));
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					return null;
				}
			}
		}
		messageErr.addObject("exeption", "idUse isNull");
		return null;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
		messageErr.addObject("exeption", ex.getMessage());
		messageErr.setViewName("utilisation");
		return messageErr;
	}
}