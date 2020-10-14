package com.eco.ecoapp.prestation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestationRepository extends JpaRepository<Prestation, Long> {
	
	List<Prestation> findByClientId(Long idClient);
	List<Prestation> findByClientIdAndCategorieId(Long idClient, Long idCategorie);
}
