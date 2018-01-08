/*
 * 
 */
package com.incedo.booklib.service.Impl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incedo.booklib.aspect.Loggable;
import com.incedo.booklib.dao.StudentDao;
import com.incedo.booklib.dto.Student;
import com.incedo.booklib.exception.BooklibBusinessException;
import com.incedo.booklib.service.StudentService;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentServiceImpl.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	/** The student dao. */
	@Autowired
	StudentDao studentDao;

	/** The message source. */
	@Autowired
	MessageSource messageSource;

	/** The password encoder. */
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.incedo.booklib.service.StudentService#addStudent(com.incedo.booklib.
	 * dto.Student)
	 */
	@Override
	@Loggable
	public Student addStudent(Student student) {

		student.setPassword(passwordEncoder.encode(student.getPassword()));
		return studentDao.save(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.incedo.booklib.service.StudentService#authenticateStudent(com.incedo.
	 * booklib.dto.Student)
	 */
	@Override
	@Transactional(readOnly = true)
	@Loggable
	public boolean authenticateStudent(Student student) throws BooklibBusinessException {
		boolean result = false;

		if (student == null) {
			throw new BooklibBusinessException(messageSource.getMessage("error.student.object.null", null, Locale.US));
		}
		
		List<Student> students = studentDao.findStudentByEmailid(student.getEmail());
		if (students.size() != 0 && passwordEncoder.matches(student.getPassword(), students.get(0).getPassword())) {
			result = true;
		}
		return result;
	}

}
