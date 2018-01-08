/*
 * 
 */
package com.incedo.booklib.resource;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.booklib.aspect.Loggable;
import com.incedo.booklib.constant.ResponseType;
import com.incedo.booklib.dto.Student;
import com.incedo.booklib.dto.validation.group.StudentLoginValidationStep1;
import com.incedo.booklib.dto.validation.group.StudentLoginValidationStep2;
import com.incedo.booklib.responsebean.LoginResponse;
import com.incedo.booklib.responsebean.RootResponse;
import com.incedo.booklib.service.StudentService;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentResource.
 */
@RestController
@RequestMapping("student")
public class StudentResource {

	/** The student service. */
	@Autowired
	private StudentService studentService;

	/** The Message source. */
	@Autowired
	private MessageSource MessageSource;

	/**
	 * Adds the student.
	 *
	 * @param student
	 *            the student
	 * @return the root response
	 */
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<Student> addStudent(@RequestBody Student student) {
		return new RootResponse<Student>(ResponseType.SUCCESS, studentService.addStudent(student));
	}

	/**
	 * Authenticate student.
	 *
	 * @param student
	 *            the student
	 * @return the root response
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Loggable
	public RootResponse<LoginResponse> authenticateStudent(@Validated({ StudentLoginValidationStep1.class,
			StudentLoginValidationStep2.class }) @RequestBody Student student) throws Exception {
		LoginResponse loginResponse = new LoginResponse();
		if (studentService.authenticateStudent(student)) {
			loginResponse.setAuthenticated(true);
			loginResponse.setMessage(MessageSource.getMessage("success.login", null, Locale.US));
		} else {
			loginResponse.setAuthenticated(false);
			loginResponse.setMessage(MessageSource.getMessage("error.login.credential.incorrect", null, Locale.US));
		}

		return new RootResponse<LoginResponse>(ResponseType.SUCCESS, loginResponse);
	}

}
