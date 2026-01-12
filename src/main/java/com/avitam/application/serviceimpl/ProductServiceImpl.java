package com.avitam.application.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.avitam.application.dao.ProductDao;
import com.avitam.application.model.Product;
import com.avitam.application.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	public ProductServiceImpl() {
		System.out.println("productservice bean created");
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> fetchProductByCategory(int categoryId) {
		return productDao.getProductsByCategory(categoryId);
	}

	@Override
	public Product findProductById(int productId) {
		return productDao.getProductById(productId);
	}

}
