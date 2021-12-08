package com.fdsantosph.violation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdsantosph.violation.entities.PlateNoToSearch;
import com.fdsantosph.violation.entities.Violation;
import com.fdsantosph.violation.service.NewDateService;
import com.fdsantosph.violation.service.ViolationService;

@Controller
public class ViolationController {
	
	@Autowired 
	ViolationService service;
	
	@Autowired
	NewDateService newDateService;

	@RequestMapping("/showAllViolations")
	public String displayAllViolations(ModelMap modelMap) { 
		List<Violation> violations_list = service.getAllViolations();
		modelMap.addAttribute("violations_name", violations_list);
		return "displayAllViolations";
	}
	
	//@RequestMapping("/searchPlateNo")
	//@RequestMapping("/mayviolationba")
	@RequestMapping("/")
	public String searchPlateNo(Model model) {  
		model.addAttribute("formData", new PlateNoToSearch());
		
		//added for the new_date
		String new_date = newDateService.getNewDateById(1).getNewUpdatedDate();
		model.addAttribute("new_date", new_date);
		
		//return "searchPlateNo"; 
		return "index";
	}
	
	
	// **** Start for Native Queries

	@RequestMapping("/showViolations")  
	public String showViolations( Model model, @Param("plateNo") String plateNo) {
		
		//added for trim start and end spaces
		plateNo = plateNo.trim();
		
		//added for trim inbetween spaces
		plateNo = plateNo.replaceAll("\\s+","");
		
		//added for upper case
		plateNo = plateNo.toUpperCase();
		System.out.println("Searched Plate Number= " + plateNo);
		
		List<Violation> violationsList2 = service.findByPlateNo(plateNo);
		
		model.addAttribute("violations", violationsList2);
		
		//added for the new_date
		String new_date = newDateService.getNewDateById(1).getNewUpdatedDate();
		model.addAttribute("new_date", new_date);

		//Set statusFound to false
		//plateNoToSearch.setStatusFound(false);
		boolean isPlateFound = false;
		
		if (violationsList2.size() > 0) {
			isPlateFound = true;
		}
		
		if (isPlateFound == true) {
				
				Integer numberOfViolations = violationsList2.size();
				model.addAttribute("numberOfViolations", numberOfViolations);
				
				model.addAttribute("searchedPlateNo", plateNo);
				
				//added for singular and plural concerns for number of violations
				String violationAsSingularOrPlural = "violations.";
				if (numberOfViolations == 1) {
					//return "displayViolation";
					violationAsSingularOrPlural = "Violation.";
					
				}else {
					//return "displayViolations";
					violationAsSingularOrPlural = "Violations.";
				}
				model.addAttribute("violationAsSingularOrPlural", violationAsSingularOrPlural);
				
				//deleted for the option above whether to go singular or plural for number of violations
				return "displayViolations";
				
			}else if (isPlateFound == false) {
				
				String searchedPlateNo = plateNo;
				model.addAttribute("searchedPlateNo", searchedPlateNo);
				return "searchPlateNo-result-wala";
			}
		
		return "displayViolations";

	}
	
}





