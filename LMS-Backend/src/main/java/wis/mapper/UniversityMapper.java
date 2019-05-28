package wis.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wis.domain.University;
import wis.dto.AddressDTO;
import wis.dto.UniversityDTO;

@Component
public class UniversityMapper  implements Mapper<University, UniversityDTO> {
	
	@Autowired
	AddressMapper addressMapper;

	@Override
	public UniversityDTO toDTO(University university) {
		// TODO Auto-generated method stub
		if(university == null) {
			return null;
		}
		
		UniversityDTO retVal = new UniversityDTO();
			retVal.setId(university.getId());
			retVal.setName(university.getName());
			retVal.setDescription(university.getDescription());
			retVal.setEstablishmentDate(university.getYearOfEstablishment());
			retVal.setVersion(university.getVersion());
			retVal.setAddress(new AddressDTO());
			retVal.setAddress(addressMapper.toDTO(university.getAddress()));

			return retVal;
	}

	@Override
	public University toEntity(UniversityDTO universityDto) {
		// TODO Auto-generated method stub
		
		if(universityDto == null) {
			return null;		
		}
		
		University university = new University();
		
		university.setId(universityDto.getId());
		university.setDescription(universityDto.getDescription());
		university.setYearOfEstablishment(universityDto.getEstablishmentDate());
		university.setName(universityDto.getName());
		university.setAddress(addressMapper.toEntity(universityDto.getAddress()));
		university.setVersion(universityDto.getVersion());
		
		return university;
	}

	@Override
	public List<UniversityDTO> toDTO(List<University> university) {
		// TODO Auto-generated method stub
		
		if(university == null) {
			return null;
		}
		
		List<UniversityDTO > retVal = new ArrayList<UniversityDTO >();
		for (University universities: university) {
			retVal.add(toDTO(universities));
		}
		return retVal;
	}

	@Override
	public Collection<University> toEntityList(Collection<UniversityDTO> universityDto) {
		// TODO Auto-generated method stub
		if(universityDto == null) {
			return null;
		}
		
		Collection<University> university = new ArrayList<University>(universityDto.size());
		for(UniversityDTO uDto: universityDto) {
			university.add(toEntity(uDto));
		}
		
		return university;
	}

}
