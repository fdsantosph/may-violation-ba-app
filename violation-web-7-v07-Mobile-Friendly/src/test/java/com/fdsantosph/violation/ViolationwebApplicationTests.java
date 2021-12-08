package com.fdsantosph.violation;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fdsantosph.violation.entities.Violation;
import com.fdsantosph.violation.service.ViolationService;

@SpringBootTest
class ViolationwebApplicationTests {

	@Autowired 
	ViolationService service;
	
	@Test
	void contextLoads() {
	}

	@Test
	void testFindViolation() {
		
//		Violation violationById = service.getViolationById(1);
//		System.out.println("\nViolation by Id: " + violationById);
		
//		List<Violation> violations3 = (List<Violation>) service.getViolationById(1);
		
		Integer id = service.getViolationById(2).getId();
		System.out.println("Id violation is: " + id);
		
		
//		System.out.println();
//		System.out.println("\nViolations3 COLLECTION: " +  violations3);
//		System.out.println("Hello World");
	}
	
	
}
