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

	
	
}
