package com.eco.ecoapp.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByEtat(Boolean etat);

}
