/*
 * 
 */
package com.incedo.booklib.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.booklib.constant.ResponseType;
import com.incedo.booklib.dto.Publisher;
import com.incedo.booklib.responsebean.RootResponse;
import com.incedo.booklib.service.PublisherService;

// TODO: Auto-generated Javadoc
/**
 * The Class BookResource.
 */
@CrossOrigin
@RestController
@RequestMapping("api/bookPublisher")
public class PublisherResource {

	@Autowired
	private PublisherService publisherService;

	@RequestMapping(method = RequestMethod.GET, params = {}, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<List<Publisher>> getAllBooksWithAvailableCount() throws Exception {
		return new RootResponse<List<Publisher>>(ResponseType.SUCCESS, publisherService.getAllPublishers());
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<Publisher> addPublisher(@RequestBody Publisher publisher) throws Exception {
		return new RootResponse<Publisher>(ResponseType.SUCCESS, publisherService.savePublisher(publisher));
	}

	@RequestMapping(value = "/{publisherId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<Publisher> updatePublisher(@PathVariable("publisherId") int publisherId,
			@RequestBody Publisher publisher) throws Exception {
		publisher.setId(publisherId);
		return new RootResponse<Publisher>(ResponseType.SUCCESS, publisherService.savePublisher(publisher));
	}

}
