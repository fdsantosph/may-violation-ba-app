package com.fdsantosph.violation.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fdsantosph.violation.entities.NewDate;
import com.fdsantosph.violation.entities.Violation;

//public interface LocationRepository extends CrudRepository<Location, Integer> {
public interface NewDateRepository extends JpaRepository<NewDate, Integer> {

}
