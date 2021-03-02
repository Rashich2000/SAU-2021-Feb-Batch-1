package com.accolite.hibernate_ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	private int pid;
	private String productName;
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@OneToMany(mappedBy="prod")
	List<Categories> cat=new ArrayList();
	

	public List<Categories> getCat() {
		return cat;
	}

	public void setCat(List<Categories> cat) {
		this.cat = cat;
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
		return "Product [pid=" + pid + ", productName=" + productName + "]";
	}
	
	
}

