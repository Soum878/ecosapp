package com.eco.ecoapp.categorie;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CategorieController {
	
	@Autowired
	private CategorieRepository categorieRepository;

	/*
	 *	Ajouter categorie
	 */
	
	@PostMapping("/categories")
	ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) throws URISyntaxException {
		Categorie result = categorieRepository.save(categorie);
		return ResponseEntity.created(new URI("/api/categories" + result.getId())).body(result);
	}
	
	/*
	 *	Lister les categories
	 */
	
	@GetMapping("/categories")
	List<Categorie> getAllCategories() {
		return categorieRepository.findAll();
	}
	
	/*
	 * 	Modifier un client
	 */
	
	@PutMapping("/categories/{id}")
	ResponseEntity<Categorie> updateCategorie(@PathVariable Long id, @RequestBody Categorie categorie) {
		Categorie result = categorieRepository.findById(id)
			.map(c -> {
				c.setName(categorie.getName());
				return categorieRepository.save(c);
			})
			.orElseGet(() -> {
				categorie.setId(id);
				return categorieRepository.save(categorie);
			});
		return ResponseEntity.ok().body(result);
	}
	
	/*
	 * 	Supprimer un client
	 */
	
	@DeleteMapping("/categories/{id}")
	ResponseEntity<?> deleteClient(@PathVariable Long id) {
		categorieRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
