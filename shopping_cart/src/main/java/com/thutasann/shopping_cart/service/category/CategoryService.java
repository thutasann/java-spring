package com.thutasann.shopping_cart.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thutasann.shopping_cart.exceptions.AlreadyExistsException;
import com.thutasann.shopping_cart.exceptions.ResourceNotFoundException;
import com.thutasann.shopping_cart.model.Category;
import com.thutasann.shopping_cart.repository.CategoryRepository;
import com.thutasann.shopping_cart.utils.CacheStore;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final CacheStore<Long, Category> cacheStore = new CacheStore<>();

    @Override
    public Category getCategoryById(Long id) {

        Category cachedCategory = cacheStore.get(id);
        if (cachedCategory != null) {
            return cachedCategory;
        }

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        cacheStore.put(id, category, 600_000); // 10 minutes;
        return category;
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.of(category).filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository::save)
                .orElseThrow(() -> new AlreadyExistsException(category.getName() + " already exists"));
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id)).map(oldCategory -> {
            oldCategory.setName(category.getName());
            return categoryRepository.save(oldCategory);
        }).orElseThrow(() -> new ResourceNotFoundException("Catgory not found"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id).ifPresentOrElse(categoryRepository::delete, () -> {
            throw new ResourceNotFoundException("category not found");
        });
    }

}
