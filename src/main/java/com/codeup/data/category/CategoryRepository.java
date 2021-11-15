package com.codeup.data.category;

import org.springframework.data.jpa.repository.*;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
