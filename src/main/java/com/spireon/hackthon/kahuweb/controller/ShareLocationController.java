package com.spireon.hackthon.kahuweb.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.spireon.hackthon.kahuweb.model.AssetDto;
import com.spireon.hackthon.kahuweb.model.CollectionResource;
import com.spireon.hackthon.kahuweb.model.LocationDto;
import com.spireon.hackthon.kahuweb.service.TrackVehicleService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
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
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@Controller
public class ShareLocationController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TrackVehicleService service;

	@Autowired
	RestTemplate restTemplate;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/track", method = RequestMethod.GET)
	public String trackVehicles(@RequestParam("id") String id, @RequestParam("requestId") String requestId, ModelMap model) {
		logger.info("Id=" + id + " and " + "requestId=" + requestId);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Basic bmV3ZGVhbGVyOnBhc3N3b3Jk");
		headers.set("x-nspire-apptoken", "16075371-9da2-4ee4-8a37-a8d17daa0824");

		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(URI.create("http://amw1identity1.stage.spireon.com/identity/token"), HttpMethod.GET, httpEntity, String.class);
		String identityToken  = responseEntity.getBody();

		JSONObject jsonObject = new JSONObject(identityToken);

		String token = (String) jsonObject.get("token");

		logger.info("Jwt Token: " + token);
		if(!StringUtils.isEmpty(id)) {
			String[] vinsArray = id.split(",");
			for (String vin: vinsArray) {
				logger.info("VIN = " + vin);
				headers = new HttpHeaders();
				headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
				headers.set("x-nspire-usertoken", token);
				httpEntity = new HttpEntity<>(headers);
				ParameterizedTypeReference<CollectionResource<AssetDto>> typeReference = new ParameterizedTypeReference<CollectionResource<AssetDto>>() {};
				ResponseEntity<CollectionResource<AssetDto>> assetResponseEntity = restTemplate.exchange(URI.create("https://platformapi-stage.spireon.com/v0/rest/assets?vin=" + vin + "&limit=1"), HttpMethod.GET, httpEntity, typeReference);
				CollectionResource<AssetDto> assetDtoCollectionResource = assetResponseEntity.getBody();
				if(assetDtoCollectionResource != null) {
					AssetDto assetDto = assetDtoCollectionResource.getContent().get(0);
					LocationDto locationDto = assetDto.getLastLocation();
					if(locationDto != null) {

						Double lat = locationDto.getLat();
						Double lng = locationDto.getLng();

						logger.info("lat = "  + lat + " and lng = " + lng);

					}

				}
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
