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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="liquidation")
public class Liquidation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Liquidation;
	
	@Column(name="Title", nullable=true)
	private String Title;
	
	@Column(name="Date_Liquid", nullable=true)
	private String Date_Liquid;
	
	@Column(name="Cost_Per_Item", nullable=true)
	private double Cost_Per_Item;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_Liquidation", referencedColumnName = "ID_Liquidation")
	private List<Items> items = new ArrayList<>();

	public Liquidation() {
	}

	
	public Liquidation(Long iD_Liquidation, String title, String date_Liquid, double cost_Per_Item, List<Items> items) {
		ID_Liquidation = iD_Liquidation;
		Title = title;
		Date_Liquid = date_Liquid;
		Cost_Per_Item = cost_Per_Item;
		this.items = items;
	}


	public Liquidation(Long iD_Liquidation, String title, String date_Liquid, double cost_Per_Item) {
		ID_Liquidation = iD_Liquidation;
		Title = title;
		Date_Liquid = date_Liquid;
		Cost_Per_Item = cost_Per_Item;
	}

	public Long getID_Liquidation() {
		return ID_Liquidation;
	}

	public void setID_Liquidation(Long iD_Liquidation) {
		ID_Liquidation = iD_Liquidation;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDate_Liquid() {
		return Date_Liquid;
	}

	public void setDate_Liquid(String date_Liquid) {
		Date_Liquid = date_Liquid;
	}

	public double getCost_Per_Item() {
		return Cost_Per_Item;
	}

	public void setCost_Per_Item(double cost_Per_Item) {
		Cost_Per_Item = cost_Per_Item;
	}
	
	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
}
