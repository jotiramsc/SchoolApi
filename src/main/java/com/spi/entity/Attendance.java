package com.spi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spi.model.audit.UserDateAudit;

@Entity
@Table(name = "ATTENDANCE")
public class Attendance extends UserDateAudit {
	private static final long serialVersionUID = 4563705011705428755L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;	

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "student_id")
	private Student student;	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@Column
	private boolean present;

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attendance(int id, Student student, Subject subject, boolean present) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.present = present;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (present ? 1231 : 1237);
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		Attendance other = (Attendance) obj;
		if (id != other.id)
			return false;
		if (present != other.present)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
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
		return "Attendance [id=" + id + ", student=" + student + ", subject=" + subject + ", present=" + present + "]";
	}
	
	
	
	
	

}