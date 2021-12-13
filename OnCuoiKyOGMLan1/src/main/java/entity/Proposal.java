package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proposal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8875488954539012938L;
	@Id
	private String id;
	private Date date;
	private String pcontent;
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "employeeID")
	private Employee employee;
	
	public Proposal() {
		// TODO Auto-generated constructor stub
	}

	public Proposal(String id, Date date, String pcontent, String title) {
		super();
		this.id = id;
		this.date = date;
		this.pcontent = pcontent;
		this.title = title;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Proposal [id=" + id + ", date=" + date + ", pcontent=" + pcontent + ", title=" + title + ", employeeID="
				+ employee.getId() + "]";
	}
	
	
}
