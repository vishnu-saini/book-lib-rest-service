/*
 * 
 */
package com.incedo.booklib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.incedo.booklib.constant.QueryConstant;
import com.incedo.booklib.dto.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentDao.
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	
	/**
	 * Find student by emailid.
	 *
	 * @param email the email
	 * @return the list
	 */
	@Query(value=QueryConstant.FIND_STUDENT_BY_EMAIL)
	public List<Student> findStudentByEmailid(@Param("email") String email);
	
}