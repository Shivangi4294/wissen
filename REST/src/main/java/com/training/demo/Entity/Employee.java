package com.training.demo.Entity;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	int id;
	@Column(name ="name")
	String name;
	@Column(name ="dept")
	String dept;
	@Column(name ="desig")
	String desig;
	
	Employee(){}
	
	public Employee(int id, String name, String dept, String desig) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.desig = desig;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	
	@Override
	public String toString() {
		return "Employee [id = " +id+", name= "+name+", dept =" +dept+ " , desig =" +desig+"]";
	}
	
	
}
