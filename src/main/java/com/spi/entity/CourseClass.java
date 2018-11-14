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
@Table(name = "COURSE_CLASS")
public class CourseClass extends UserDateAudit{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4843309471158051398L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private String abbr;

	@Column
	private String description;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "course_id")
	private Course course;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseClass", cascade = CascadeType.ALL)
	private Set<Student> students;
	
	

	public CourseClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseClass(String name, String abbr, String description, Course course) {
		super();
		this.name = name;
		this.abbr = abbr;
		this.description = description;
		this.course = course;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbr == null) ? 0 : abbr.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
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
		CourseClass other = (CourseClass) obj;
		if (abbr == null) {
			if (other.abbr != null)
				return false;
		} else if (!abbr.equals(other.abbr))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
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
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourseClass [id=" + id + ", name=" + name + ", abbr=" + abbr + ", description=" + description
				+ ", course=" + course + ", students=" + students + "]";
	}

	

}