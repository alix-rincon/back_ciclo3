package com.usa.ciclo3.reto3.repository;

import org.springframework.stereotype.Repository;
import com.usa.ciclo3.reto3.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.usa.ciclo3.reto3.model.Category;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategoryId(int id) {
        return categoryCrudRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryCrudRepository.save(category);
    }

    public void delete(Category category){
        categoryCrudRepository.delete(category);
    }
}
