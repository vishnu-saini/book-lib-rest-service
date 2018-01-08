/*
 * 
 */
package com.incedo.booklib.service;

import java.util.List;

import com.incedo.booklib.dto.Publisher;

public interface PublisherService {

	List<Publisher> getAllPublishers();

	Publisher savePublisher(Publisher publiser);

}
