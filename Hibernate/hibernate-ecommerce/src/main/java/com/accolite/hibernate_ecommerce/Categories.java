package com.accolite.hibernate_ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Categories {

	@Id
	private int cid;
	private String categoryName;
	
	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@ManyToOne
	Product prod;
	
	
	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}
	
	@ManyToMany
	List<Supplier> sup=new ArrayList();
	
	public List<Supplier> getSup() {
		return sup;
	}

	public void setSup(List<Supplier> sup) {
		this.sup = sup;
	}

	@Override
	public String toString() {
		return "Categories [cid=" + cid + ", categoryName=" + categoryName + "]";
	}
	
	
	
}
