package Basics;

import java.util.ArrayList;
import java.util.List;

class SubSubCategory {
    private String name;

    public SubSubCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class SubCategory {
    private String name;
    private List<SubSubCategory> subSubCategories;

    public SubCategory(String name) {
        this.name = name;
        this.subSubCategories = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubSubCategory> getSubSubCategories() {
        return this.subSubCategories;
    }

    public void addSubSubCategory(SubSubCategory subSubCategory) {
        this.subSubCategories.add(subSubCategory);
    }
}

class Category {
    private String name;
    private List<SubCategory> subCategories;

    public Category(String name) {
        this.name = name;
        this.subCategories = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategory> getSubCategories() {
        return this.subCategories;
    }

    public void addSubCategory(SubCategory subCategory) {
        this.subCategories.add(subCategory);
    }
}

public class NestedObject {
    public void SampleOne() {
        System.out.println("\n=========> Nested Object Sample One");

        // Create a category
        Category category = new Category("Electronics");

        // Create subcategories
        SubCategory phones = new SubCategory("Phones");
        SubCategory laptops = new SubCategory("Laptops");

        // Add sub-subcategories
        phones.addSubSubCategory(new SubSubCategory("Smartphones"));
        phones.addSubSubCategory(new SubSubCategory("Feature Phones"));

        laptops.addSubSubCategory(new SubSubCategory("Gaming Laptops"));
        laptops.addSubSubCategory(new SubSubCategory("Ultrabooks"));

        // Add subcategories to category
        category.addSubCategory(phones);
        category.addSubCategory(laptops);

        for (SubCategory subCategory : category.getSubCategories()) {
            System.out.println("  SubCategory: " + subCategory.getName());
            for (SubSubCategory subSubCategory : subCategory.getSubSubCategories()) {
                System.out.println("    SubSubCategory: " + subSubCategory.getName());
            }
        }
    }
}
