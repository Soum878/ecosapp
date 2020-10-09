package com.eco.ecoapp.client;

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
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	/*
	 *	Créer un client
	 */
	
	@PostMapping("/clients")
	ResponseEntity<Client> createClient(@RequestBody Client client) throws URISyntaxException {
		Client result = clientRepository.save(client);
		return ResponseEntity.created(new URI("/api/clients" + result.getId())).body(result);
	}
	
	/*
	 *	Lister les clients
	 */
	
	@GetMapping("/clients")
	List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	/*
	 * 	Modifier un client
	 */
	
	@PutMapping("/clients/{id}")
	ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
		Client result = clientRepository.findById(id)
			.map(c -> {
				c.setRaisonSociale(client.getRaisonSociale());
				c.setGsm(client.getGsm());
				c.setAdresse(client.getAdresse());
				c.setFormeJuridique(client.getFormeJuridique());
				c.setEmail(client.getEmail());
				c.setVille(client.getVille());
				c.setDateCreation(client.getDateCreation());
				c.setIdFiscal(client.getIdFiscal());
				c.setLoginSimpl(client.getLoginSimpl());
				c.setResponsable(client.getResponsable());
				c.setCnss(client.getCnss());
				c.setLoginDamancom(client.getLoginDamancom());
				c.setFix(client.getFix());
				c.setRc(client.getRc());
				c.setEtat(client.getEtat());
				return clientRepository.save(c);
			})
			.orElseGet(() -> {
				client.setId(id);
				return clientRepository.save(client);
			});
		return ResponseEntity.ok().body(result);
	}
	
	/*
	 * 	Supprimer un client
	 */
	
	@DeleteMapping("/clients/{id}")
	ResponseEntity<?> deleteClient(@PathVariable Long id) {
		clientRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	/*
	 * 	Lister les clients activés
	 */
	
	@GetMapping("/clients/active")
	List<Client> getActiveClients() {
		return clientRepository.findByEtat(true);
	}
	
	/*
	 *	Activer / Desactiver un client
	 */
	
	@PutMapping("/clients/{id}/changeStatus")
	ResponseEntity<Client> activateClient(@PathVariable Long id) {
		Client client = (clientRepository.findAll()).stream().filter(c -> c.getId().equals(id)).findFirst().get();
		client.setEtat(!client.getEtat());
		Client result = clientRepository.save(client);
		return ResponseEntity.ok().body(result);
	}
	

}
