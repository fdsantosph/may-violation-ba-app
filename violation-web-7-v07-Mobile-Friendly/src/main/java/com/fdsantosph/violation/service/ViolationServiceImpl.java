package com.fdsantosph.violation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdsantosph.violation.entities.Violation;
import com.fdsantosph.violation.repository.ViolationRepository;

@Service
public class ViolationServiceImpl implements ViolationService {

	@Autowired
	private ViolationRepository repository;
	
	@Override
	public Violation saveViolation(Violation violation) {
		return repository.save(violation);
	}

	@Override
	public Violation updateViolation(Violation violation) {
		return repository.save(violation);
	}

	@Override
	public void deleteViolation(Violation violation) {
		repository.delete(violation);
	}

	@Override
	public Violation getViolationById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Violation> getAllViolations() {
		return repository.findAll();
	}

}
