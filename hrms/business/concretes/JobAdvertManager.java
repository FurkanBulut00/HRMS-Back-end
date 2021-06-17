package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.business.abstracts.WorkingStyleService;
import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.dto.JobAdvertDto;


@Service
public class JobAdvertManager implements JobAdvertService {
	
	private JobAdvertDao jobAdvertDao;
	private CityService cityService;
	private JobService jobService;
	private WorkingStyleService workingStyleService;
	private WorkingTypeService workingTypeService;
	private CompanyService companyService;
	

	

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, CityService cityService, JobService jobService,
			WorkingStyleService workingStyleService, WorkingTypeService workingTypeService, CompanyService companyService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.cityService = cityService;
		this.jobService = jobService;
		this.workingStyleService = workingStyleService;
		this.workingTypeService = workingTypeService;
		this.companyService = companyService;
	}

	@Override
	public Result add(JobAdvertDto jobAdvertDto) {
		if(!checkField(jobAdvertDto).isSuccess()) {
			
			return new ErrorResult("İş ilanı eklenemedi,Bilgileri kontrol ediniz.");
		}
		
		JobAdvert jobAdvert = new JobAdvert();
		
		jobAdvert.setJobDesription(jobAdvertDto.getJobDesription());
		jobAdvert.setLastApplyDate(jobAdvertDto.getLastApplyDate());
		jobAdvert.setActive(jobAdvertDto.isActive());
		jobAdvert.setOpenPositon(jobAdvertDto.getOpenPositon());
		jobAdvert.setSalaryMax(jobAdvertDto.getSalaryMax());
		jobAdvert.setSalaryMin(jobAdvertDto.getSalaryMin());
		jobAdvert.setConfirmed(jobAdvertDto.isConfirmed());
		jobAdvert.setCity(cityService.getById(jobAdvertDto.getCityId()).getData());
		jobAdvert.setJob(jobService.getById(jobAdvertDto.getJobId()).getData());
		jobAdvert.setCompany(companyService.getById(jobAdvertDto.getCompanyId()).getData());
		jobAdvert.setWorkingStyle(workingStyleService.getById(jobAdvertDto.getWorkingStyleId()).getData());
		jobAdvert.setWorkingType(workingTypeService.getById(jobAdvertDto.getWorkingTypeId()).getData());
		
		jobAdvertDao.save(jobAdvert);
		
		
		return new SuccessResult("İş ilanı eklendi");
		}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Basarili bir sekilde güncellendi.");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("Basarili bir sekilde silindi.");
	}

	@Override
	public Result changeActiveToPassive(int id) {
		if(getById(id)==null) {
			return new ErrorResult("Sectiginiz ilan bulunamadı.");
		}
		if(getById(id).getData().isActive()==false) {
			return new ErrorResult("Sectiginiz ilan zaten kapalı!");
		}
		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setActive(false);
		update(jobAdvert);
		
		return new SuccessResult("Sectiginiz ilan pasif hale getirildi.");
	}
	
	private Result checkField(JobAdvertDto jobAdvertDto) {
		if(jobAdvertDto.getCityId()==0  || jobAdvertDto.getJobDesription()==null || jobAdvertDto.getJobId()== 0) {
			return new ErrorResult();
		}
		if(jobAdvertDto.getJobDesription().equals("")) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAdvert>> findByIsActiveTrue() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveTrue(),"Aktif ilanlar listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPostedDate() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveTrueOrderByPostedDate(),"Aktif ilanlar tarihe göre sıralandı");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertByCompany(int id) {
	
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllActiveJobAdvertByCompany(id),"Şirkete ait tüm ilanlar listelendi");
	}

	@Override
	public Result changeConfirmFalseToTrue(int id) {
		
		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setConfirmed(true);
		update(jobAdvert);
		
		return new SuccessResult("İlan onaylandı");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByJobAdvertIsConfirmedFalse() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllByJobAdvertIsConfirmedFalse());
	}
	
	

}
