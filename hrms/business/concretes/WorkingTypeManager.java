package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTypeDao;
import kodlamaio.hrms.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager implements WorkingTypeService{

	private WorkingTypeDao workingTypeDao;
	
	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		super();
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		
		return new SuccessDataResult<List<WorkingType>>(this.workingTypeDao.findAll());
	}

	@Override
	public DataResult<WorkingType> getById(int id) {
		
		return new SuccessDataResult<WorkingType>(this.workingTypeDao.findById(id));
	}

}
