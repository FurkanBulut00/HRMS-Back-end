package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkingType;

@RestController
@RequestMapping("/api/workingTypes")
@CrossOrigin
public class WorkingTypeController {

	private WorkingTypeService workingTypeService;

	@Autowired
	public WorkingTypeController(WorkingTypeService workingTypeService) {
		super();
		this.workingTypeService = workingTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkingType>> getAll(){
		return this.workingTypeService.getAll();
	}
	
}
