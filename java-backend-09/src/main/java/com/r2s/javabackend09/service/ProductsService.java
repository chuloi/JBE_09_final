package com.r2s.javabackend09.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.r2s.javabackend09.model.Category;
import com.r2s.javabackend09.model.Products;
import com.r2s.javabackend09.repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductsRepository productsRepository;
	
	public Page<Products> findByCategory_Id(int categoryId, org.springframework.data.domain.Pageable pageable){
		return productsRepository.findByCategory_Id( categoryId, pageable );
	}
	
	public List<Products> findById(int Id) {
		return productsRepository.findById(Id);
	}
	public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }
    
	public Products addProduct(Products product, int categoryId) {
	    Category category = new Category();
	    category.setId(categoryId);
	    product.setCategory(category);
	    return productsRepository.save(product);
	}
    
    
	public Products updateProduct(int id, Products productDetails, int categoryId) {
        Products existingProduct = productsRepository.findByIdAndCategoryId(id, categoryId);
        existingProduct.setName_product(productDetails.getName_product());
        existingProduct.setPrice_product(productDetails.getPrice_product());
        
        return productsRepository.save(existingProduct);
    }
	    
}
