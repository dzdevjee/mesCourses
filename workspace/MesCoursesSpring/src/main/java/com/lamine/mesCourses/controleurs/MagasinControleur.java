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
import com.lamine.mesCourses.entite.Magasin;
import com.lamine.mesCourses.metier.interfaces.IEnseigneMetier;
import com.lamine.mesCourses.metier.interfaces.IMagasinMetier;
import com.lamine.mesCourses.metier.interfaces.ITypeMagasinMetier;

@Controller
@RequestMapping(value="/magasin")
public class MagasinControleur implements HandlerExceptionResolver {
	@Autowired
	private IMagasinMetier magasinMetier;
	@Autowired
	private IEnseigneMetier enseigneMetier;
	@Autowired
	private ITypeMagasinMetier typeMagasinMetier;
	//Message d'erreur
	private ModelAndView messageErr = new ModelAndView();

	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("magasin", new Magasin());
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		model.addAttribute("typesMagasin", typeMagasinMetier.toutAfficher());
		model.addAttribute("magasins", magasinMetier.toutAfficher());
		return "magasin";
	}

	@RequestMapping(value="/enregistrerMagasin")
	public String enregistrerMagasin(@Valid Magasin magasin, BindingResult bindingResult, Model model, MultipartFile file) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("enseignes", enseigneMetier.toutAfficher());
			model.addAttribute("typesMagasin", typeMagasinMetier.toutAfficher());
			model.addAttribute("magasins", magasinMetier.toutAfficher());
			return "magasin";
		}
		if (magasin != null) {
			if (!file.isEmpty()) {
				try {
					BufferedImage bImg = ImageIO.read(file.getInputStream());
					magasin.setPhoto(file.getBytes());
					if ("".equalsIgnoreCase(magasin.getNomPhoto())) {
						magasin.setNomPhoto(file.getOriginalFilename());
					}
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					System.out.println("Magasin---> ligne 63");
				}
			}
			if(magasin.getIdMag() != null ) {
				if (file.isEmpty()) {
					Magasin m = magasinMetier.afficher(magasin.getIdMag());
					magasin.setPhoto(m.getPhoto());
				}
				System.out.println(magasin.getIdMag().toString());
				magasinMetier.modifier(magasin);
			} else {
				magasinMetier.creer(magasin);
				System.out.println(magasin.getAdrMag().toString());
				System.out.println(magasin.getHorMag().toString());
				System.out.println(magasin.getNomPhoto().toString());

				System.out.println(magasin.getEnseigne().getClass());
				System.out.println(magasin.getEnseigne().getNomEns());
				System.out.println(magasin.getEnseigne().getIdEns());
				
				System.out.println(magasin.getTypeMagasin().getClass());
				System.out.println(magasin.getTypeMagasin().getNomTypeMag());
				System.out.println(magasin.getTypeMagasin().getIdTypeMag());
			}
		}
		model.addAttribute("magasin", new Magasin());
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		model.addAttribute("typesMagasin", typeMagasinMetier.toutAfficher());
		model.addAttribute("magasins", magasinMetier.toutAfficher());
		return "magasin";
	}

	@RequestMapping(value="/modifierMagasin")
	public String modifierMagasin(Integer idMag, Model model) {
		Magasin m = new Magasin();
		if (idMag != null) {
			//Je cherche si l'idMag existe dans la base de données
			for (Magasin mag: magasinMetier.toutAfficher()) {
				if (mag.getIdMag() == idMag) {
					m = magasinMetier.afficher(idMag);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("magasin", m);
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		model.addAttribute("typesMagasin", typeMagasinMetier.toutAfficher());
		model.addAttribute("magasins", magasinMetier.toutAfficher());
		return "magasin";
	}

	@RequestMapping(value="/supprimerMagasin")
	public String supprimerMagasin(Integer idMag, Model model) {		
		if (idMag != null) {
			//Je cherche si l'idMag existe dans la base de données
			for (Magasin mag: magasinMetier.toutAfficher()) {
				if (mag.getIdMag() == idMag) {
					magasinMetier.supprimer(idMag);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("magasin", new Magasin());
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		model.addAttribute("typesMagasin", typeMagasinMetier.toutAfficher());
		model.addAttribute("magasins", magasinMetier.toutAfficher());
		return "magasin";
	}

	@RequestMapping(value="photoMagasin",produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoMagasin(Integer idMag)  throws IOException {
		if (idMag != null) {
			Magasin m = magasinMetier.afficher(idMag);
			if (m.getPhoto() != null) {
				try {
					return IOUtils.toByteArray(new ByteArrayInputStream(m.getPhoto()));
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
		ModelAndView mv = new ModelAndView();
		mv.addObject("exeption", ex.getMessage());
		mv.setViewName("magasin");
		return mv;
	}
}