package com.eco.ecoapp.client;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String raisonSociale;
	private String gsm;
	private String adresse;
	private String formeJuridique;
	@Column(unique = true)
	private String email;
	private String ville;
	private String dateCreation;
	@Column(unique = true)
	private String idFiscal;
	@Column(unique = true)
	private String loginSimpl;
	private String responsable;
	private String cnss;
	@Column(unique = true)
	private String loginDamancom;
	private String fix;
	@Column(unique = true)
	private String rc;
	private Boolean etat;
	
	public Client() {
		super();
	}
	
	public Client(Long id) {
		super();
		this.id = id;
	}

	public Client(Long id, String raisonSociale, String gsm, String adresse, String formeJuridique, String email,
			String ville, String dateCreation, String idFiscal, String loginSimpl, String responsable, String cnss,
			String loginDamancom, String fix, String rc, Boolean etat) {
		super();
		this.id = id;
		this.raisonSociale = raisonSociale;
		this.gsm = gsm;
		this.adresse = adresse;
		this.formeJuridique = formeJuridique;
		this.email = email;
		this.ville = ville;
		this.dateCreation = dateCreation;
		this.idFiscal = idFiscal;
		this.loginSimpl = loginSimpl;
		this.responsable = responsable;
		this.cnss = cnss;
		this.loginDamancom = loginDamancom;
		this.fix = fix;
		this.rc = rc;
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(String idFiscal) {
		this.idFiscal = idFiscal;
	}

	public String getLoginSimpl() {
		return loginSimpl;
	}

	public void setLoginSimpl(String loginSimpl) {
		this.loginSimpl = loginSimpl;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getCnss() {
		return cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	public String getLoginDamancom() {
		return loginDamancom;
	}

	public void setLoginDamancom(String loginDamancom) {
		this.loginDamancom = loginDamancom;
	}

	public String getFix() {
		return fix;
	}

	public void setFix(String fix) {
		this.fix = fix;
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
}

