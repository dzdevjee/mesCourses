package com.lamine.mesCourses.controleurs;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
import com.lamine.mesCourses.entite.Produit;
import com.lamine.mesCourses.metier.interfaces.ICategorieMetier;
import com.lamine.mesCourses.metier.interfaces.IEnseigneMetier;
import com.lamine.mesCourses.metier.interfaces.IMarqueMetier;
import com.lamine.mesCourses.metier.interfaces.INatureMetier;
import com.lamine.mesCourses.metier.interfaces.IProduitMetier;
import com.lamine.mesCourses.metier.interfaces.ITypeProduitMetier;
import com.lamine.mesCourses.metier.interfaces.IUtilisationMetier;

@Controller
@RequestMapping(value="/produit")
public class ProduitControleur implements HandlerExceptionResolver {
	@Autowired
	private IProduitMetier produitMetier;
	@Autowired
	private ICategorieMetier categorieMetier;
	@Autowired
	private IEnseigneMetier enseigneMetier;
	@Autowired
	private IMarqueMetier marqueMetier;
	@Autowired
	private INatureMetier natureMetier;
	@Autowired
	private ITypeProduitMetier typeProduitMetier;
	@Autowired
	private IUtilisationMetier utilisationMetier;
	//Message d'erreur
	private ModelAndView messageErr = new ModelAndView();

	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", produitMetier.toutAfficher());
		model.addAttribute("categories", categorieMetier.toutAfficher());
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		model.addAttribute("marques", marqueMetier.toutAfficher());
		model.addAttribute("natures", natureMetier.toutAfficher());
		model.addAttribute("typesProduit", typeProduitMetier.toutAfficher());
		model.addAttribute("utilisations", utilisationMetier.toutAfficher());
		return "produit";
	}

	@RequestMapping(value="/enregistrerProduit")
	public String enregistrerProduit(@Valid Produit produit, BindingResult bindingResult, Model model, MultipartFile file) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("produits", produitMetier.toutAfficher());
			model.addAttribute("categories", categorieMetier.toutAfficher());
			model.addAttribute("enseignes", enseigneMetier.toutAfficher());
			model.addAttribute("marques", marqueMetier.toutAfficher());
			model.addAttribute("natures", natureMetier.toutAfficher());
			model.addAttribute("typesProduit", typeProduitMetier.toutAfficher());
			model.addAttribute("utilisations", utilisationMetier.toutAfficher());
			return "produit";
		}
		if (produit != null) {
			if (!file.isEmpty()) {
				try {
					BufferedImage bImg = ImageIO.read(file.getInputStream());
					produit.setPhoto(file.getBytes());
					if ("".equalsIgnoreCase(produit.getNomPhoto())) {
						produit.setNomPhoto(file.getOriginalFilename());
					}
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					System.out.println("produit---> ligne 81");
				}
			}
			if(produit.getIdProd() != null ) {
				if (file.isEmpty()) {
					Produit p = produitMetier.afficher(produit.getIdProd());
					produit.setPhoto(p.getPhoto());
				}
				produitMetier.modifier(produit);
			} else {
				produitMetier.creer(produit);
			}
		}
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", produitMetier.toutAfficher());
		model.addAttribute("categories", categorieMetier.toutAfficher());
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		model.addAttribute("marques", marqueMetier.toutAfficher());
		model.addAttribute("natures", natureMetier.toutAfficher());
		model.addAttribute("typesProduit", typeProduitMetier.toutAfficher());
		model.addAttribute("utilisations", utilisationMetier.toutAfficher());
		return "produit";
	}

	@RequestMapping(value="/modifierProduit")
	public String modifierProduit(Integer idProd, Model model) {
		Produit p = new Produit();
		if (idProd != null) {
			//Je cherche si l'idProd existe dans la base de données
			for (Produit prod:produitMetier.toutAfficher()) {
				if (prod.getIdProd() == idProd) {
					p = produitMetier.afficher(idProd);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("produit", p);
		model.addAttribute("produits", produitMetier.toutAfficher());
		model.addAttribute("categories", categorieMetier.toutAfficher());
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		model.addAttribute("marques", marqueMetier.toutAfficher());
		model.addAttribute("natures", natureMetier.toutAfficher());
		model.addAttribute("typesProduit", typeProduitMetier.toutAfficher());
		model.addAttribute("utilisations", utilisationMetier.toutAfficher());
		return "produit";
	}

	@RequestMapping(value="/supprimerProduit")
	public String supprimerProduit(Integer idProd, Model model) {
		if (idProd != null) {
			//Je cherche si l'idProd existe dans la base de données
			for (Produit prod:produitMetier.toutAfficher()) {
				if (prod.getIdProd() == idProd) {
					produitMetier.supprimer(idProd);
				} else {
					messageErr.addObject("exeption", "L'element d'existe pas!!");
				}
			}
		}
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", produitMetier.toutAfficher());
		model.addAttribute("categories", categorieMetier.toutAfficher());
		model.addAttribute("enseignes", enseigneMetier.toutAfficher());
		model.addAttribute("marques", marqueMetier.toutAfficher());
		model.addAttribute("natures", natureMetier.toutAfficher());
		model.addAttribute("typesProduit", typeProduitMetier.toutAfficher());
		model.addAttribute("utilisations", utilisationMetier.toutAfficher());
		return "produit";
	}

	@RequestMapping(value="photoProduit",produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoProduit(Integer idProd)  throws IOException {
		if (idProd != null) {
			Produit p = produitMetier.afficher(idProd);
			if (p.getPhoto() != null) {
				try {
					return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
				} catch (Exception ex) {
					messageErr.addObject("exeption", ex.getMessage());
					return null;
				}
			}
		}
		messageErr.addObject("exeption", "IdProd isNull");
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