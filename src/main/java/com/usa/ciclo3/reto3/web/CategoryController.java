package com.usa.ciclo3.reto3.web;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * @author: Alix Rincón
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category>getCategoria(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category>getCategoryId(@PathVariable("id") int id){
        return categoryService.getCategoryId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return categoryService.deleteCategory(categoriaId);
    }
}
