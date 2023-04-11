package io.jrovieri.kitanda.api.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface CategoryMapper {

	CategoryOutput toDto(Category input);
	
	@Mapping(target = "id", ignore = true)
	Category toEntityCreate(CategoryInput input);
	
	@Mapping(target = "id", ignore = true)
	Category toEntityUpdate(@MappingTarget Category category, CategoryInput input);
	
}
