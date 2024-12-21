package com.thutasann.shopping_cart.service.product;

import java.util.List;

import com.thutasann.shopping_cart.model.Product;
import com.thutasann.shopping_cart.request.AddProductRequest;
import com.thutasann.shopping_cart.request.ProductUpdateRequest;

public interface IProductService {
    Product addProduct(AddProductRequest product);

    Product getProductById(Long id);
    
    void deleteProductById(Long id);
    
    Product updateProduct(ProductUpdateRequest product, Long productId);
    
    List<Product> getAllProducts();

    List<Product> getProductsByCategory(Long categoryId);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProducdtsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByBrandAndName(String category, String name);

    Long countProductsByBrandAndName(String brand, String category);
}
