package com.spi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	long mobile_1;
	long mobile_2;
	String phone_1;
	String phone_2;
	String email_1;
	String email_2;
	String facebook_link;
	String gplus_link;
	String linkedin_link;
	String website_link;
	String address_1;
	String address_2;
	String city;
	String district;
	String state;
	int pincode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(long mobile_1, long mobile_2, String phone_1, String phone_2, String email_1, String email_2,
			String facebook_link, String gplus_link, String linkedin_link, String website_link, String address_1,
			String address_2, String city, String district, String state, int pincode) {
		super();
		this.mobile_1 = mobile_1;
		this.mobile_2 = mobile_2;
		this.phone_1 = phone_1;
		this.phone_2 = phone_2;
		this.email_1 = email_1;
		this.email_2 = email_2;
		this.facebook_link = facebook_link;
		this.gplus_link = gplus_link;
		this.linkedin_link = linkedin_link;
		this.website_link = website_link;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMobile_1() {
		return mobile_1;
	}

	public void setMobile_1(long mobile_1) {
		this.mobile_1 = mobile_1;
	}

	public long getMobile_2() {
		return mobile_2;
	}

	public void setMobile_2(long mobile_2) {
		this.mobile_2 = mobile_2;
	}

	public String getPhone_1() {
		return phone_1;
	}

	public void setPhone_1(String phone_1) {
		this.phone_1 = phone_1;
	}

	public String getPhone_2() {
		return phone_2;
	}

	public void setPhone_2(String phone_2) {
		this.phone_2 = phone_2;
	}

	public String getEmail_1() {
		return email_1;
	}

	public void setEmail_1(String email_1) {
		this.email_1 = email_1;
	}

	public String getEmail_2() {
		return email_2;
	}

	public void setEmail_2(String email_2) {
		this.email_2 = email_2;
	}

	public String getFacebook_link() {
		return facebook_link;
	}

	public void setFacebook_link(String facebook_link) {
		this.facebook_link = facebook_link;
	}

	public String getGplus_link() {
		return gplus_link;
	}

	public void setGplus_link(String gplus_link) {
		this.gplus_link = gplus_link;
	}

	public String getLinkedin_link() {
		return linkedin_link;
	}

	public void setLinkedin_link(String linkedin_link) {
		this.linkedin_link = linkedin_link;
	}

	public String getWebsite_link() {
		return website_link;
	}

	public void setWebsite_link(String website_link) {
		this.website_link = website_link;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address_1 == null) ? 0 : address_1.hashCode());
		result = prime * result + ((address_2 == null) ? 0 : address_2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((email_1 == null) ? 0 : email_1.hashCode());
		result = prime * result + ((email_2 == null) ? 0 : email_2.hashCode());
		result = prime * result + ((facebook_link == null) ? 0 : facebook_link.hashCode());
		result = prime * result + ((gplus_link == null) ? 0 : gplus_link.hashCode());
		result = prime * result + id;
		result = prime * result + ((linkedin_link == null) ? 0 : linkedin_link.hashCode());
		result = prime * result + (int) (mobile_1 ^ (mobile_1 >>> 32));
		result = prime * result + (int) (mobile_2 ^ (mobile_2 >>> 32));
		result = prime * result + ((phone_1 == null) ? 0 : phone_1.hashCode());
		result = prime * result + ((phone_2 == null) ? 0 : phone_2.hashCode());
		result = prime * result + pincode;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((website_link == null) ? 0 : website_link.hashCode());
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
		Address other = (Address) obj;
		if (address_1 == null) {
			if (other.address_1 != null)
				return false;
		} else if (!address_1.equals(other.address_1))
			return false;
		if (address_2 == null) {
			if (other.address_2 != null)
				return false;
		} else if (!address_2.equals(other.address_2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (email_1 == null) {
			if (other.email_1 != null)
				return false;
		} else if (!email_1.equals(other.email_1))
			return false;
		if (email_2 == null) {
			if (other.email_2 != null)
				return false;
		} else if (!email_2.equals(other.email_2))
			return false;
		if (facebook_link == null) {
			if (other.facebook_link != null)
				return false;
		} else if (!facebook_link.equals(other.facebook_link))
			return false;
		if (gplus_link == null) {
			if (other.gplus_link != null)
				return false;
		} else if (!gplus_link.equals(other.gplus_link))
			return false;
		if (id != other.id)
			return false;
		if (linkedin_link == null) {
			if (other.linkedin_link != null)
				return false;
		} else if (!linkedin_link.equals(other.linkedin_link))
			return false;
		if (mobile_1 != other.mobile_1)
			return false;
		if (mobile_2 != other.mobile_2)
			return false;
		if (phone_1 == null) {
			if (other.phone_1 != null)
				return false;
		} else if (!phone_1.equals(other.phone_1))
			return false;
		if (phone_2 == null) {
			if (other.phone_2 != null)
				return false;
		} else if (!phone_2.equals(other.phone_2))
			return false;
		if (pincode != other.pincode)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (website_link == null) {
			if (other.website_link != null)
				return false;
		} else if (!website_link.equals(other.website_link))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", mobile_1=" + mobile_1 + ", mobile_2=" + mobile_2 + ", phone_1=" + phone_1
				+ ", phone_2=" + phone_2 + ", email_1=" + email_1 + ", email_2=" + email_2 + ", facebook_link="
				+ facebook_link + ", gplus_link=" + gplus_link + ", linkedin_link=" + linkedin_link + ", website_link="
				+ website_link + ", address_1=" + address_1 + ", address_2=" + address_2 + ", city=" + city
				+ ", district=" + district + ", state=" + state + ", pincode=" + pincode + "]";
	}

}