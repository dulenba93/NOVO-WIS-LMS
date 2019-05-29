package wis.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import wis.domain.Administrative;
import wis.dto.AdministrativeDTO;

@Component
public class AdministrativeMapper implements Mapper<Administrative, AdministrativeDTO>{

	@Override
	public AdministrativeDTO toDTO(Administrative entity) {
		if (entity == null) {
			return null;
		}
		
		AdministrativeDTO retVal = new AdministrativeDTO();
		
		retVal.setId(entity.getId());
		retVal.setEmail(entity.getEmail());
		retVal.setFirstName(entity.getFirstName());
		retVal.setLastName(entity.getLastName());
		retVal.setPersonalIdentificationNumber(entity.getPersonalIdentificationNumber());
		
		return retVal;
	}

	@Override
	public Administrative toEntity(AdministrativeDTO edto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdministrativeDTO> toDTO(List<Administrative> entityList) {
		if(entityList == null) {
			return null;
		}
		
		List<AdministrativeDTO> list = new ArrayList<AdministrativeDTO>(entityList.size());
		for (Administrative administration : entityList) {
			list.add(toDTO(administration));
		}
		
		return list;
	}

	@Override
	public Collection<Administrative> toEntityList(Collection<AdministrativeDTO> edtos) {
		// TODO Auto-generated method stub
		return null;
	}

}
