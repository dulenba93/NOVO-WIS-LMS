package wis.mapper;

import java.util.Collection;
import java.util.List;

public interface Mapper<E, EDTO> {
	
	EDTO toDTO(E e);
	E toEntity(EDTO edto);
	List<EDTO> toDTO(List<E> es);
	Collection<E> toEntityList(Collection<EDTO> edtos);
}
