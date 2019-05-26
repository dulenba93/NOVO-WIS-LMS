package wis.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 64)
	private String firstName;

	@Column(length = 64)
	private String lastName;

	@Column(length=64, nullable = false)
	private String email;
	
	@OneToOne
	@JoinColumn(name="accountId")
	private Accounts account;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;

	@Size(max = 20)
	private String personalIdentificationNumber;

	@NotNull
	private Boolean deleted = false;
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseTeaching> courseTeachings;

	//proveriti ovo
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Title> title;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Faculty facultyDekan;
	
	@OneToOne(fetch = FetchType.LAZY)
	private University universityRektor;
	
	@OneToOne(fetch = FetchType.LAZY)
	private StudyProgram StudyProgramRukovodilac;
	
	@Version
	private int version = 0;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<CourseTeaching> getCourseTeachings() {
		return courseTeachings;
	}

	public void setCourseTeachings(Set<CourseTeaching> courseTeachings) {
		this.courseTeachings = courseTeachings;
	}

	public Set<Title> getTitle() {
		return title;
	}

	public void setTitle(Set<Title> title) {
		this.title = title;
	}

	public Faculty getFacultyDekan() {
		return facultyDekan;
	}

	public void setFacultyDekan(Faculty facultyDekan) {
		this.facultyDekan = facultyDekan;
	}

	public University getUniversityRektor() {
		return universityRektor;
	}

	public void setUniversityRektor(University universityRektor) {
		this.universityRektor = universityRektor;
	}

	public StudyProgram getStudyProgramRukovodilac() {
		return StudyProgramRukovodilac;
	}

	public void setStudyProgramRukovodilac(StudyProgram studyProgramRukovodilac) {
		StudyProgramRukovodilac = studyProgramRukovodilac;
	}

	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Teacher object = (Teacher) o;
		if (object.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, object.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
