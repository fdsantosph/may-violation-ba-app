package com.fdsantosph.violation.service;

import java.util.List;

import com.fdsantosph.violation.entities.NewDate;
import com.fdsantosph.violation.entities.Violation;

public interface NewDateService {

	NewDate saveNewDate(NewDate newDate);

	NewDate updateNewDate(NewDate newDate);

	void deleteNewDate(NewDate newDate);

	NewDate getNewDateById(int id);

	List<NewDate> getAllNewDates();

}
