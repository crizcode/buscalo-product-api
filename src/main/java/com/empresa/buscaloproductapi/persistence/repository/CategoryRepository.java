package com.empresa.buscaloproductapi.persistence.repository;

import com.empresa.buscaloproductapi.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
