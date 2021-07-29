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
@Table(name="items")
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Item;
	
	@Column(name="Name_Item", nullable=true)
	private String Name_Item;
	
	@Column(name="Unit", nullable=true)
	private String Unit;
	
	@Column(name="Warranty_Period", nullable=true)
	private int Warranty_Period;
	
	@Column(name="Warranty_Unit", nullable=true)
	private String Warranty_Unit;
	
	@Column(name="New_Broken", nullable=true)
	private String New_Broken;
	
	@Column(name="Status", nullable=true)
	private String Status;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_Item", referencedColumnName = "ID_Item")
	private List<Specification> speci = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "ID_Type_Item")
	private Type_Item typeitem;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_Location")
	private Location location;
	
	@ManyToOne
	@JoinColumn(name = "ID_Liquidation")
	private Liquidation liquidation;
	
	
	public Items() {
	}
	

	public Items(Long iD_Item, String name_Item, String unit, int warranty_Period, String warranty_Unit,
			String new_Broken, String status, List<Specification> speci, Type_Item typeitem, Location location,
			Liquidation liquidation) {
		ID_Item = iD_Item;
		Name_Item = name_Item;
		Unit = unit;
		Warranty_Period = warranty_Period;
		Warranty_Unit = warranty_Unit;
		New_Broken = new_Broken;
		Status = status;
		this.speci = speci;
		this.typeitem = typeitem;
		this.location = location;
		this.liquidation = liquidation;
	}




	public Items(Long iD_Item, String name_Item, String unit, int warranty_Period, String warranty_Unit,
			String new_Broken, String status, List<Specification> speci, Type_Item typeitem) {
		ID_Item = iD_Item;
		Name_Item = name_Item;
		Unit = unit;
		Warranty_Period = warranty_Period;
		Warranty_Unit = warranty_Unit;
		New_Broken = new_Broken;
		Status = status;
		this.speci = speci;
		this.typeitem = typeitem;
		//this.location = location;
		//this.liquidation = liquidation;
	}

	public Long getID_Item() {
		return ID_Item;
	}

	public void setID_Item(Long iD_Item) {
		ID_Item = iD_Item;
	}

	public String getName_Item() {
		return Name_Item;
	}

	public void setName_Item(String name_Item) {
		Name_Item = name_Item;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public int getWarranty_Period() {
		return Warranty_Period;
	}

	public void setWarranty_Period(int warranty_Period) {
		Warranty_Period = warranty_Period;
	}

	public String getWarranty_Unit() {
		return Warranty_Unit;
	}

	public void setWarranty_Unit(String warranty_Unit) {
		Warranty_Unit = warranty_Unit;
	}

	public String getNew_Broken() {
		return New_Broken;
	}

	public void setNew_Broken(String new_Broken) {
		New_Broken = new_Broken;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public List<Specification> getSpeci() {
		return speci;
	}

	public void setSpeci(List<Specification> speci) {
		this.speci = speci;
	}

	public Type_Item getTypeitem() {
		return typeitem;
	}

	public void setTypeitem(Type_Item typeitem) {
		this.typeitem = typeitem;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Liquidation getLiquidation() {
		return liquidation;
	}

	public void setLiquidation(Liquidation liquidation) {
		this.liquidation = liquidation;
	}
	
	public void addSpecification(String name, String value) {
		this.speci.add(new Specification(name, value, this));
	}
	
	public void setSpecification(Long id, String name, String value) {
		this.speci.add(new Specification(id,name,value,this));
	}
	
}
