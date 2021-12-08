package com.fdsantosph.violation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdsantosph.violation.entities.NewDate;
import com.fdsantosph.violation.entities.Violation;
import com.fdsantosph.violation.repository.NewDateRepository;
import com.fdsantosph.violation.repository.ViolationRepository;

@Service
public class NewDateServiceImpl implements NewDateService {

	@Autowired
	private NewDateRepository repository;
	
	@Override
	public NewDate saveNewDate(NewDate newDate) {
		return repository.save(newDate);
	}

	@Override
	public NewDate updateNewDate(NewDate newDate) {
		return repository.save(newDate);
	}

	@Override
	public void deleteNewDate(NewDate newDate) {
		repository.delete(newDate);
	}

	@Override
	public NewDate getNewDateById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<NewDate> getAllNewDates() {
		return repository.findAll();
	}

}
