package com.userfront.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity e konsideron si entitet objektin Appoinment
@Entity
public class Appointment {
	
	//@Id eshte primary key 
	//@GeneratedValue - e shton automatkisht primary key dhe e ka auto-increment
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date date;
	private String location;
	private String description;
	private boolean confirmed;
	
	//Nje user mund te kete shume Appointment (Many-To-One pasi qe jemi ne klasen Appoinment)
	@ManyToOne
	@JoinColumn(name="user_id")
	//user_id primary key ne tabelen User
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", location=" + location + ", description=" + description
				+ ", confirmed=" + confirmed + ", user=" + user + "]";
	}
	
	
	
	

}
