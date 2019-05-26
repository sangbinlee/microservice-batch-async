package com.topas.microservicebatchasync.jpa.oracle.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topas.microservicebatchasync.jpa.oracle.domain.Q;
import com.topas.microservicebatchasync.jpa.oracle.repo.PnrRepository;
import com.topas.microservicebatchasync.jpa.oracle.repo.QRepository;

@Service
public class QService {

	@Autowired
	private PnrRepository pnrRepository;

	@Autowired
	private QRepository qRepository;

	public Q create(Q qModel) {

		qModel = new Q();
		qModel.setCode("1111");
		qModel.setName("created");
		qModel.setPrice(10.1);

		return qRepository.save(qModel);
	}

	public Iterable<Q> retrive() {
		return qRepository.findAll();
	}

	public Optional<Q> retriveOne(Long id) {
		return qRepository.findById(id);
	}

	public Q update(Q qModel) {
		qModel = new Q();
		qModel.setCode("1111");
		qModel.setName("updated");
		qModel.setPrice(99.1);
		return qRepository.save(qModel);
	}

	public void delete() {
		qRepository.deleteAll();
	}

	public void deleteOne(Long id) {
		qRepository.deleteById(id);
	}
}
