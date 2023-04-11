package io.jrovieri.kitanda.api.domain;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@GetMapping("{id}")
	public CategoryOutput getOne(@PathVariable(required = true) Long id) {
		return categoryService.findById(id);
	}
	
	@PostMapping
	public CategoryOutput create(@RequestBody CategoryInput input) {
		return categoryService.save(input);
	}
	
	@PutMapping("{id}")
	public CategoryOutput update(@PathVariable(required = true) Long id,
			@RequestBody CategoryInput input) {
		return categoryService.update(id, input);
	}
	
	@GetMapping
	public List<CategoryOutput> getAll() {
		return categoryService.list();
	}
	
} 
