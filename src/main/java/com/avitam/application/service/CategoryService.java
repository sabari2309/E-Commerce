package com.avitam.application.service;

import java.util.List;

import com.avitam.application.model.Category;

public interface CategoryService {
    List<Category> getSubCategoriesById(int id);

	Category getCategoryById(int categoryId);

	List<Category> getAllCategories();
}

