/*
 * 
 */
package com.incedo.booklib.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incedo.booklib.dao.PublisherDao;
import com.incedo.booklib.dto.Publisher;
import com.incedo.booklib.service.PublisherService;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	PublisherDao publisherDao;

	@Override
	public List<Publisher> getAllPublishers() {
		return publisherDao.findAll();
	}

	@Override
	public Publisher savePublisher(Publisher publiser) {
		return publisherDao.save(publiser);
	}


	
}
