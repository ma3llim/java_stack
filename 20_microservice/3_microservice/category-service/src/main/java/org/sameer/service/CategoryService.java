package org.sameer.service;

import org.sameer.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    List<Category> getAllCategories();

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}
