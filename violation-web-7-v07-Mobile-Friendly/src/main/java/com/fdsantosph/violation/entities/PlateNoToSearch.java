package com.fdsantosph.violation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PlateNoToSearch_table")
public class PlateNoToSearch {
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "plate_no")
	private String plateNo;

	@Column(name = "statusFound")
	private boolean statusFound;

	public PlateNoToSearch() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public boolean isStatusFound() {
		return statusFound;
	}

	public void setStatusFound(boolean statusFound) {
		this.statusFound = statusFound;
	}

//	public boolean isStatusFound() {
//		return statusFound;
//	}
//
//	public boolean setStatusFound(boolean statusFound) {
//		return this.statusFound = statusFound;
//	}

	
	
	

	
	
	
}

