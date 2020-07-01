package com.vedika.functionhall.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vedika.functionhall.model.Details;
import com.vedika.functionhall.model.StateResponse;
import com.vedika.functionhall.service.StateService;

@Controller
@RestController
@RequestMapping(value = "/states")
public class StateController {

	Logger logger = LoggerFactory.getLogger(StateController.class);

	@Autowired
	private StateService stateService;

	@PostMapping(value = "/cities")
	public ResponseEntity<?> saveOrUpdateOwner(@RequestBody Details details) {
		stateService.saveOrUpdateOwner(details);
		return new ResponseEntity("functionhall details added successfully", HttpStatus.OK);
	}

	@GetMapping(value = "")
	public List<Details> getBystate() {
		return stateService.findAll();
	}

	@GetMapping(value = "state")

	public StateResponse getstate(@RequestParam(value = "state", required = false) String state, StateResponse state1) {
		List<Details> details = stateService.findByState(state);

		if (null != details && !details.isEmpty()) {
			for (Details request : details) {
				StateResponse response = new StateResponse();
				response.setId(request.getId());
				response.setData(request.getData());
				return response;

			}
		}

		return null;

	}

}
