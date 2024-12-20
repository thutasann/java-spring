package com.thutasann.shopping_cart.service.product;

import java.util.List;

import com.thutasann.shopping_cart.model.Product;

public interface IProductService {
    Product addProduct(Product product);

    Product getProductById(Long id);
    
    void deleteProductById(Long id);
    
    void updateProduct(Product product, Long productId);
    
    List<Product> getAllProducts();

    List<Product> getProductsByCategory(Long categoryId);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProducdtsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByBrandAndName(String category, String name);

    Long countProductsByBrandAndName(String brand, String category);
}
