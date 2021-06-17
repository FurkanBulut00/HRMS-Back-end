package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.dto.JobAdvertDto;

public interface JobAdvertService {
	
	
	Result add(JobAdvertDto jobAdvertDto);
	Result update(JobAdvert jobAdvert);
	Result delete(int id);
	Result changeActiveToPassive(int id);
	
	Result changeConfirmFalseToTrue(int id);
	
	DataResult<JobAdvert> getById(int id);
	
	DataResult<List<JobAdvert>> findByIsActiveTrue();
	
	DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPostedDate();
	
	DataResult <List<JobAdvert>> getAllByJobAdvertIsConfirmedFalse();
	
	DataResult<List<JobAdvert>> getAllActiveJobAdvertByCompany(int id);
}

