package com.javaweb.ItemsMN.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="specification")
public class Specification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Specification;
	
	@Column(name="Name", nullable=true)
	private String Name;
	
	@Column(name="Value", nullable=true)
	private String Value;
	
	@ManyToOne
	@JoinColumn(name = "ID_Item")
	private Items item;
	
	
	public Specification() {
		
	}
	

	public Specification(String name, String value, Items item) {
		Name = name;
		Value = value;
		this.item = item;
	}



	public Specification(Long iD_Specification, String name, String value, Items item) {
		ID_Specification = iD_Specification;
		Name = name;
		Value = value;
		this.item = item;
	}

	public Long getID_Specification() {
		return ID_Specification;
	}

	public void setID_Specification(Long iD_Specification) {
		ID_Specification = iD_Specification;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

//	public Items getItem() {
//		return item;
//	}
//
//	public void setItem(Items item) {
//		this.item = item;
//	}
	
	@Override
	public String toString() {
		return this.Name + ":" + this.Value;
	}
	
	
}
