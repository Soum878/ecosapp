package com.eco.ecoapp.etape;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EtapeController {
	
	@Autowired
	private EtapeRepository etapeRepository;
	
	/*
	 *	Créer une étape
	 */
	
	@PostMapping("/prestations/{prestationId}/etapes")
	ResponseEntity<Etape> createEtape(@RequestBody Etape etape) throws URISyntaxException {
		Etape result = etapeRepository.save(etape);
		return ResponseEntity.created(new URI("/api/prestations" + result.getId())).body(result);
	}
	
	/*
	 * 	Modifier une étape
	 */
	
	@PutMapping("/prestations/{prestationId}/etapes/{id}")
	ResponseEntity<Etape> updateEtape(@PathVariable Long id, @RequestBody Etape etape) {
		Etape result = etapeRepository.findById(id)
			.map(e -> {
				e.setNom(etape.getNom());
				e.setOrdre(etape.getOrdre());
				return etapeRepository.save(e);
			})
			.orElseGet(() -> {
				etape.setId(id);
				return etapeRepository.save(etape);
			});
		return ResponseEntity.ok().body(result);
	}
	
	/*
	 * 	Supprimer une étape
	 */
	
	@DeleteMapping("/prestations/{prestationId}/etapes/{id}")
	ResponseEntity<?> deleteEtape(@PathVariable Long id) {
		etapeRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}