package com.fdsantosph.violation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdsantosph.violation.entities.PlateNoToSearch;
import com.fdsantosph.violation.entities.Violation;
import com.fdsantosph.violation.service.ViolationService;

@Controller
public class ViolationController {
	
	@Autowired 
	ViolationService service;

//	@RequestMapping("/showCreate")
//	public String showCreate() {    
//		return "createLocation";    // createLocation.jsp - actual JSP Page, Prefix n Suffix configured in application.properties
//	}
	
	
	
//	@RequestMapping("/searchPlateNo")
//	public String showSearchPlateNo() {    
//		return "searchPlateNo";    // createLocation.jsp - actual JSP Page, Prefix n Suffix configured in application.properties
//	}
	
	@RequestMapping("/searchPlateNo")
	public String showSearchPlateNo(Model model) {  
		model.addAttribute("formData", new PlateNoToSearch());
		return "searchPlateNo";    // createLocation.jsp - actual JSP Page, Prefix n Suffix configured in application.properties
	}
	
	
	@RequestMapping("/showCreate2")
	public String showCreate2() {    
		return "createViolation";    // createLocation.jsp - actual JSP Page, Prefix n Suffix configured in application.properties
	}
	
	
	
	@RequestMapping("/saveVio")	
	public String saveViolation(@ModelAttribute("violation") Violation violation, ModelMap modelMap) { 
		Violation violationSaved = service.saveViolation(violation);
		String msg = "Violation saved with id: " + violationSaved.getId();
		modelMap.addAttribute("msg", msg);
		return "createViolation"; 
	}
	 
	@RequestMapping("/displayViolations")
	public String displayViolations(ModelMap modelMap) { 
		
		List<Violation> violations = service.getAllViolations();
		
		ArrayList<Violation> violationsList2 = new ArrayList<>();
		
		Violation v3 = violations.get(3);
		Violation v4 = violations.get(4);
		
		violationsList2.add(v3);
		violationsList2.add(v4);
		System.out.println("\nViolations List2 : " + violationsList2);
		
		
		for(int i=1 ;i<20 ;i++ ) {
			if("RA1580".equals(violations.get(i).getPlateNo())) {
			//System.out.println("\nFinally found it!" + " at id: " + i);
			System.out.println("\nPlate No.: " + (violations.get(i).getPlateNo()) + " has violations!" + " w/ id: " + (violations.get(i).getId() ));
			System.out.println("Details: " + violations.get(i));
		 }
		}
		
		modelMap.addAttribute("violations", violations);
//		modelMap.addAttribute("violations", violationsList2);
		
		return "displayViolations";    //  - actual JSP Page, Prefix n Suffix configured in application.properties
	}
	
	// ********************************************
	
	
	@RequestMapping("/displayViolations2")
	public String displayViolations2(ModelMap modelMap) { 
		
		List<Violation> violations = service.getAllViolations();
		
		ArrayList<Violation> violationsList2 = new ArrayList<>();
		
		
		String searchPlateNo = "RA1580";
		
//		Violation v3 = violations.get(3);
//		Violation v4 = violations.get(4);
//		
//		violationsList2.add(v3);
//		violationsList2.add(v4);
		System.out.println("\nViolations List2 : " + violationsList2);
		
		
		for(int i=1 ;i<=20 ;i++ ) {
			if(searchPlateNo.equals(violations.get(i).getPlateNo())) {
			//System.out.println("\nFinally found it!" + " at id: " + i);
			System.out.println("\nPlate No.: " + (violations.get(i).getPlateNo()) + " has violations!" + " w/ id: " + (violations.get(i).getId() ));
			System.out.println("Details: " + violations.get(i));
			
			violationsList2.add(violations.get(i));
			
		 }
		}
		
//		modelMap.addAttribute("violations", violations);
		modelMap.addAttribute("violations", violationsList2);
		
		return "displayViolations";    //  - actual JSP Page, Prefix n Suffix configured in application.properties
	}
	
	// ********************************************
	
	
	@RequestMapping("/displayViolations3")
	//public String displayViolations3(ModelMap modelMap) { 
	public String displayViolations3( @ModelAttribute ("plateNoToSearch") PlateNoToSearch plateNoToSearch, ModelMap modelMap) {
		
		List<Violation> violations = service.getAllViolations();
		
		ArrayList<Violation> violationsList2 = new ArrayList<>();
		
		
		//String searchPlateNo = "RA1580";
		
		String searchPlateNo = plateNoToSearch.getPlateNo();
		
//		Violation v3 = violations.get(3);
//		Violation v4 = violations.get(4);
//		
//		violationsList2.add(v3);
//		violationsList2.add(v4);
		System.out.println("\nViolations List2 : " + violationsList2);
		
		plateNoToSearch.setStatusFound(false);
//		for(int i=1 ;i<20 ;i++ ) {
		for(int i=1 ;i<violations.size() ;i++ ) {
			
//			plateNoToSearch.setStatusFound(false);
			
			if(searchPlateNo.equals(violations.get(i).getPlateNo())) {
			//System.out.println("\nFinally found it!" + " at id: " + i);
			System.out.println("\nPlate No.: " + (violations.get(i).getPlateNo()) + " has violations!" + " w/ id: " + (violations.get(i).getId() ));
			System.out.println("Details: " + violations.get(i));
			
			violationsList2.add(violations.get(i));
			plateNoToSearch.setStatusFound(true);
		 }else {
				//plateNoToSearch.setStatusFound(false);
			}
		} 
		System.out.println("\nisStatusFound == " + plateNoToSearch.isStatusFound() );
		modelMap.addAttribute("violations", violations);
		
		if (plateNoToSearch.isStatusFound() == true) {
//		if (plateNoToSearch.isStatusFound()) {
			modelMap.addAttribute("violations", violationsList2);
		}else if (plateNoToSearch.isStatusFound() == false) {
			return "noPlateNoFound";
		}
		
//		if(violationsList2 == null) {
//			return "noPlateNoFound";
//		}
		
		
		
		
		modelMap.addAttribute("violations", violationsList2);
		
		return "displayViolations";    //  - actual JSP Page, Prefix n Suffix configured in application.properties
	}
	
