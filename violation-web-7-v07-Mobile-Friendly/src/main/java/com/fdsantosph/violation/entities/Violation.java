package com.fdsantosph.violation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="violation_table")
public class Violation {
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "plate_no")
	private String plateNo;

	@Column(name = "violation")
	private String violationEntry;

	@Column(name = "street")
	private String street;

	@Column(name = "date")
	private String date;

	@Column(name = "time")
	private String time;

	@Column(name = "status")
	private String status;

	public Violation() {
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


	public String getViolationEntry() {
		return violationEntry;
	}

	public void setViolationEntry(String violationEntry) {
		this.violationEntry = violationEntry;
	}
	
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Violation [id=" + id + ", plateNo=" + plateNo + ", violationEntry=" + violationEntry + ", street="
				+ street + ", date=" + date + ", time=" + time + ", status=" + status + "]";
	}


	
	
}

