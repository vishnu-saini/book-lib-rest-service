/*
 * 
 */
package com.incedo.booklib.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incedo.booklib.dto.Author;

/**
 * The Interface AuthorDao.
 */
@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {
}