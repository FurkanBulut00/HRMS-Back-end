package kodlamaio.hrms.entities.concretes;

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
@Table(name="cv_links")
public class CvLink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_link_id")
	private int cvLinkId;
	
//	@Column(name="cv_id")
//	private int cvId;
	
	@Column(name="link_name")
	private String linkName;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private Candidate candidate;
}
