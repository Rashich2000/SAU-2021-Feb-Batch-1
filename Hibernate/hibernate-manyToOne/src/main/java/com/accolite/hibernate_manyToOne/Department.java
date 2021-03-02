package com.accolite.hibernate_manyToOne;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	private int deptId;
	
	private String deptName;

	@OneToMany(mappedBy="dept")
	private List<Employee1> emp=new ArrayList<Employee1>();

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee1> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee1> emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
	

}
