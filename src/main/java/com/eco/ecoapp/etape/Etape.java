package com.eco.ecoapp.etape;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eco.ecoapp.prestation.Prestation;


@Entity
@Table(name="etapes")
public class Etape {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String nom;
	private int ordre;
	
	@ManyToOne
	private Prestation prestation;
	
	public Etape() {
		super();
	}

	public Etape(Long id) {
		super();
		this.id = id;
	}

	public Etape(Long id, String nom, int ordre, Prestation prestation) {
		super();
		this.id = id;
		this.nom = nom;
		this.ordre = ordre;
		this.prestation = prestation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}
}