package com.avitam.application.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.avitam.application.dao.CategoryDao;
import com.avitam.application.model.Category;
import com.avitam.application.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public CategoryServiceImpl() {
		System.out.println("Categorysservice bean created");
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Category category=categoryDao.getCategoryById(categoryId);
		return category;
	}

	@Override
	public List<Category> getSubCategoriesById(int id) {
		List<Category> sub_categories=categoryDao.getCategoriesById(id);
		if(sub_categories.size()==0) {
			return null;
		}
		return sub_categories;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

}
