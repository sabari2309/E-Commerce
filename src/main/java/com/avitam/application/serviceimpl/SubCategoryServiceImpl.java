package com.avitam.application.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.avitam.application.dao.SubCategoryDao;
import com.avitam.application.model.SubCategory;
import com.avitam.application.service.SubCategoryService;

public class SubCategoryServiceImpl implements SubCategoryService {
    
	@Autowired
    private SubCategoryDao subCategoryDao;
	 
	public SubCategoryServiceImpl() {
		System.out.println("subCategorysservice bean created");
	}
	
	public void setSubCategoryDao(SubCategoryDao subCategoryDao) {
		this.subCategoryDao = subCategoryDao;
	}


	@Override
	public List<SubCategory> getSubCategoriesById(int category_id) {
		return subCategoryDao.getSubCategoryById(category_id);
	}

	@Override
	public SubCategory getSubCategoryById(int sub_categoryId) {
		return subCategoryDao.getSubCat(sub_categoryId);
	}
     
}
