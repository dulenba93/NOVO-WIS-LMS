package wis.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wis.domain.Address;
import wis.domain.Place;
import wis.dto.AddressDTO;
import wis.dto.PlaceDTO;

@Component
public class AddressMapper implements Mapper<Address, AddressDTO>{
	
	@Autowired
	PlaceMapper placeMapper;

	@Override
	public AddressDTO toDTO(Address address) {
		// TODO Auto-generated method stub
		AddressDTO retVal = new AddressDTO();
		retVal.setId(address.getId());
		retVal.setStreet(address.getStreet());
		retVal.setNumber(address.getNumber());
		retVal.setPlaceDto(new PlaceDTO());
		retVal.setPlaceDto(placeMapper.toDTO(address.getPlace()));

		return retVal;
	}

	@Override
	public Address toEntity(AddressDTO edto) {
		// TODO Auto-generated method stub
		if (edto == null) {
			return null;
		}
		Address retVal = new Address();

		retVal.setId(edto.getId());
		return retVal;
	}

	@Override
	public List<AddressDTO> toDTO(List<Address> es) {
		// TODO Auto-generated method stub
		if (es == null) {
			return null;
		}

		List<AddressDTO> list = new ArrayList<AddressDTO>(es.size());
		for (Address address : es) {
			list.add(toDTO(address));
		}

		return list;
	}

	@Override
	public Collection<Address> toEntityList(Collection<AddressDTO> edtos) {
		if (edtos == null) {
			return null;
		}
		Collection<Address> collection = new ArrayList<Address>(edtos.size());
		for (AddressDTO address : edtos) {
			collection.add(toEntity(address));
		}

		return collection;
	}
	

}
