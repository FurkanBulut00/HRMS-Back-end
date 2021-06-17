package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingStyleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkingStyleDao;
import kodlamaio.hrms.entities.concretes.WorkingStyle;

@Service
public class WorkingStyleManager implements WorkingStyleService {

	private WorkingStyleDao workingStyleDao;
	
	@Autowired
	public WorkingStyleManager(WorkingStyleDao workingStyleDao) {
		super();
		this.workingStyleDao = workingStyleDao;
	}


	@Override
	public DataResult<List<WorkingStyle>> getAll() {
		
		return new SuccessDataResult<List<WorkingStyle>>(this.workingStyleDao.findAll());
	}


	@Override
	public DataResult<WorkingStyle> getById(int id) {
		
		return new SuccessDataResult<WorkingStyle>(this.workingStyleDao.findById(id));
	}

}
