package com.topas.microservicebatchasync.jpa.postgres.repo;

import org.springframework.data.repository.CrudRepository;

import com.topas.microservicebatchasync.jpa.postgres.domain.PostgresQ;
 

public interface PostgresQRepository extends CrudRepository<PostgresQ, Long> {

}
