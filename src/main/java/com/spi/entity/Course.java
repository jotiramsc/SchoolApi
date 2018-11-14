package com.spi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spi.model.audit.UserDateAudit;

@Entity
@Table(name = "COURSE")
public class Course extends UserDateAudit {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7096421910494750550L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 250)
	private String name;

	@Column(length = 10)
	private String abbr;

	@Column(length = 20)
	private String type;

	@Column(length = 2000)
	private String description;

	@Column
	private Integer duration;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "department_id")
	private Department department;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL)
	private Set<CourseClass> classes;

	public Course(int id, String name, String abbr, String type, String description, Integer duration,
			Department department, Set<CourseClass> classes) {
		super();
		this.id = id;
		this.name = name;
		this.abbr = abbr;
		this.type = type;
		this.description = description;
		this.duration = duration;
		this.department = department;
		this.classes = classes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Department getDepartment() {
		return department;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<CourseClass> getclasses() {
		return classes;
	}

	public void setclasses(Set<CourseClass> classes) {
		this.classes = classes;
	}

	
}