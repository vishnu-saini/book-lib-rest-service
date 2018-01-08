/*
 * 
 */
package com.incedo.booklib.service;

import java.util.List;

import com.incedo.booklib.dto.Category;

public interface CategoryService {

	List<Category> getAllCategories();

	Category saveCategory(Category category);

}
