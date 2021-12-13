package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8744904825391005398L;

	@Id
	private String id;

	private String email;
	private Date dateOfBirth;
	private String firstName;
	private String lastName;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> phones;
	
	@ManyToOne
	@JoinColumn(name = "departmentID")
	private Department department;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Proposal> proposals;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	public Employee() {
		super();
	}

	

	public Employee(String id, String email, Date dateOfBirth, String firstName, String lastName, Set<String> phones,
			Gender gender) {
		super();
		this.id = id;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phones = phones;
		this.gender = gender;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Set<String> getPhones() {
		return phones;
	}



	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public List<Proposal> getProposals() {
		return proposals;
	}



	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phones=" + phones + ", departmentID=" + department.getId() + ", proposals="
				+ proposals + "]";
	}
	
	
}
