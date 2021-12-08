package com.fdsantosph.violation.repository;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fdsantosph.violation.entities.Violation;

public interface ViolationRepository extends JpaRepository<Violation, Integer> {
	
	@Query("SELECT v "
			+ "FROM Violation v "
			+ "WHERE v.plateNo = ?1")
	public List<Violation> findAll(String plateNoToSearch); 
	
}
