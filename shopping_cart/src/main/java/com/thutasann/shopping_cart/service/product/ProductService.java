package com.thutasann.shopping_cart.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thutasann.shopping_cart.exceptions.ResourceNotFoundException;
import com.thutasann.shopping_cart.model.Category;
import com.thutasann.shopping_cart.model.Product;
import com.thutasann.shopping_cart.repository.CategoryRepository;
import com.thutasann.shopping_cart.repository.ProductRepository;
import com.thutasann.shopping_cart.request.AddProductRequest;
import com.thutasann.shopping_cart.request.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product addProduct(AddProductRequest request) {
        Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(request.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        request.setCategory(category);
        return productRepository.save(createProduct(request, category));
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete, () -> {
            throw new ResourceNotFoundException("Product not found!");
        });
    }

    @Override
    public Product updateProduct(ProductUpdateRequest request, Long productId) {
        return productRepository.findById(productId)
                .map(existingProduct -> updateExistingProduct(existingProduct, request)).map(productRepository::save)
                .orElseThrow(() -> new ResourceNotFoundException("Product not Found"));
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

    private Product createProduct(AddProductRequest request, Category category) {
        return new Product(
                request.getName(),
                request.getBrand(),
                request.getPrice(),
                request.getInventory(),
                request.getDescription(),
                category);
    }

    private Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request) {
        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setInventory(request.getInventory());
        existingProduct.setDescription(request.getDescription());

        Category category = categoryRepository.findByName(request.getCategory().getName());
        existingProduct.setCategory(category);
        return existingProduct;
    }

}
