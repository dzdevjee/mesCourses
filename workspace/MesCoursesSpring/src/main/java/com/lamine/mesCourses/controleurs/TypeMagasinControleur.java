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
import com.lamine.mesCourses.entite.TypeMagasin;
import com.lamine.mesCourses.metier.interfaces.ITypeMagasinMetier;

@Controller
@RequestMapping(value="/typeMagasin")
public class TypeMagasinControleur implements HandlerExceptionResolver {
	@Autowired
	private ITypeMagasinMetier typeMagasinMetier;
	//Message d'erreur
	private ModelAndView messageErr = new ModelAndView();

	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("typeMagasin", new TypeMagasin());
		model.addAttribute("typesMagasin", typeMagasinMetier.toutAfficher());
		return "typeMagasin";
	}
	
	@RequestMapping(value="/enregistrerTypeMagasin")
	public String enregistrerTypeMagasin(@Valid TypeMagasin typeMagasin, BindingResult bindingResult, Model model, MultipartFile file) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("typesMagasin", typeMagasinMetier.toutAfficher());
			return("typeMagasin");
		}
		if (typeMagasin != null) {
			if (!file.isEmpty()) {
				try {
					BufferedImage bImg = ImageIO.read(file.getInputStream());
					typeMagasin.setPhoto(file.getBytes());
					if ("".equalsIgnoreCase(typeMagasin.getNomPhoto())) {
						typeMagasin.setNomPhoto(file.getOriginalFilename());
					}
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					System.out.println("TypeMagasin ---> ligne 51");
				}
			}
			if(typeMagasin.getIdTypeMag() != null ) {
				if (file.isEmpty()) {
					TypeMagasin tm = typeMagasinMetier.afficher(typeMagasin.getIdTypeMag());
					typeMagasin.setPhoto(tm.getPhoto());
				}
				typeMagasinMetier.modifier(typeMagasin);
			} else {
				typeMagasinMetier.creer(typeMagasin);
			}
		}
		model.addAttribute("typeMagasin", new TypeMagasin());
		model.addAttribute("typesMagasin", typeMagasinMetier.toutAfficher());
		return "typeMagasin";
	}

	@RequestMapping(value="/modifierTypeMagasin")
	public String modifierTypeMagasin(Integer idTypeMag, Model model) throws IOException {		
		TypeMagasin tm = new TypeMagasin();
		if (idTypeMag != null) {
			//Je cherche si l'idTypeMag existe dans la base de données
			for (TypeMagasin typeMag:typeMagasinMetier.toutAfficher()) {
				if (typeMag.getIdTypeMag() == idTypeMag) {
					tm = typeMagasinMetier.afficher(idTypeMag);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("typeMagasin", tm);
		model.addAttribute("typesMagasin", typeMagasinMetier.toutAfficher());
		return "typeMagasin";
	}

	@RequestMapping(value="/supprimerTypeMagasin")
	public String supprimerTypeMagasin(Integer idTypeMag, Model model) {		
		if (idTypeMag != null) {
			//Je cherche si l'idTypeMag existe dans la base de données
			for (TypeMagasin typeMag:typeMagasinMetier.toutAfficher()) {
				if (typeMag.getIdTypeMag() == idTypeMag) {
					typeMagasinMetier.supprimer(idTypeMag);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("typeMagasin", new TypeMagasin());
		model.addAttribute("typesMagasin", typeMagasinMetier.toutAfficher());
		return "typeMagasin";
	}

	@RequestMapping(value="photoTypeMagasin",produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoTypeMagasin(Integer idTypeMag) {
		if (idTypeMag != null) {
			TypeMagasin tm = typeMagasinMetier.afficher(idTypeMag);
			if (tm.getPhoto() != null) {
				try {
					return IOUtils.toByteArray(new ByteArrayInputStream(tm.getPhoto()));
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					return null;
				}
			}
		}
		messageErr.addObject("exeption", "IdTypeMag isNull");
		return null;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
		messageErr.addObject("exeption", ex.getMessage());
		messageErr.setViewName("typeMagasin");
		return messageErr;
	}
}