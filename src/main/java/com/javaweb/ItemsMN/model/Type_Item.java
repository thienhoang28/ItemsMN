package com.javaweb.ItemsMN.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="type_item")
public class Type_Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Type_Item;
	
	@Column(name="Name_Type", nullable=true)
	private String Name_Type;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_Type_Item", referencedColumnName = "ID_Type_Item")
	private List<Producer> producers = new ArrayList<>();
	
	
	public Type_Item() {
	}


	public Type_Item(Long iD_Type_Item, String name_Type, List<Producer> producers) {
		ID_Type_Item = iD_Type_Item;
		Name_Type = name_Type;
		this.producers = producers;
	}



	public Type_Item(Long iD_Type_Item, String name_Type) {
		ID_Type_Item = iD_Type_Item;
		Name_Type = name_Type;

	}


	public Long getID_Type_Item() {
		return ID_Type_Item;
	}


	public void setID_Type_Item(Long iD_Type_Item) {
		ID_Type_Item = iD_Type_Item;
	}


	public String getName_Type() {
		return Name_Type;
	}


	public void setName_Type(String name_Type) {
		Name_Type = name_Type;
	}


	public List<Producer> getProducers() {
		return producers;
	}


	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}

	
	
}
