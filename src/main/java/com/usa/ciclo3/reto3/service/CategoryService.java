package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Alix Rincón
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryCrudRepository;

    /**
     * 
     * @return
     */
    public List<Category> getAll() {
        return categoryCrudRepository.getAll();
    }

    /**
     * 
     * @param CategoryId
     * @return
     */
    public Optional<Category> getCategoryId(int CategoryId) {
        return categoryCrudRepository.getCategoryId(CategoryId);
    }

    /**
     * 
     * @param Category
     * @return
     */
    public Category saveCategory(Category Category) {
        if (Category.getId() == null) {
            return categoryCrudRepository.saveCategory(Category);
        } else {
            Optional<Category> Category1 = categoryCrudRepository.getCategoryId(Category.getId());
            if (Category1.isEmpty()) {
                return categoryCrudRepository.saveCategory(Category);
            } else {
                return Category;
            }
        }
    }

    /**
     * 
     * @param Category
     * @return
     */
    public Category update(Category Category) {
        if (Category.getId() != null) {
            Optional<Category> c = categoryCrudRepository.getCategoryId(Category.getId());
            if (!c.isEmpty()) {
                if (Category.getDescription() != null) {
                    c.get().setDescription(Category.getDescription());
                }
                if (Category.getName() != null) {
                    c.get().setName(Category.getName());
                }
                return categoryCrudRepository.saveCategory(c.get());
            }
        }
        return Category;
    }

    /**
     * 
     * @param CategoryId
     * @return
     */
    public boolean deleteCategory(int CategoryId) {
        Boolean d = getCategoryId(CategoryId).map(Category -> {
            categoryCrudRepository.delete(Category);
            return true;
        }).orElse(false);
        return d;
    }
}
