package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.entities.concretes.WorkingStyle;

public interface WorkingStyleService {

	DataResult<List<WorkingStyle>> getAll();
	
	DataResult <WorkingStyle> getById(int id);
}
