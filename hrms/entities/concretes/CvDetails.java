package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cv")
public class CvDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private int cvId;

//	@Column(name = "candidate_id")
//	private int candidateId;

	@Column(name = "details")
	private String details;

	@Column(name = "is_active")
	private boolean isActive=true;

	@Column(name = "last_update_date")
	private LocalDate lastUpdateDate;

	@Column(name = "made_date")
	private LocalDate madeDate;

//	@OneToMany(mappedBy = "cv")
//	private List<CvLanguage> cvLanguage;
//
//	@OneToMany(mappedBy = "cv")
//	private List<CvExperience> cvExperience;
//
//	@OneToMany(mappedBy = "cv")
//	private List<CvLink> cvLink;
//
//	@OneToMany(mappedBy = "cv")
//	private List<CvPhoto> cvPhoto;
//
//	@OneToMany(mappedBy = "cv")
//	private List<CvSchool> cvSchool;
//
//	@OneToMany(mappedBy = "cv")
//	private List<ProgramingTechnology> programingTechnology;
//
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Candidate candidate;

}