	// ***************** Start of Display v4  w/ ${msg} ***************************
	

	@RequestMapping("/displayViolations4")  
	//public String displayViolations4(ModelMap modelMap) { 
	public String displayViolations4( @ModelAttribute ("plateNoToSearch") PlateNoToSearch plateNoToSearch, ModelMap modelMap) {
	//public String displayViolations4( @ModelAttribute ("plateNoToSearch") PlateNoToSearch plateNoToSearch, ModelMap modelMap, Model theModel) {
		
		List<Violation> violations = service.getAllViolations();
		
		ArrayList<Violation> violationsList2 = new ArrayList<>();
		
		
		//String searchPlateNo = "RA1580";
		
    	String searchPlateNo = plateNoToSearch.getPlateNo(); // Original Search Key
//		String searchPlateNo = "RA1580";
		
//		Violation v3 = violations.get(3);
//		Violation v4 = violations.get(4);
//		
//		violationsList2.add(v3);
//		violationsList2.add(v4);
		System.out.println("\nViolations List2 : " + violationsList2);
		
		plateNoToSearch.setStatusFound(false);
//		for(int i=1 ;i<20 ;i++ ) {
		for(int i=1 ;i<violations.size() ;i++ ) {
			
//			plateNoToSearch.setStatusFound(false);
			
			if(searchPlateNo.equals(violations.get(i).getPlateNo())) {
				//System.out.println("\nFinally found it!" + " at id: " + i);
				System.out.println("\nPlate No.: " + (violations.get(i).getPlateNo()) + " has violations!" + " w/ id: " + (violations.get(i).getId() ));
				System.out.println("Details: " + violations.get(i));
				
				//add to the list
				violationsList2.add(violations.get(i));
				
				//add to the Spring Model
				//theModel.addAttribute("violationsList2", violationsList2);
				
				plateNoToSearch.setStatusFound(true);
		    }else {
				//plateNoToSearch.setStatusFound(false);
			}
		  } 
		  System.out.println("\nisStatusFound == " + plateNoToSearch.isStatusFound() );
		
//      nextline commented out as of 7:35 pm, July 14, 2021		
//		modelMap.addAttribute("violations", violations);
		
		if (plateNoToSearch.isStatusFound() == true) {
//		if (plateNoToSearch.isStatusFound()) {
			modelMap.addAttribute("violations", violationsList2);
			
			//add to the Spring Model as of 7:45 pm, July 14
			//theModel.addAttribute("violationsList2", violationsList2);
			return "displayViolations";
			
		}else if (plateNoToSearch.isStatusFound() == false) {
//		}else  {
			
			String msg = "No violation found! Great!! ";
			modelMap.addAttribute("msg", msg);
			
			
			//return "noPlateNoFound";
			//return "searchPlateNo";
			return "searchPlateNo2";
		}
		
//		if(violationsList2 == null) {
//			return "noPlateNoFound";
//		}
		
//		
		
		
		//modelMap.addAttribute("violations", violationsList2);
		
//		return "displayViolations";    //  - actual JSP Page, Prefix n Suffix configured in application.properties
	
		String msg = " ";
		modelMap.addAttribute("msg", msg);
		
		
		//return "noPlateNoFound";
		return "searchPlateNo";
	
	
	
	}
	
	
	
	
	// ********************************************
	
	@RequestMapping("/deleteViolation")
	public String deleteViolation(@RequestParam("id") int id, ModelMap modelMap) { 
		Violation violation = service.getViolationById(id);
		service.deleteViolation(violation);
		
		List<Violation> violations = service.getAllViolations();
		modelMap.addAttribute("violations", violations);
		;
		return "displayViolations";    // we will go back to this page
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {  
		Violation violation = service.getViolationById(id);
		modelMap.addAttribute("violation", violation);
		return "updateViolation";    // createLocation.jsp - actual JSP Page, Prefix n Suffix configured in application.properties
	}
	
	@RequestMapping("/updateViolation")
	public String updateViolation(@ModelAttribute("violation") Violation violation, ModelMap modelMap) {  
		
		service.updateViolation(violation);
		List<Violation> violations = service.getAllViolations();
		modelMap.addAttribute("violations", violations);
		
		return "displayViolations";    
	}
	
	
}





