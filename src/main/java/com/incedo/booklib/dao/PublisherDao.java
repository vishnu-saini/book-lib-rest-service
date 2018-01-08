/*
 * 
 */
package com.incedo.booklib.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.incedo.booklib.dto.Category;
import com.incedo.booklib.dto.Publisher;

@Repository
public interface PublisherDao extends JpaRepository<Publisher, Integer> {
}