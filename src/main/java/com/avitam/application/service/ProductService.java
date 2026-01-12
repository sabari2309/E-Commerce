package com.avitam.application.service;

import java.util.List;

import com.avitam.application.model.Product;

public interface ProductService {
  List<Product> fetchProductByCategory(int categoryId);

  Product findProductById(int productId);
}
