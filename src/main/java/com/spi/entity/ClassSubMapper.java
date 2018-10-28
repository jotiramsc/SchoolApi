package com.spi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_SUB_MAPPER")
public class ClassSubMapper {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "courseClassId")
	private CourseClass courseClass;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "subject_id")
	private Subject subject;

	public ClassSubMapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassSubMapper(int id, CourseClass courseClass, Subject subject) {
		super();
		this.id = id;
		this.courseClass = courseClass;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CourseClass getCourseClass() {
		return courseClass;
	}

	public void setCourseClass(CourseClass courseClass) {
		this.courseClass = courseClass;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseClass == null) ? 0 : courseClass.hashCode());
		result = prime * result + id;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		ClassSubMapper other = (ClassSubMapper) obj;
		if (courseClass == null) {
			if (other.courseClass != null)
				return false;
		} else if (!courseClass.equals(other.courseClass))
			return false;
		if (id != other.id)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassSubMapper [id=" + id + ", courseClass=" + courseClass + ", subject=" + subject + "]";
	}

	

	
}