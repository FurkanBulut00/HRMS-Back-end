package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {

	@Column(name = "first_name")
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name = "national_id")
	public String nationalityId;

	@Column(name = "birth_year")
	public String birthYear;

	public Candidate(int id, String email, String password, String firstName, String lastName, String nationalityId,
			String birthYear) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.birthYear = birthYear;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvLanguage> cvLanguage;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvExperience> cvExperience;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvLink> cvLink;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvPhoto> cvPhoto;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvSchool> cvSchool;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ProgramingTechnology> programingTechnology;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvDetails> cvDetails;

}
