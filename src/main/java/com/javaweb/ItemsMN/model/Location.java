package com.javaweb.ItemsMN.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Location;
	
	@Column(name="Branch", nullable=true)
	private String Branch;
	
	@Column(name="Address", nullable=true)
	private String Address;
	
	@Column(name="Floor", nullable=true)
	private String Floor;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_Location", referencedColumnName = "ID_Location")
	private List<Items> items = new ArrayList<>();

	public Location() {
	}

	
	public Location(Long iD_Location, String branch, String address, String floor, List<Items> items) {
		ID_Location = iD_Location;
		Branch = branch;
		Address = address;
		Floor = floor;
		this.items = items;
	}



	public Location(Long iD_Location, String branch, String address, String floor) {
		ID_Location = iD_Location;
		Branch = branch;
		Address = address;
		Floor = floor;
	}

	public Long getID_Location() {
		return ID_Location;
	}

	public void setID_Location(Long iD_Location) {
		ID_Location = iD_Location;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getFloor() {
		return Floor;
	}

	public void setFloor(String floor) {
		Floor = floor;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	
	
}
