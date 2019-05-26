package com.topas.microservicebatchasync.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topas.microservicebatchasync.jpa.oracle.domain.Q;
import com.topas.microservicebatchasync.jpa.oracle.repo.PnrRepository;
import com.topas.microservicebatchasync.jpa.oracle.repo.QRepository;
import com.topas.microservicebatchasync.jpa.oracle.service.QService;

@RestController
@RequestMapping(path = "/q")
public class QController {

	@Autowired
	private PnrRepository pnrRepository;

	@Autowired
	private QRepository qRepository;

	@Autowired
	private QService qService;

	@PostMapping(path = "/create") // Map ONLY GET Requests
	public Q create(Q qModel) {
		return qService.create(qModel);
	}

	@GetMapping(path = "/retrive")
	public Iterable<Q> retrive() {
		return qService.retrive();
	}

	@GetMapping(path = "/retriveOne/{id}")
	public Optional<Q> retriveOne(@PathVariable Long id) {
		return qService.retriveOne(id);
	}

	@PostMapping(path = "/update")
	public Q update(Q qModel) {
		return qService.update(qModel);
	}

	@DeleteMapping(value = "/delete")
	public void delete() {
		qService.delete();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteOne(@PathVariable Long id) {
		qService.deleteOne(id);
	}
}
