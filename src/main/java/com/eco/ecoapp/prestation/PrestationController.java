package com.eco.ecoapp.prestation;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

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

import com.eco.ecoapp.categorie.Categorie;
import com.eco.ecoapp.client.Client;


@RestController
@RequestMapping("/api")
public class PrestationController {
	
	@Autowired
	private PrestationRepository prestationRepository;		

	/*
	 *	Créer une prestation (clientId, categorieId)
	 */
	
	@PostMapping("/clients/{clientId}/categories/{categorieId}/prestations")
	ResponseEntity<Prestation> createPrestation(@PathVariable Long clientId, @PathVariable Long categorieId, @RequestBody Prestation prestation) throws URISyntaxException {
		prestation.setClient(new Client(clientId));
		prestation.setCategorie(new Categorie(categorieId));
		Prestation result = prestationRepository.save(prestation);
		return ResponseEntity.created(new URI("/api/prestations" + result.getId())).body(result);
	}
	
	/*
	 *	Lister toutes les prestations
	 */
	
	@GetMapping("/prestations")
	List<Prestation> getAllPrestations() {
		return prestationRepository.findAll();
	}
	
	/*
	 * 	Modifier une prestation 
	 */
	
	@PutMapping("/prestations/{id}")
	ResponseEntity<Prestation> updatePrestation(@PathVariable Long id, @RequestBody Prestation prestation) {
		Prestation result = prestationRepository.findById(id)
			.map(p -> {
				p.setDesignation(prestation.getDesignation());
				p.setObservation(prestation.getObservation());
				p.setSituation(prestation.getSituation());
				p.setStatus(prestation.getStatus());
				p.setDateLimite(prestation.getDateLimite());
				p.setDateEchue(prestation.getDateEchue());
				return prestationRepository.save(p);
			})
			.orElseGet(() -> {
				prestation.setId(id);
				return prestationRepository.save(prestation);
			});
		return ResponseEntity.ok().body(result);
	}
	
	/*
	 * 	Supprimer une prestation 
	 */
	
	@DeleteMapping("/prestations/{id}")
	ResponseEntity<?> deletePrestation(@PathVariable Long id) {
		prestationRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	/*
	 *	Lister les prestations d'un client
	 */
	
	@GetMapping("/clients/{clientId}/prestations")
	List<Prestation> getPrestationsByClient(@PathVariable Long clientId) {
		return prestationRepository.findByClientId(clientId);
	}
	
	/*
	 *	Filter les prestations (clientId, categorieId, dateEchue, status)
	 */
	@GetMapping("/clients/{clientId}/categories/{categorieId}/{dateEchue}/{status}/prestations")
	List<Prestation> filterPrestations(@PathVariable Long clientId, @PathVariable Long categorieId, @PathVariable String dateEchue, @PathVariable Boolean status) {
		
		List<Prestation> prestations = prestationRepository.findByClientIdAndCategorieId(clientId, categorieId)
				.stream()				
				.filter(p -> p.getDateEchue().equals(dateEchue))
				.filter(p -> p.getStatus() == status)
				.collect(Collectors.toList());
		return prestations;		
	}
	
}






