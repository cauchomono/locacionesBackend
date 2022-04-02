package com.forero.locaciones.model;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.ListArrayType;


@Entity
@Table (name  = "locacion")
@TypeDef(
	    name = "list-array",
	    typeClass = ListArrayType.class
	)
public class Locacion {

	@Id 
	public String name;
	public int area_m2;
	
	
	
	@ManyToOne
	@JoinColumn(name="parentLocation",referencedColumnName = "name")
	@JsonIgnoreProperties("internLocations")
	private Locacion parentLocation;

	
	@OneToMany(mappedBy = "parentLocation")
	@JsonIgnoreProperties("parentLocation")
	private List<Locacion> internLocations ;
	
	
	
	public Locacion(){
		
	}
	
	public void setParentLocation(Locacion parentLoc) {
		this.parentLocation = parentLoc;
	}

	public List<Locacion> getInternLocations() {
		return internLocations;
	}

	public void setInternLocations(List<Locacion> internLocations) {
		this.internLocations = internLocations;
	}

	public Locacion getParentLocation() {
		return parentLocation;
	}
	
	
}

