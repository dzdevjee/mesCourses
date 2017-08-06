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
import com.lamine.mesCourses.entite.TypeProduit;
import com.lamine.mesCourses.metier.interfaces.ITypeProduitMetier;

@Controller
@RequestMapping(value="/typeProduit")
public class TypeProduitControleur implements HandlerExceptionResolver {
	@Autowired
	private ITypeProduitMetier typeProduitMetier;
	//Message d'erreur
	private ModelAndView messageErr = new ModelAndView();

	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("typeProduit", new TypeProduit());
		model.addAttribute("typesProduit", typeProduitMetier.toutAfficher());
		return "typeProduit";
	}

	@RequestMapping(value="/enregistrerTypeProduit")
	public String enregistrerTypeProduit(@Valid TypeProduit typeProduit, BindingResult bindingResult, Model model, MultipartFile file) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("typesProduit", typeProduitMetier.toutAfficher());
			return("typeProduit");
		}
		if (typeProduit != null) {
			if (!file.isEmpty()) {
				try {
					BufferedImage bImg = ImageIO.read(file.getInputStream());
					typeProduit.setPhoto(file.getBytes());
					if ("".equalsIgnoreCase(typeProduit.getNomPhoto())) {
						typeProduit.setNomPhoto(file.getOriginalFilename());
					}
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					System.out.println("TypeProduit ---> ligne 51");
				}
			}
			if(typeProduit.getIdTypeProd() != null ) {
				if (file.isEmpty()) {
					TypeProduit tp = typeProduitMetier.afficher(typeProduit.getIdTypeProd());
					typeProduit.setPhoto(tp.getPhoto());
				}
				typeProduitMetier.modifier(typeProduit);
			} else {
				typeProduitMetier.creer(typeProduit);
			}
		}
		model.addAttribute("typeProduit", new TypeProduit());
		model.addAttribute("typesProduit", typeProduitMetier.toutAfficher());
		return "typeProduit";
	}

	@RequestMapping(value="/modifierTypeProduit")
	public String modifierTypeProduit(Integer idTypeProd, Model model) {
		TypeProduit tp = new TypeProduit();
		if (idTypeProd != null) {
			//Je cherche si l'idTypeProd existe dans la base de données
			for (TypeProduit typeProd: typeProduitMetier.toutAfficher()) {
				if (typeProd.getIdTypeProd() == idTypeProd) {
					tp = typeProduitMetier.afficher(idTypeProd);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("typeProduit", tp);
		model.addAttribute("typesProduit", typeProduitMetier.toutAfficher());
		return "typeProduit";
	}

	@RequestMapping(value="/supprimerTypeProduit")
	public String supprimerTypeProduit(Integer idTypeProd, Model model) {		
		if (idTypeProd != null) {
			//Je cherche si l'idMarq existe dans la base de données
			for (TypeProduit typeProd: typeProduitMetier.toutAfficher()) {
				if (typeProd.getIdTypeProd() == idTypeProd) {
					typeProduitMetier.supprimer(idTypeProd);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("typeProduit", new TypeProduit());
		model.addAttribute("typesProduit", typeProduitMetier.toutAfficher());
		return "typeProduit";
	}

	@RequestMapping(value="photoTypeProduit",produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoTypeProduit(Integer idTypeProd) {
		if (idTypeProd != null) {
			TypeProduit tp = typeProduitMetier.afficher(idTypeProd);
			if (tp.getPhoto() != null) {
				try {
					return IOUtils.toByteArray(new ByteArrayInputStream(tp.getPhoto()));
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					return null;
				}
			}
		}
		messageErr.addObject("exeption", "IdTypeProd isNull");
		return null;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
		messageErr.addObject("exeption", ex.getMessage());
		messageErr.setViewName("typeProduit");
		return messageErr;
	}
}