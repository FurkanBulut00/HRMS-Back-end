package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkingStyleService;
import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.entities.concretes.WorkingStyle;

@RestController
@RequestMapping("/api/workingStyles")
@CrossOrigin
public class WorkingStyleController {

	private WorkingStyleService workingStyleService;

	@Autowired
	public WorkingStyleController(WorkingStyleService workingStyleService) {
		super();
		this.workingStyleService = workingStyleService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkingStyle>> getAll(){
		return this.workingStyleService.getAll();
	}
}
