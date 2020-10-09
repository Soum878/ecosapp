package com.eco.ecoapp.prestation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eco.ecoapp.client.Client;


@Entity
@Table(name="prestations")
public class Prestation {
	
	@Id
	@GeneratedValue
	private Long id;
	private String designation;
	private String observation;
    private String situation;
    private Boolean status;
    private String dateLimite;
    private String dateEchue;
	
	@ManyToOne
	private Client client;
	
	public Prestation() {
		super();
	}
	
	public Prestation(Long id) {
		super();
		this.id = id;
	}

	public Prestation(Long id, String designation, String observation, String situation, Boolean status,
			String dateLimite, String dateEchue, Client client) {
		super();
		this.id = id;
		this.designation = designation;
		this.observation = observation;
		this.situation = situation;
		this.status = status;
		this.dateLimite = dateLimite;
		this.dateEchue = dateEchue;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDateLimite() {
		return dateLimite;
	}

	public void setDateLimite(String dateLimite) {
		this.dateLimite = dateLimite;
	}

	public String getDateEchue() {
		return dateEchue;
	}

	public void setDateEchue(String dateEchue) {
		this.dateEchue = dateEchue;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
