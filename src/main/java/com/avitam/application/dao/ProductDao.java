package com.avitam.application.dao;

import java.util.List;

import com.avitam.application.model.Product;

public interface ProductDao {
	List<Product> getProductsByCategory(int categoryId);

	Product getProductById(int productId);
}
