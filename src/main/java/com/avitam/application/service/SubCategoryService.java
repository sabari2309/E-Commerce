package com.avitam.application.service;

import java.util.List;

import com.avitam.application.model.SubCategory;

public interface SubCategoryService {
   List<SubCategory> getSubCategoriesById(int category_id);

   SubCategory getSubCategoryById(int sub_categoryId);
}
