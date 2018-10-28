package com.spi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SUBJECT")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private String abbr;

	@Column
	private String description;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subject", cascade = CascadeType.ALL)
	private Set<ClassSubMapper> classMappers;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subject", cascade = CascadeType.ALL)
	private Set<FacSubMapper> facMappers;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(String name, String abbr, String description) {
		super();
		this.name = name;
		this.abbr = abbr;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<FacSubMapper> getFacMappers() {
		return facMappers;
	}

	public void setFacMappers(Set<FacSubMapper> facMappers) {
		this.facMappers = facMappers;
	}

	public Set<ClassSubMapper> getclassMappers() {
		return classMappers;
	}

	public void setclassMappers(Set<ClassSubMapper> classMappers) {
		this.classMappers = classMappers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbr == null) ? 0 : abbr.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (abbr == null) {
			if (other.abbr != null)
				return false;
		} else if (!abbr.equals(other.abbr))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", abbr=" + abbr + ", description=" + description + "]";
	}

}