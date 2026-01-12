package com.avitam.application.dao;

import java.util.List;

import com.avitam.application.model.SubCategory;

public interface SubCategoryDao {
   List<SubCategory> getSubCategoryById(int category_id);

   SubCategory getSubCat(int sub_categoryId);
}
