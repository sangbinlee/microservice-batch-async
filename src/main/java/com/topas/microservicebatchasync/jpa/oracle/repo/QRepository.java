package com.topas.microservicebatchasync.jpa.oracle.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.topas.microservicebatchasync.jpa.oracle.domain.Q;


@Repository
public interface QRepository extends CrudRepository<Q, Long> {



}
