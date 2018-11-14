package com.spi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spi.model.audit.UserDateAudit;

@Entity
@Table(name = "BOOK")
public class Book extends UserDateAudit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 234737074687057082L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int bookID;
	private String bookName;
	private String author;
	private Double price;
	private String status;
	private String edition;
	private String bookType;
	private int quantity;
	private int availableQty;
	private int rackNo;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookID, String bookName, String author, Double price, String status, String edition,
			String bookType, int quantity, int availableQty, int rackNo) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.status = status;
		this.edition = edition;
		this.bookType = bookType;
		this.quantity = quantity;
		this.availableQty = availableQty;
		this.rackNo = rackNo;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAvail_quntity() {
		return availableQty;
	}
	public void setAvail_quntity(int availableQty) {
		this.availableQty = availableQty;
	}
	public int getRackNo() {
		return rackNo;
	}
	public void setRackNo(int rackNo) {
		this.rackNo = rackNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + availableQty;
		result = prime * result + bookID;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((bookType == null) ? 0 : bookType.hashCode());
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + quantity;
		result = prime * result + rackNo;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (availableQty != other.availableQty)
			return false;
		if (bookID != other.bookID)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookType == null) {
			if (other.bookType != null)
				return false;
		} else if (!bookType.equals(other.bookType))
			return false;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (rackNo != other.rackNo)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ ", status=" + status + ", edition=" + edition + ", bookType=" + bookType + ", quantity=" + quantity
				+ ", availableQty=" + availableQty + ", rackNo=" + rackNo + "]";
	}

	
}