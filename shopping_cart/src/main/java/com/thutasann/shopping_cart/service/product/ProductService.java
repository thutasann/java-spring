package com.thutasann.shopping_cart.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thutasann.shopping_cart.exceptions.ResourceNotFoundException;
import com.thutasann.shopping_cart.model.Product;
import com.thutasann.shopping_cart.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public void deleteProductById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteProductById'");
    }

    @Override
    public void updateProduct(Product product, Long productId) {
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public List<Product> getAllProducts() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByCategory'");
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProducdtsByCategoryAndBrand(String category, String brand) {
        throw new UnsupportedOperationException("Unimplemented method 'getProducdtsByCategoryAndBrand'");
    }

    @Override
    public List<Product> getProductsByName(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByName'");
    }

    @Override
    public List<Product> getProductsByBrandAndName(String category, String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByBrandAndName'");
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String category) {
        throw new UnsupportedOperationException("Unimplemented method 'countProductsByBrandAndName'");
    }

}
