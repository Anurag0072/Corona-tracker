package com.coronaTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coronaTracker.models.LocationStats;
import com.coronaTracker.service.Coronaservices;

@Controller
public class HomeController {
	@Autowired
	Coronaservices service;
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allstats = Coronaservices.getAllStats();
		int totalReportedCases = allstats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalNewCases = allstats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		model.addAttribute("locationStats",allstats);
		model.addAttribute("totalReportedCases",totalReportedCases);
		model.addAttribute("totalNewCases", totalNewCases);
		
		return "home";
	}

}
