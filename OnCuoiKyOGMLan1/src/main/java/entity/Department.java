package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

@Entity
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6116305876298471628L;
	@Id
	private String id;
	private String location;
	private String name;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Employee> employees;
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Department(String id, String location, String name) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", location=" + location + ", name=" + name + ", employees=" + employees + "]";
	}
	
}
