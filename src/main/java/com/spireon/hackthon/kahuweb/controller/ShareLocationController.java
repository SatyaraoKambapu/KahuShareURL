package com.spireon.hackthon.kahuweb.controller;

import com.spireon.hackthon.kahuweb.service.TrackVehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ShareLocationController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	TrackVehicleService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/track", method = RequestMethod.GET)
	public String showTodos(@RequestParam("id") String id, @RequestParam("requestId") String requestId) {
		logger.info("Id=" + id + " and " + "requestId=" + requestId);
		if(!StringUtils.isEmpty(id)) {
			String[] vinsArray = id.split(",");
			for (String vin: vinsArray) {
				logger.info("VIN = " + vin);
			}

		}
		return "track-map";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}

}
