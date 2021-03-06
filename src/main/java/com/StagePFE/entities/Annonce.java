package com.StagePFE.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Annonce implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Entrepreneur entrepreneur;

	@OneToMany(mappedBy = "annonce")
	private List<EtudiantAnnonce> etudiantAnnonces;

	@OneToMany(mappedBy = "annonce", fetch = FetchType.EAGER)
	private List<LigneRegarderPlusTardVisiteur> ligneRegarderPlusTardVisiteurs;

	private String titre;
	@Column(columnDefinition = "text")
	private String description;
	private Date dateCreation;
	private Date dateExperation;
	private Boolean isOuvert;
	private String lieu;

	public Annonce(String titre, String description, Date dateCreation, Date dateExperation, Boolean isOuvert,
			String lieu) {
		super();
		this.titre = titre;
		this.description = description;
		this.dateCreation = dateCreation;
		this.dateExperation = dateExperation;
		this.isOuvert = isOuvert;
		this.lieu = lieu;
	}

	public void addEtudiantAnnonce(EtudiantAnnonce etdAnn) {
		if (etudiantAnnonces == null) {
			etudiantAnnonces = new ArrayList<>();
		}
		etudiantAnnonces.add(etdAnn);
		etdAnn.setAnnonce(this);

	}

	public void addLigneRegarderPlusTardVisiteur(LigneRegarderPlusTardVisiteur lnregarder) {
		if (ligneRegarderPlusTardVisiteurs == null) {
			ligneRegarderPlusTardVisiteurs = new ArrayList<>();
		}
		ligneRegarderPlusTardVisiteurs.add(lnregarder);
		lnregarder.setAnnonce(this);

	}

	@Override
	public String toString() {
		return "Annonce [id=" + id + ", ligneRegarderPlusTardVisiteurs=" + ligneRegarderPlusTardVisiteurs + ", titre="
				+ titre + ", description=" + description + ", dateCreation=" + dateCreation + ", dateExperaiton="
				+ dateExperation + ", isOuvert=" + isOuvert + ", lieu=" + lieu + "]";
	}

}
