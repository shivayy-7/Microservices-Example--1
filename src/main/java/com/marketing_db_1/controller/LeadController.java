package com.marketing_db_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing_db_1.dto.LeadData;
import com.marketing_db_1.entities.Lead;
import com.marketing_db_1.services.LeadService;
import com.marketing_db_1.utils.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/viewPage")
	public String viewSaveLeadPage() {
		return"new_lead";
	}
	
	
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute Lead lead, ModelMap model) {
		leadService.saveLead(lead);
		emailService.sendSimpleMessage(lead.getEmail(), "text", "Lead is saved!!");
		model.addAttribute("msg", "Lead is saved");
		return "new_lead";
	}
	
	@RequestMapping("/listall")
	public String listAll(ModelMap model) {
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_search_result";
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id, ModelMap model) {
		leadService.deleteLead(id);
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_search_result";
	}
	
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadService.findOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateLead(@ModelAttribute Lead lead, ModelMap model) {
		leadService.saveLead(lead);
		
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_search_result";
	}
	

}
