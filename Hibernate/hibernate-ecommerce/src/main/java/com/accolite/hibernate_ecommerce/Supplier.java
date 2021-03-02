package com.accolite.hibernate_ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Supplier {
	
	private int sid;
	private String supplierName;
	
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplieryName) {
		this.supplierName = supplierName;
	}
	
	@ManyToMany(mappedBy="sup")
	List<Categories> cat=new ArrayList();
	
	public List<Categories> getCat() {
		return cat;
	}

	public void setCat(List<Categories> cat) {
		this.cat = cat;
	}

	@ManyToMany(mappedBy="sup")
	List<Product> prod=new ArrayList();
	
	
	public List<Product> getProd() {
		return prod;
	}

	public void setProd(List<Product> prod) {
		this.prod = prod;
	}

	@Override
	public String toString() {
		return "Supplier [sid=" + sid + ", supplierName=" + supplierName + "]";
	}
	
}
