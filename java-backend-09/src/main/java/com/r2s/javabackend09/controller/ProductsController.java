package com.r2s.javabackend09.controller;

import com.r2s.javabackend09.model.Category;
import com.r2s.javabackend09.model.Products;
import com.r2s.javabackend09.service.ProductsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;
@RestController
public class ProductsController {
    
    @Autowired
    private ProductsService productsService;
    @GetMapping("/products/{categoryId}")
    public Page<Products> getProductsByCategory(@PathVariable int categoryId, Pageable pageable) {
    	pageable = PageRequest.of(0,2);
        return productsService.findByCategory_Id(categoryId, pageable);
    }
    
    @GetMapping("/products/productId/{Id}")
    public List<Products> getproProducts(@PathVariable int Id) {
    	return productsService.findById(Id);
    }
    
    @PostMapping("/admin/products/{categoryId}")
    public ResponseEntity<Products> addProduct(@PathVariable int categoryId, @RequestBody Products product) {
        Products addedProduct = productsService.addProduct(product, categoryId);
        return ResponseEntity.ok(addedProduct);
    }
    
    @PutMapping("/admin/products/{id}/{categoryId}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @PathVariable int categoryId, @RequestBody Products productDetails) {
            Products updatedProduct = productsService.updateProduct(id, productDetails, categoryId);
            return BaseResponseController.success(updatedProduct);
        
    }
}