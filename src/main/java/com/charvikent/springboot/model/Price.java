package com.charvikent.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Price {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String iname;
	String iprice;
	public Price() {
		
	}
	public Price(int id, String iname, String iprice) {
		this.id = id;
		this.iname = iname;
		this.iprice = iprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIprice() {
		return iprice;
	}
	public void setIprice(String iprice) {
		this.iprice = iprice;
	}	
}
