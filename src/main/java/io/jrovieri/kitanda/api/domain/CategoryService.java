package io.jrovieri.kitanda.api.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryMapper categoryMapper;
	
	private final CategoryRepository categoryRepository;
	
	public CategoryOutput findById(Long id) {
		Category category = findOne(id);
		return categoryMapper.toDto(category);
	}
	
	public CategoryOutput save(CategoryInput input) {
		Category category = categoryMapper.toEntityCreate(input);
		Category savedCategory = categoryRepository.save(category);
		return categoryMapper.toDto(savedCategory);
	}
	
	public CategoryOutput update(Long id, CategoryInput input) {
		Category category = findOne(id);
		Category updatedCategory = categoryMapper.toEntityUpdate(category, input);
		Category savedCategory = categoryRepository.save(updatedCategory);
		return categoryMapper.toDto(savedCategory);
	}
	
	public List<CategoryOutput> list() {
		return categoryRepository.findAll()
				.stream()
				.map(category -> categoryMapper.toDto(category))
				.toList();
	}
	
	public Category findOne(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (!category.isPresent())
			throw new ResourceNotFoundException("Category not found");
		return category.get();
	}
}
