/*
 * 
 */
package com.incedo.booklib.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incedo.booklib.dao.CategoryDao;
import com.incedo.booklib.dto.Category;
import com.incedo.booklib.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.findAll();
	}
	
	@Override
	public Category saveCategory(Category category) {
		return categoryDao.save(category);
	}
	
}
