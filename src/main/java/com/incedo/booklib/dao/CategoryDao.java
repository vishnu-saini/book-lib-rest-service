/*
 * 
 */
package com.incedo.booklib.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.incedo.booklib.dto.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
}