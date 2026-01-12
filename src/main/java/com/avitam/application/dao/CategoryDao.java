package com.avitam.application.dao;

import java.util.List;

import com.avitam.application.model.*;
public interface CategoryDao {
   List<Category> getAllCategories();

   Category getCategoryById(int categoryId);

   List<Category> getCategoriesById(int categoryId);
}
