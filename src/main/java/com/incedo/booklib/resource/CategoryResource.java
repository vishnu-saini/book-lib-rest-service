/*
 * 
 */
package com.incedo.booklib.resource;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.booklib.constant.ResponseType;
import com.incedo.booklib.dto.Category;
import com.incedo.booklib.requestbean.LoanRequest;
import com.incedo.booklib.responsebean.BookResponse;
import com.incedo.booklib.responsebean.RootResponse;
import com.incedo.booklib.service.CategoryService;

// TODO: Auto-generated Javadoc
/**
 * The Class BookResource.
 */
@CrossOrigin
@RestController
@RequestMapping("api/bookCategory")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET, params = {}, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<List<Category>> getAllBooksWithAvailableCount() throws Exception {
		return new RootResponse<List<Category>>(ResponseType.SUCCESS, categoryService.getAllCategories());
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<Category> addCategory(@RequestBody Category category) throws Exception {
			return new RootResponse<Category>(ResponseType.SUCCESS, categoryService.saveCategory(category));
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<Category> updateCategory(@RequestBody Category category) throws Exception {
			return new RootResponse<Category>(ResponseType.SUCCESS, categoryService.saveCategory(category));
	}

}
