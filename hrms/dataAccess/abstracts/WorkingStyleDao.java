package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkingStyle;

public interface WorkingStyleDao extends JpaRepository<WorkingStyle, Integer>{

	WorkingStyle findById(int id);
}
