package com.projetoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoweb.course.entities.Category;
import com.projetoweb.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		
		return categoryRepository.findAll();
	}
	
	public Category findById(Long Id){
		
		Optional<Category> obj = categoryRepository.findById(Id);
		
		return obj.get();
	}
}
