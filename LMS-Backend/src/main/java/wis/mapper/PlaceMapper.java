package wis.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wis.domain.Country;
import wis.domain.Place;
import wis.dto.CountryDTO;
import wis.dto.PlaceDTO;
import wis.service.PlaceService;

@Component
public class PlaceMapper implements Mapper<Place, PlaceDTO> {

	@Autowired
	PlaceService ps;

	@Override
	public PlaceDTO toDTO(Place entity) {
		if (entity == null) {
			return null;
		}

		PlaceDTO retVal = new PlaceDTO();

		retVal.setId(entity.getId());
		retVal.setName(entity.getName());

		return retVal;
	}

	@Override
	public Place toEntity(PlaceDTO placeDto) {
		if (placeDto == null) {
			return null;
		}
		Place retVal = new Place();

		retVal.setId(placeDto.getId());
		return retVal;
	}

	@Override
	public List<PlaceDTO> toDTO(List<Place> entityList) {
		if (entityList == null) {
			return null;
		}

		List<PlaceDTO> list = new ArrayList<PlaceDTO>(entityList.size());
		for (Place place : entityList) {
			list.add(toDTO(place));
		}

		return list;
	}

	@Override
	public Collection<Place> toEntityList(Collection<PlaceDTO> dtoList) {
		if (dtoList == null) {
			return null;
		}
		Collection<Place> collection = new ArrayList<Place>(dtoList.size());
		for (PlaceDTO place : dtoList) {
			collection.add(toEntity(place));
		}

		return collection;
	}

}
