package com.r2s.javabackend09.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name_product;
	private long price_product;
	@ManyToOne
	private Category category;
	
	 @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	   private List<VariantProduct> variantProducts;
	//Constructor
	public Products(int id, String name_product, long price_product, Category category) {
		this.id = id;
		this.name_product = name_product;
		this.price_product = price_product;
		this.category = category;
	}
	public Products() {
    }
	//Getter setter;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	public long getPrice_product() {
		return price_product;
	}

	public void setPrice_product(long price_product) {
		this.price_product = price_product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
