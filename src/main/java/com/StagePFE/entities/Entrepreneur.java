package com.StagePFE.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("entrepreneur")
@Data @NoArgsConstructor @AllArgsConstructor
public class Entrepreneur extends Profile {

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "profile_id")
//	private Profile profile;

	@OneToMany(mappedBy = "entrepreneur",fetch = FetchType.EAGER)
	private List<Annonce> annonces;

	private String nomEntreprise;

	public Entrepreneur(String email, String nom, String prenom, Date dateCreation, String photo, String video,
			String description, String adresse) {
		super(email, nom, prenom, dateCreation, photo, video, description, adresse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Entrepreneur [annonces=" + annonces + ", nomEntreprise=" + nomEntreprise + ", toString()="
				+ super.toString();
	}
	
	

}