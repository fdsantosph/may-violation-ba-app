package com.fdsantosph.violation.service;

import java.util.List;

import com.fdsantosph.violation.entities.Violation;

public interface ViolationService {

	Violation saveViolation(Violation violation);

	Violation updateViolation(Violation violation);

	void deleteViolation(Violation violation);

	Violation getViolationById(int id);

	List<Violation> getAllViolations();
	
	List<Violation> findByPlateNo(String plateNoToSearch);

}
