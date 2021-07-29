package com.javaweb.ItemsMN.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="producer")
public class Producer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Producer;
	
	@Column(name="Name_Producer", nullable=true)
	private String Name_Producer;
	
	@ManyToOne
	@JoinColumn(name = "ID_Type_Item")
	private Type_Item typeitem;
	

	public Producer() {
		
	}

	public Producer(Long iD_Producer, String name_Producer, Type_Item typeitem) {
		ID_Producer = iD_Producer;
		Name_Producer = name_Producer;
		this.typeitem = typeitem;
	}



	public Producer(Long iD_Producer, String name_Producer) {
		ID_Producer = iD_Producer;
		Name_Producer = name_Producer;
		
	}


	public Long getID_Producer() {
		return ID_Producer;
	}


	public void setID_Producer(Long iD_Producer) {
		ID_Producer = iD_Producer;
	}


	public String getName_Producer() {
		return Name_Producer;
	}


	public void setName_Producer(String name_Producer) {
		Name_Producer = name_Producer;
	}


	public Type_Item getTypeitem() {
		return typeitem;
	}


	public void setTypeitem(Type_Item typeitem) {
		this.typeitem = typeitem;
	}

	
}
