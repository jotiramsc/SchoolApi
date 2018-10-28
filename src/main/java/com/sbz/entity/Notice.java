package com.sbz.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "NOTICE_BOARD")
public class Notice {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(length = 250, nullable = false)
	String header;

	@Column(length = 250, nullable = false)
	String content;

	@Column
	String description;

	@Column(length = 250)
	String link;

	@Column(length = 20)
	String sevarity;

	@Column
	Integer order_seq;

	@Column
	String active_flag;

	@Column
	Integer created_by;

	@Column
	LocalDateTime created_date;

	@Column
	Integer update_by;

	@Column
	LocalDateTime updated_date;

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(Integer id, String header, String content, String description, String link,
			String sevarity, Integer order_seq, String active_flag, Integer created_by, LocalDateTime created_date,
			Integer update_by, LocalDateTime updated_date) {
		super();
		this.id = id;
		this.header = header;
		this.content = content;
		this.description = description;
		this.link = link;
		this.sevarity = sevarity;
		this.order_seq = order_seq;
		this.active_flag = active_flag;
		this.created_by = created_by;
		this.created_date = created_date;
		this.update_by = update_by;
		this.updated_date = updated_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getSevarity() {
		return sevarity;
	}

	public void setSevarity(String sevarity) {
		this.sevarity = sevarity;
	}

	public Integer getOrder_seq() {
		return order_seq;
	}

	public void setOrder_seq(Integer order_seq) {
		this.order_seq = order_seq;
	}

	public String getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(String active_flag) {
		this.active_flag = active_flag;
	}

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	public Integer getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(Integer update_by) {
		this.update_by = update_by;
	}

	public LocalDateTime getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active_flag == null) ? 0 : active_flag.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result + ((created_date == null) ? 0 : created_date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((order_seq == null) ? 0 : order_seq.hashCode());
		result = prime * result + ((sevarity == null) ? 0 : sevarity.hashCode());
		result = prime * result + ((update_by == null) ? 0 : update_by.hashCode());
		result = prime * result + ((updated_date == null) ? 0 : updated_date.hashCode());
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
		Notice other = (Notice) obj;
		if (active_flag == null) {
			if (other.active_flag != null)
				return false;
		} else if (!active_flag.equals(other.active_flag))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (created_by == null) {
			if (other.created_by != null)
				return false;
		} else if (!created_by.equals(other.created_by))
			return false;
		if (created_date == null) {
			if (other.created_date != null)
				return false;
		} else if (!created_date.equals(other.created_date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (order_seq == null) {
			if (other.order_seq != null)
				return false;
		} else if (!order_seq.equals(other.order_seq))
			return false;
		if (sevarity == null) {
			if (other.sevarity != null)
				return false;
		} else if (!sevarity.equals(other.sevarity))
			return false;
		if (update_by == null) {
			if (other.update_by != null)
				return false;
		} else if (!update_by.equals(other.update_by))
			return false;
		if (updated_date == null) {
			if (other.updated_date != null)
				return false;
		} else if (!updated_date.equals(other.updated_date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NoticeBoardEntity [id=" + id + ", header=" + header + ", content=" + content + ", description="
				+ description + ", link=" + link + ", sevarity=" + sevarity + ", order_seq=" + order_seq
				+ ", active_flag=" + active_flag + ", created_by=" + created_by + ", created_date=" + created_date
				+ ", update_by=" + update_by + ", updated_date=" + updated_date + "]";
	}

}
