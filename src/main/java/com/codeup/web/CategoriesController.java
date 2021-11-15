package com.codeup.web;

import com.codeup.data.category.Category;
import com.codeup.data.category.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json")
public class CategoriesController {
    private final CategoryRepository categoryRepository;

    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("{name}")
    private Category getPostsByCategory(@PathVariable String name) {
        return categoryRepository.findByName(name);
    }

    @GetMapping
    private List<Category> getCategory(){
        return categoryRepository.findAll();
    }

}
