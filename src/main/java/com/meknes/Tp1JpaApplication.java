package com.meknes;

import com.meknes.dao.CategorieRepository;
import com.meknes.dao.ProduitRepository;
import com.meknes.entities.Categorie;
import com.meknes.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Tp1JpaApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(Tp1JpaApplication.class, args);
		ProduitRepository produitDAO=context.getBean(ProduitRepository.class);
		CategorieRepository categorieRepository=context.getBean(CategorieRepository.class);
		Categorie c1 =new Categorie("Ordinateurs");
		Categorie c2 =new Categorie("Cameras");
		Categorie c3 =new Categorie("Programmes");
		categorieRepository.save(c1);
		categorieRepository.save(c2);
		categorieRepository.save(c3);
		produitDAO.save(new Produit("Acer1122",123,45,c1));
		produitDAO.save(new Produit("HP849",212,4234,c2));
		produitDAO.save(new Produit("HP98i",7812,211,c2));

		List<Produit> produits=produitDAO.produitsParMC("%H%");
		for (Produit produit:produits){
			System.out.println(produit.getDesignation());
			System.out.println(produit.getPrix());
		}
	}
}
