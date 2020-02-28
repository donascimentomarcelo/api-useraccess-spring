package br.com.userAccess.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.userAccess.domain.enums.Profile;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String username;
	private String password;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PROFILES")
	private Set<Integer> profiles = new HashSet<>();
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	private Client client;

	public User() {
		
	}

	public User(Integer id, String username, String password, Client client) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.client = client;
		addProfiles(Profile.USER);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Profile> getProfiles() {
		return profiles
					.stream()
					.map(code -> Profile.toEnum(code))
					.collect(Collectors.toSet());
	}

	public void addProfiles(Profile profile) {
		profiles.add(profile.getCode());
	}

	
}
