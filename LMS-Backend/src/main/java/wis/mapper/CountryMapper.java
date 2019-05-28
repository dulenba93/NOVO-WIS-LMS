package wis.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wis.domain.Country;
import wis.domain.Place;
import wis.dto.CountryDTO;
import wis.service.PlaceService;

@Component
public class CountryMapper implements Mapper<Country, CountryDTO> {
	
	@Autowired
	PlaceService ps;
	
	@Override
	public CountryDTO toDTO(Country entity) {
		if (entity == null) {
		    return null;
		}

		CountryDTO retVal = new CountryDTO();

		retVal.setId(entity.getId());
		retVal.setName(entity.getName());
		retVal.setPlaces(new ArrayList<>());
		for(Place place : entity.getPlace()) {
			retVal.getPlaces().add("/place" + place.getId());
		}

		return retVal;
	}

	@Override
	public Country toEntity(CountryDTO countryDto) {
		if (countryDto == null) {
	    	return null;
		}
		Country retVal = new Country();

		retVal.setId(countryDto.getId());
		return retVal;
	}

	@Override
	public List<CountryDTO> toDTO(List<Country> entityList) {
		 if ( entityList == null ) {
		        return null;
		    }

		    List<CountryDTO> list = new ArrayList<CountryDTO>(entityList.size());
		    for (Country country : entityList) {
		    	list.add(toDTO(country));
		    }

		    return list;
	}

	@Override
	public Collection<Country> toEntityList(Collection<CountryDTO> dtoList) {
		if ( dtoList == null ) {
	        return null;
	    }
	    Collection<Country> collection = new ArrayList<Country>(dtoList.size());
	    for (CountryDTO country : dtoList) {
	        collection.add(toEntity(country));
	    }

	    return collection;
	}

}
